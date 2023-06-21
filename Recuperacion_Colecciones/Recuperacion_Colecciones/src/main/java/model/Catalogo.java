package main.java.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalogo {

	private List<Producto>productos;
	
	public Catalogo() {
		super();
		this.productos=new ArrayList<>();
	}
	
	public boolean addProductoCatalogo(Producto p) throws ProductoException {
		boolean añadir=false;
		
		if(p!=null && !productos.contains(p)) {
			productos.add(p);
			añadir=true;
		}else {
			throw new ProductoException("El producto ya ha sido añadido");
		}
		return añadir;
	}
	
	public boolean eliminarProductoCatalogo(Producto p) {
		boolean eliminar=false;
		
		Iterator<Producto>it=productos.iterator();
		
		while(it.hasNext()) {
			Producto producto=it.next();
			if(productos.contains(producto) && producto!=null) {
				eliminar=true;
				it.remove();
			}
		}
		return eliminar;
	}
	
	public String mostrarProductos() {
		StringBuilder sb=new StringBuilder();
		
		for (Producto producto : productos) {
			if(producto!=null) {
				sb.append(producto);
			}	
		}
		
		return sb.toString();
	}
	
	public String mostrarProductosActivos() {
		StringBuilder sb=new StringBuilder();
		
		for (Producto producto : productos) {
			if(producto!=null && producto.isActive()) {
				sb.append(producto);
			}
		}
		
		return sb.toString();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	@Override
	public String toString() {
		return "Catalogo [productos=" + productos + "]";
	}
	
	
	
}
