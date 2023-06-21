package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Linea {

	private int id;
	private String codigo;
	private int cantidad;
	private double importe;
	private Pedido idProducto;
	private Producto p;
	private List<Producto>productos;
	private static int secuencia=0;
	
	public Linea() {
		super();
		this.productos=new ArrayList<>();
	}
	
	public Linea(String codigo, Producto descripcion, Pedido idProducto, int cantidad, double importe) {
		super();
		this.id=Linea.secuencia++;
		this.codigo=codigo;
		this.p=descripcion;
		this.idProducto=idProducto;
		this.cantidad=cantidad;
		this.importe=importe;
		this.productos=new ArrayList<>();
	}
	
	public boolean addProducto(Producto p) throws ProductoException {
		boolean añadir=false;
			if(p!=null && p.isActive()) {
				añadir=true;
				productos.add(p);
			}else {
				throw new ProductoException("Su producto no esta activo no se puede añadir");
			}
		return añadir;
	}
	
	public boolean eliminarProducto(int id) throws ProductoException {
		boolean eliminar=false;
		
		for (Producto producto : productos) {
			if(producto!=null && producto.getId()==id) {
				eliminar=true;
				productos.remove(producto);
			}else {
				throw new ProductoException("Su producto no se ha podido eliminar ya que no existe en el sistema");
			}
		}
		
		return eliminar;
	}
	
	public boolean vaciarLinea() {
		return productos.removeAll(productos);
	}

	public int getId() {
		return id;
	}
	

	public Pedido getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	@Override
	public String toString() {
	    return String.format("%s,%s,%s,%s,%s,%s", this.id, this.codigo, this.p.getDescripcion(), this.idProducto.getId(), this.cantidad, this.importe);
	}

	
	
	
}
