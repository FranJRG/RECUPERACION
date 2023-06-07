package restaurante;

import java.util.Arrays;

import restaurante.model.Cliente;
import restaurante.model.ClienteNoExisteException;
import restaurante.model.CompararAlergenoEdad;
import restaurante.model.CompararProductoAlergeno;
import restaurante.model.Producto;
import restaurante.model.ServicioNoDisponibleException;

public class Restaurante {

	private Producto[] cartaProducto=new Producto[NUM_MAXIMO_PRODUCTOS];
	private int ultimoProducto;
	private static final int NUM_MAXIMO_PRODUCTOS = 100;
	private Cliente[] clientes=new Cliente[NUM_MAXIMO_CLIENTES];
	private static final int NUM_MAXIMO_CLIENTES = 20;
	public static int secuenciaGlobal;
	private Cliente cliente;
	
	
	public Restaurante(Producto[] cartaProducto, int ultimoProducto, Cliente[] clientes) {
		super();
		this.cartaProducto = cartaProducto;
		this.ultimoProducto = ultimoProducto;
		this.clientes = clientes;
	}

	public boolean darAltaCliente(Cliente c1) {
		boolean alta=false;
		
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i].getCodigoCliente()==null && i<NUM_MAXIMO_CLIENTES) {
				alta=true;
				clientes[i]=c1;
			}
		}
		
		return alta;
	}
	
	public boolean darAltaProducto(Producto p1) {
		boolean dadoAlta=false;
		
		for(int i=0;i<cartaProducto.length;i++) {
			if(cartaProducto[i]==null && i<NUM_MAXIMO_PRODUCTOS) {
				dadoAlta=true;
				cartaProducto[i]=p1;
			}
		}
		
		return dadoAlta;
	}
	
	public boolean darBajaProdcuto(Producto p1) {
		boolean darBaja=false;
		
		for(int i=0;i<cartaProducto.length;i++) {
			if(cartaProducto[i].equals(p1) && p1!=null) {
				darBaja=true;
				cartaProducto[i]=null;
			}
		}
		
		return darBaja;
	}
	
	private int obtenerPosicionCliente(String cliente) {
		int pos=-1;
		
		for(int i=0;i<clientes.length;i++) {
			if(cliente!=null && clientes[i].equals(cliente)) {
				pos=i;
			}
		}
		return pos;
	}
	
	private int obtenerPosicionProducto(String producto) {
		int pos=-1;
		
		for(int i=0;i<cartaProducto.length;i++) {
			if(producto!=null && cartaProducto[i].equals(producto)) {
				pos=i;
			}
		}
		return pos;
	}
	
	public boolean registrarProductoACliente(String producto,String cliente) throws ClienteNoExisteException, ServicioNoDisponibleException  {
		boolean puedeRegistrar=false;
		
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i]!=null && cliente!=null && clientes[i].equals(cliente)) {
				for(int y=0;i<cartaProducto.length;i++) {
					if(producto!=null && cartaProducto[y]!=null && cartaProducto[y].equals(producto)) {
						puedeRegistrar=true;
						clientes[i].registrarConsumo(cartaProducto[y]);
					}
				}
			}else {
				throw new ClienteNoExisteException("El cliente no existe");
			}
		}
		
		return puedeRegistrar;
	}
	
	public boolean registrarServicioACliente(String producto,String cliente) throws ServicioNoDisponibleException {
		boolean puedeRegistrar=false;
		
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i]!=null && cliente!=null && clientes[i].equals(cliente)) {
				for(int y=0;i<cartaProducto.length;i++) {
					if(producto!=null && cartaProducto[y]!=null && cartaProducto[y].equals(producto)) {
						puedeRegistrar=true;
						clientes[i].solicitarServicio(cartaProducto[y]);
					}
				}
			}
		}
		
		return puedeRegistrar;
	}
	
	public String obtenerProductosPorAlergenos() {
		StringBuilder sb=new StringBuilder();
		
		Arrays.sort(cartaProducto, new CompararProductoAlergeno());
		
		for (Producto producto : cartaProducto) {
			sb.append(producto);
		}
		
		return sb.toString();
	}
	
	public String obtenerClientesPorAlergiaEdad() {
		StringBuilder sb=new StringBuilder();
		
		Arrays.sort(clientes, new CompararAlergenoEdad());
		
		for (Cliente cliente : clientes) {
			sb.append(cliente);
		}
		
		return sb.toString();
	}
	
	public String obtenerClientesNoBebedores() {
		StringBuilder sb=new StringBuilder();
		
		for (Cliente cliente : clientes) {
			if(!cliente.esBebedor()) {
				sb.append(cliente);
			}
		}
		
		return sb.toString();
	}
	
	public String obtenerClientesPorConsumo() {
		StringBuilder sb=new StringBuilder();
		
		Arrays.sort(clientes, new CompararClientePorConsumo());
		
		for (Producto cliente : this.cliente.getConsumos()) {
			if(cliente!=null) {
				sb.append(cliente);
			}
		}
		return sb.toString();
	}
}
