package main.java.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParaFichero {

	private static final String CABECERA_INGLES="id,nombre,apellidos,email,fechnac,genero";
	private static final String CABECERA_PEDIDOS="id,codigo,status,cliente";
	private static final String CABECERA_LINEAS = "id,codigo,nombre,idpedido,cantidad,precio";
	
	public List<Cliente>cargarDatosCliente(String path)throws IOException{
		
		FileReader reader=new FileReader(new File(path));
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
		
		return clientes;
	}

	public void guardarDatosCliente(Set<Cliente>clientes,String fichero) {
		File destino=new File(fichero);
		try {
			if(!destino.exists()) {
				destino.createNewFile();
			}
			PrintWriter printer=new PrintWriter(destino);
			printer.println(CABECERA_INGLES);
			
			for (Cliente c : clientes) {
				printer.println(c.toString());
			}
			
			printer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Pedido>cargarDatosPedido(String path) throws IOException{
		FileReader reader= new FileReader(new File(path));
		BufferedReader buffer=new BufferedReader(reader);
		
		buffer.readLine();
		
		String datos=buffer.readLine();
		
		List<Pedido>pedidos=new ArrayList<>();
		
		while(datos!=null) {
			String[] datosPedidos=datos.split(",");
			
			String codigo=datosPedidos[0];
			Status status=Status.valueOf(datosPedidos[1]);
			int idCliente=Integer.parseInt(datosPedidos[2]);
			
			
			Cliente cli=new Cliente(idCliente);
			
			Pedido pedido=new Pedido(codigo,status,cli);
			
			pedidos.add(pedido);
			
			datos=buffer.readLine();
			
		}
		
		return pedidos;
	}
	
	public void guardarDatosPedido(Set<Pedido>pedidos,String fichero) {
		File destino=new File(fichero);
		try {
			if(!destino.exists()) {
				destino.createNewFile();
			}
			PrintWriter printer=new PrintWriter(destino);
			printer.println(CABECERA_PEDIDOS);
			
			for (Pedido p : pedidos) {
				printer.println(p.toCSVString());
			}
			
			printer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Linea>cargarDatosLinea(String path) throws IOException{
		
		FileReader reader=new FileReader(new File(path));
		BufferedReader buffer=new BufferedReader(reader);
		
		buffer.readLine();
		
		String datos=buffer.readLine();
		
		List<Linea>lineas=new ArrayList<>();
		
		while(lineas!=null) {
			String[]datosLineas=datos.split(",");
			
			String codigo=datosLineas[0];
			String descripcion=datosLineas[1];
			int idPedido=Integer.parseInt(datosLineas[2]);
			int cantidad=Integer.parseInt(datosLineas[3]);
			double precio=Double.parseDouble(datosLineas[4]);
			
			Pedido p=new Pedido(idPedido);
			Producto producto=new Producto(descripcion);
			Linea l =new Linea(codigo,producto,p,cantidad,precio);
			
			lineas.add(l);
			
			datos=buffer.readLine();
		}
		
		return lineas;
	}
	
	public void guardarDatosLinea(Set<Linea>lineas,String fichero) {
		File destino=new File(fichero);
		try {
			if(!destino.exists()) {
				destino.createNewFile();
			}
			PrintWriter printer=new PrintWriter(destino);
			printer.println(CABECERA_LINEAS);
			
			for (Linea l : lineas) {
				printer.println(l.toString());
			}
			
			printer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
