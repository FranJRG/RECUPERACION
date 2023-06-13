package exam;

import java.util.Objects;

public class Credencial {

	private String username;
	private String password;
	private static int secuencia=100;
	
	
	public Credencial(String nombre, String apellidos, String password) {
		super();
		this.username = nombre.substring(0,3) + apellidos.substring(0, 3) + Credencial.secuencia++;
		this.password = password;
	}
	
	public boolean comprobarPassword(String password) {
		return this.password.equals(password);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public boolean esPasswordSegura(String password) {
		boolean esSegura=false;
		boolean esMayus=false;
		boolean esDigit=false;
		boolean longitud=false;
		
		if(password.length()>8) {
			longitud=true;
		}
		
		for(int i=0;i<password.length();i++) {
			if(Character.isDigit(password.charAt(i))) {
				esDigit=true;
			}
		}
		
		for(int i=0;i<password.length();i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				esMayus=true;
			}
		}
		
		if(esMayus && esDigit && longitud) {
			esSegura=true;
		}
		
		return esSegura;
	}
	
	public void setPassword(String newpass) {
		this.password=newpass;
	}

	public String getPassword() {
		return password;
	}

	
	@Override
	public boolean equals(Object obj) {
		return this==obj || (obj!=null && obj instanceof Credencial) && 
				Objects.equals(this.username, ((Credencial)obj).username) ;
	}
	
	
	
}
