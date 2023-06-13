package restaurante;

import java.util.Arrays;

import restaurante.model.Cliente;
import restaurante.model.ClienteNoDisponibleException;
import restaurante.model.ComparaProductoAlergeno;
import restaurante.model.CompararPorAlergenoEdad;
import restaurante.model.Producto;
import restaurante.model.ServicioNoDisponibleException;

public class Restaurante {

	
	private Producto[] cartaProducto;
	private int ultimoProductoCarta;
	private static final int NUM_MAXIMO_PRODUCTOS = 100;
	
	private Cliente[] clientes;
	private int ultimoCliente;
	private static final int NUM_MAXIMO_CLIENTES = 20;

	public static int secuenciaGlobal;
	private Cliente cliente;


	public Restaurante() {
		super();
		this.clientes=new Cliente[NUM_MAXIMO_CLIENTES];
		this.cartaProducto=new Producto[NUM_MAXIMO_PRODUCTOS];
	}
	

	public boolean darAltaCliente(Cliente cliente) throws ClienteNoDisponibleException {
		boolean alta=false;
		
		if(ultimoCliente<clientes.length) {
			clientes[ultimoCliente]=cliente;
			ultimoCliente++;
			alta=true;
		}else {
			throw new ClienteNoDisponibleException("El cliente no se puede dar de alta");
		}
		
		return alta;
	}
	

	public boolean darAltaProducto(Producto bebidaOPlato){
		boolean alta=false;
		
		if(ultimoProductoCarta<cartaProducto.length) {
			cartaProducto[ultimoProductoCarta]=bebidaOPlato;
			ultimoProductoCarta++;
			alta=true;
		}
		
		return alta;
	}
	

	public boolean darBajaProducto(Producto bebidaOPlato) {
		boolean baja=false;
		
		for(int i=0;i<cartaProducto.length;i++) {
			if(bebidaOPlato!=null && cartaProducto[i].equals(bebidaOPlato) && cartaProducto[i]!=null) {
				cartaProducto[i]=null;
				baja=true;
			}
		}
		return baja;
	}
	

	private int obtenerPosicionCliente(String codigo) {
		int pos=-1;
		
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i]!=null && clientes[i].getCodigoCliente().equals(codigo)) {
				pos=i;
			}
		}
		
		return pos;
	}
	
	
	private int obtenerPosicionProducto(String codigo) {
		int pos=-1;
		
		for(int i=0;i<cartaProducto.length;i++) {
			if(cartaProducto[i]!=null && cartaProducto[i].equals(codigo)) {
				pos=i;
			}
		}
		return pos;
	}
	
	
	public boolean registrarProductoACliente(String codigoCliente, String codigoProducto ) throws ServicioNoDisponibleException, ClienteNoDisponibleException {
		boolean registrar=false;
		
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i]!=null && codigoCliente!=null && clientes[i].getCodigoCliente().equals(codigoCliente)) {
				for(int y=0;y<cartaProducto.length;y++) {
					if(cartaProducto[y]!=null && codigoProducto!=null && cartaProducto[y].equals(codigoProducto)) {
						registrar=true;
						clientes[i].registrarConsumo(cartaProducto[y]);
					}
				}
			}else {
				throw new ClienteNoDisponibleException("El cliente no existe");
			}
		}
		return registrar;
	}
	
	
	public boolean registrarServicioACliente(Cliente cliente, Producto producto) throws ServicioNoDisponibleException, ClienteNoDisponibleException {
		boolean registrar=false;
		
		for(int i=0;i<clientes.length;i++) {
			if(clientes[i]!=null && cliente!=null && clientes[i].getCodigoCliente().equals(cliente)) {
				for(int y=0;y<cartaProducto.length;y++) {
					if(cartaProducto[y]!=null && producto!=null && cartaProducto[y].equals(producto)) {
						registrar=true;
						clientes[i].solicitarServicio(cartaProducto[y]);
					}
				}
			}else {
				throw new ClienteNoDisponibleException("El cliente no existe");
			}
		}
		return registrar;
	}

	
	public String obtenerProductosPorAlergenos() {
		StringBuilder sb=new StringBuilder();
		
		Arrays.sort(cartaProducto, new ComparaProductoAlergeno());
		
		for (Producto producto : cartaProducto) {
			if(producto!=null) {
				sb.append(producto);
			}
		}
		
		return sb.toString();
		
	}
	
	
	public String obtenerClientesPorAlergiaEdad() { 
		StringBuilder sb=new StringBuilder();
		
		Arrays.sort(clientes, new CompararPorAlergenoEdad());
		
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
		
		Arrays.sort(clientes, new CompararClienteConsumo());
		
		for (Producto cliente : this.cliente.getConsumos()) {
			if(cliente!=null) {
				sb.append(cliente);
			}
		}
		
		return sb.toString();
		
	}

	
	
}

