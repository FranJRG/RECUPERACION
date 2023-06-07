package restaurante.model;

import java.util.Comparator;

public class CompararProductoAlergeno implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		int result=0;
		
		if(o1!=null && o2!=null) {
			result=o1.getAlergeno().compareTo(o2.getAlergeno());
		}else if(o1==null) {
			result=1;
		}else if(o2==null) {
			result=-1;
		}
		
		return result;
	}

}
