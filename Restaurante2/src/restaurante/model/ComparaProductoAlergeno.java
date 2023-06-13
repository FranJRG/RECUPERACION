package restaurante.model;

import java.util.Comparator;

public class ComparaProductoAlergeno implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null) {
			resultado=o1.getAlergeno().compareTo(o2.getAlergeno());
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		return resultado;
	}

}
