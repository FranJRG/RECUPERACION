package main.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Negocio {

	private Set<Cliente>clientes;
	private List<Pedido> pedidos;
	private Catalogo catalogo;
	
	public Negocio() {
		super();
		this.clientes=new HashSet<>();
		this.pedidos=new ArrayList<>();
	}
	
	public boolean añadirPedido(Pedido p) {
		boolean añadir=false;
		
		if(p!=null) {
			añadir=true;
			pedidos.add(p);
		}
		return añadir;
	}
	
	public boolean eliminarPedido(Pedido pedido) {
		boolean eliminar=false;
		
		Iterator<Pedido>it=pedidos.iterator();
		
		while(it.hasNext()){
			Pedido p=it.next();
			if(p!=null) {
				if(p.equals(pedido)) {
					it.remove();
					eliminar=true;	
				}
			}
			
		}
		
		return eliminar;
	}
	
	
	public boolean addCliente(Cliente c) throws ClienteException{
		boolean añadir=false;
		
		if(c!=null && c.esMayorEdad()) {
			clientes.add(c);
			añadir=true;
		}else {
			throw new ClienteException("El cliente no se puede añadir");
		}
		return añadir;
	}
	
	public boolean eliminarCliente(String nombre) throws ClienteException { 
		boolean eliminar=false;
		
		
		Iterator<Cliente>it=clientes.iterator();
		
		while(it.hasNext()) {
			Cliente c=it.next();
			if(c.getNombre().equals(nombre)) {
				if(!tienePedido(c)) {
					eliminar=true;
					it.remove();
				}else {
					throw new ClienteException("Tiene un pedido asociado");
				}
			}else {
				throw new ClienteException("El cliente no se puede eliminar");
			}
		}
		
		/*for (Cliente cliente : clientes) {
			if(cliente.getNombre().equals(nombre) && cliente.getP()==null) {
				eliminar=true;
				clientes.remove(cliente);
			}else {
				throw new ClienteException("El cliente no se puede eliminar porque no existe o tiene algun pedido asignado");
			}
		}*/
		return eliminar;
	}
	

	public boolean tienePedido(Cliente c) {
		boolean tiene=false;
		
		for (Pedido pedido : pedidos) {
			if(pedido.getCliente().equals(c)) {
				tiene=true;
			}
		}
		
		return tiene;
	}
	
	public String listarClientesPorImporteVente() { //PREGUNTAR
		StringBuilder sb=new StringBuilder();
		List<Cliente>listaClientes=new ArrayList<>(clientes);
		
		//Collections.sort(listaClientes, new ComparaClientesPorImporte());
		
		for (Cliente cliente : clientes) {
			if(cliente!=null) {
				sb.append(cliente);
			}
		}
		return sb.toString();
	}
	
	public String listarClientesPorEdad() {
		StringBuilder sb=new StringBuilder();
		List<Cliente>listaClientes=new ArrayList<>(clientes);
		
		Collections.sort(listaClientes, new CompararClienteEdad());
		
		for (Cliente cliente : clientes) {
			if(cliente!=null) {
				sb.append(cliente);
			}
		}
		return sb.toString();
	}
	
	public String mostrarProductosPorCliente() {
		StringBuilder sb=new StringBuilder();
		
		List<Producto>productosC=new ArrayList<>();
		
		for (Cliente cliente : clientes) {
			if(cliente!=null) {
				sb.append(cliente.getNombre());
				
				for (Producto producto : catalogo.getProductos()) {
					if(producto!=null) {
						sb.append(producto.getNombre());
					}
				}
			}
		}
		
		return sb.toString();
	}
	
	public String mostrarPedidosYLineasPorID() {
		StringBuilder sb=new StringBuilder();
		
		return sb.toString();
	}
	
	public String mostrarPedidosYLineasPorPrecio() {
		StringBuilder sb=new StringBuilder();
		
		return sb.toString();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	@Override
	public String toString() {
		return "Negocio [clientes=" + this.clientes + "]";
	}
	
	public Map<Status, List<Pedido>>agruparPorEstado(List<Pedido>pedidos){
		
		Map<Status, List<Pedido>>resultado=new HashMap<>();
		
		for (Pedido p : pedidos) {
			if(!resultado.containsKey(p.getStatus())) {
				resultado.put(p.getStatus(), new ArrayList<>());
			}
			resultado.get(p.getStatus()).add(p);
		}
		
		return resultado;
	}
	
}
