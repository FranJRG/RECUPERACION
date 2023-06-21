package main.java.model;

import java.util.Comparator;

public class ComparaClientesPorImporte implements Comparator<Pedido>{

	@Override
	public int compare(Pedido o1, Pedido o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null) {
			if(resultado==0) {
				resultado=Double.compare(o1.getCostePedido(),o2.getCostePedido());
			}
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		return resultado;
	}

}
