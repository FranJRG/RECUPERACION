package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Catalogo;
import main.java.model.Cliente;
import main.java.model.ClienteException;
import main.java.model.Genero;
import main.java.model.Linea;
import main.java.model.Negocio;
import main.java.model.Pedido;
import main.java.model.Producto;
import main.java.model.Status;

public class MainApp {

	public static void main(String[] args) {

		try {
			
			Cliente c=new Cliente("Francisco","Ramirez","17486320H","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4),Genero.MASCULINO);
			Catalogo cat=new Catalogo();
			Negocio n=new Negocio();
			Producto p=new Producto("Ordenador","Ordenador de mesa",120.24);
			Pedido pedido=new Pedido("AD45",Status.ENVIANDO,c);
			Pedido pedido2=new Pedido("SL33",Status.ENVIADO,c);
			Pedido pedido3=new Pedido("QW32",Status.CANCELADO,c);
			Pedido pedido4=new Pedido("LL11",Status.ENVIADO,c);
			
			//c.setPedido(pedido);
			Linea l=new Linea("FJ45",p,pedido,4,120.4);
			pedido.addLinea(l);
			
			
			n.añadirPedido(pedido);
			n.añadirPedido(pedido2);
			n.añadirPedido(pedido3);
			n.añadirPedido(pedido4);
			
			
			
			System.out.println(n.agruparPorEstado(n.getPedidos()));
			
			//System.out.println(n.addCliente(c));
			System.out.println(n.eliminarCliente("Francisco"));
			//System.out.println(n.toString());
			//n.eliminarCliente("Francisco");
			//System.out.println(c.toString());
			//System.out.println(pedido.toString());
			
		} catch (ClienteException e) {
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
