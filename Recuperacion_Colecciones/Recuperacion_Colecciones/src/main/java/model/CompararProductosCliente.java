package main.java.model;

import java.util.Comparator;

public class CompararProductosCliente implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null) {
			if(resultado==0) {
				resultado=Integer.compare(o1.getId(), o1.getId());
			}
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		return resultado;
	}





}
