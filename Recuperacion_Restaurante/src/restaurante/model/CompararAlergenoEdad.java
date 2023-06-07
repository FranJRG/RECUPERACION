package restaurante.model;

import java.util.Comparator;

public class CompararAlergenoEdad implements Comparator<Cliente> {

	
	public int compare(Cliente o1, Cliente o2) {
		int result=0;
		
		if(o1!=null && o2!=null) {
			result=Integer.compare(o1.getEdadActual(), o2.getEdadActual());
		}else if(o1==null) {
			result=1;
		}else if(o2==null) {
			result=-1;
		}
		
		return result;
	}
	
	public int compareAlergeno(Cliente o1, Cliente o2) {
		int result=0;
		
		if(o1!=null && o2!=null) {
			result=o1.getAlergico().compareTo(o2.getAlergico());
		}else if(o1==null) {
			result=1;
		}else if(o2==null) {
			result=-1;
		}
		
		return result;
	}
	
	
	
	
}
