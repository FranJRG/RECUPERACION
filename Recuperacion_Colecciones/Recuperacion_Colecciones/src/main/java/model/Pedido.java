package main.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pedido {

	private int id;
	private String codigo;
	private Status status;

	private Cliente cliente;
	private Set<Linea>lineas;
	private Pedido p;
	private Producto producto;
	private static int secuencia=0;
	
	public Pedido(int idPedido) {
		this.id=Pedido.secuencia++;
	}
	
	public Pedido(String codigo, Status status, Cliente cliente) {
		super();
		this.codigo=codigo;
		this.status=status;
		this.cliente=cliente;
		this.lineas=new HashSet<>();
	}
	
	public void addLinea(Linea l) {
		
		if(l!=null) {
			lineas.add(l);
		}
		
	}
	
	public void borrarLinea(int id) {
		
		for (Linea linea : lineas) {
			if(lineas.contains(linea)&& linea.getId()==id && !p.getStatus().equals(Status.ENVIADO)) {
				lineas.remove(linea);
			}
		}
		
	}
	
	public void vaciarPedido() {
		lineas.clear();
	}
	
	public double getCostePedido() {
		double coste=0;
		
		for (Linea linea : lineas) {
			if(linea!=null) {
				for (Producto p : linea.getProductos()) {
					coste=p.getPrecioUnitario()*linea.getCantidad();
					linea.setImporte(coste);
				}
			}
		}
		
		return coste;
	}
	
	public int getNumeroProductos() {
		int cont=0;
		
		for (Linea linea : lineas) {
			if(linea.getIdProducto()!=null) {
				cont++;
			}
		}
		return cont;
	}
	
	public String mostrarLineasPorIDAscendente() {
		StringBuilder sb=new StringBuilder();
		
		List<Linea>lineas=new ArrayList<>();
		
		
		Collections.sort(lineas, new CompararLineaPorID());
		
		for (Linea linea : lineas) {
			if(linea!=null) {
				sb.append(linea);
			}
		}
		return sb.toString();
	}
	
	public int getId(Cliente c) {
		return c.getId();
	}
	
	public String mostrarLineasPorPrecioDescendete() {
	StringBuilder sb=new StringBuilder();
		
		List<Linea>lineas=new ArrayList<>();
		
		
		Collections.sort(lineas, new CompararLineaPorPrecioDesc());
		
		for (Linea linea : lineas) {
			if(linea!=null) {
				sb.append(linea);
			}
		}
		return sb.toString();
	}
	
	public String obtenerProductos() {
		StringBuilder sb=new StringBuilder();
		
		for (Linea linea : lineas) {
			if(linea.getIdProducto()!=null) {
				sb.append(linea.getIdProducto());
			}
		}
		return sb.toString();
	}
	
	public Status getStatus() {
		return status;
	}

	public Set<Linea> getLineas() {
		return lineas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", codigo=" + codigo + ", status=" + status + ", cliente=" + cliente + ", lineas="
				+ lineas + ", p=" + p + ", producto=" + producto + "]";
	}
	
	public String toCSVString() {
		return String.format("%s,%s,%s,%s", this.id,this.codigo,this.status,getId(this.cliente));
	}
	
	
}
