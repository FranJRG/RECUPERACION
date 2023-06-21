package main.java.model;

import java.util.Comparator;

public class CompararLineaPorID implements Comparator<Linea>{

	@Override
	public int compare(Linea o1, Linea o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null) {
			if(resultado==0) {
				resultado=Integer.compare(o1.getId(), o2.getId());
			}
		}else if(o1==null){
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		return resultado;
	}

}
