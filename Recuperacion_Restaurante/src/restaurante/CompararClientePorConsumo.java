package restaurante;

import java.util.Comparator;

import restaurante.model.Cliente;

public class CompararClientePorConsumo implements Comparator<Cliente>{


	@Override
	public int compare(Cliente o1, Cliente o2) {
		int result=0;
		
		if(o1!=null && o2!=null) {
			result=Double.compare(o1.calcularImporteConsumido(), o2.calcularImporteConsumido());
		}else if(o1==null) {
			result=1;
		}else if(o2==null) {
			result=-1;
		}
		
		return result;
	}

}
