package restaurante;

import java.util.Comparator;

import restaurante.model.Cliente;

public class CompararClienteConsumo implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		int resultado=0;
		
		if(o1!=null && o2!=null) {
			resultado=Double.compare(o1.calcularImporteConsumido(), o2.calcularImporteConsumido());
		}else if(o1==null) {
			resultado=1;
		}else if(o2==null) {
			resultado=-1;
		}
		return resultado;
	}

}
