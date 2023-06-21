package main.java.model;

import java.util.Comparator;

public class CompararClienteEdad implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null) {
			if(resultado==0) {
				resultado=Integer.compare(o1.getEdad(), o2.getEdad());
			}
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		return 0;
	}

	
	
	
}
