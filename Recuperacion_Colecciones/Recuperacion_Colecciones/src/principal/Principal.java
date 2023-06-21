package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import main.java.model.Catalogo;
import main.java.model.Cliente;
import main.java.model.ClienteException;
import main.java.model.Genero;
import main.java.model.Linea;
import main.java.model.Negocio;
import main.java.model.ParaFichero;
import main.java.model.Pedido;
import main.java.model.Producto;
import main.java.model.ProductoException;
import main.java.model.Status;

public class Principal {

	
	public static void main(String[]args){
		
		Set<Cliente>clientes=new HashSet<>();
		
		
		clientes.add(new Cliente("Francisco","Ramirez","13241254A","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4), Genero.MASCULINO));
		clientes.add(new Cliente("Juliana","Dominguez","14758964G","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4), Genero.FEMENINO));
		clientes.add(new Cliente("Rodigra","Jimenez","87456213P","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4), Genero.FEMENINO));
		clientes.add(new Cliente("Pepe","Antonio","98765431L","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4), Genero.MASCULINO));
		clientes.add(new Cliente("Juan","Manuel","14785236J","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4), Genero.MASCULINO));
		clientes.add(new Cliente("Manuela","Gomez","78546214P","framirezgarcia0@gmail.com",LocalDate.of(2002, 12, 4), Genero.FEMENINO));
		
		new ParaFichero().guardarDatosCliente(clientes, ".//files//otronuevo.csv");
		
		Set<Pedido>pedidos=new HashSet<>();
		
		pedidos.add(new Pedido("PJ123",Status.ENVIANDO,new Cliente(23)));
		
		new ParaFichero().guardarDatosPedido(pedidos, ".//files//nuevoPedido.csv");
		
		Set<Linea>lineas=new HashSet<>();
		
		lineas.add(new Linea("A3R21",new Producto("Mesa de madera embarnizada") ,new Pedido(23), 22, 23));
		
		new ParaFichero().guardarDatosLinea(lineas, ".//files//nuevaLinea.csv");
		
		
	}
	
	
	
	
	public static void main2(String[] args) {
		
		File archivo=new File(".\\files\\datos.csv");
		
		//System.out.println(archivo.exists());
		
		try {
			
			FileReader reader=new FileReader(archivo);
			BufferedReader buffer=new BufferedReader(reader);
			
			buffer.readLine();
			
			String datos=buffer.readLine();
			
			List<Cliente>clientes=new ArrayList<>();
			
			while(datos!=null) {
				String[] datosParaCliente=datos.split(",");
				Cliente cli=new Cliente(datosParaCliente[0],
										datosParaCliente[1],
										datosParaCliente[2],
										datosParaCliente[3],
										LocalDate.parse(datosParaCliente[4]),
										Genero.valueOf(datosParaCliente[5]));
				clientes.add(cli);
				datos=buffer.readLine();				
			}
			
			buffer.close();
			reader.close();
			System.out.println(clientes.toString());
			
		}catch(IOException e) {
			
		}

	}

}
