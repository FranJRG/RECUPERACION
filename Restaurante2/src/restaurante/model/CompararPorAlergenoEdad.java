package restaurante.model;

import java.util.Comparator;

public class CompararPorAlergenoEdad implements Comparator<Cliente>{

	
	public int compare(Cliente o1, Cliente o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null){
			resultado=Integer.compare(o1.getEdadActual(),o2.getEdadActual());
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		
		return resultado;
	}

	public int compareAlergeno(Cliente o1, Cliente o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null){
			resultado=o1.getAlergia().compareTo(o2.getAlergia());
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		
		return resultado;
	}
	
}
