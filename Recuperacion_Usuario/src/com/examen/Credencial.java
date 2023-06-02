package com.examen;

import java.util.Objects;

public class Credencial {

	
	private String username;
	private String password;
	private int secuencia=100;
	
	public Credencial(String nombre,String apellidos,String password) {
		super();
		this.username=nombre.substring(0, 3)+apellidos.substring(0, 3) + this.secuencia;
		this.secuencia++;
	}
	
	public boolean comprobarPassword(String password) {
		return this.password.equals(password);
	}
	
	public String getUsername() {
		return username;
		
	}
	
	public boolean esPasswordSegura(String password) {
		boolean esSegura=false;
		boolean esMayus=false;
		boolean esDigito=false;
		boolean longitud=false;
		
		for(int i=0;i<password.length();i++) {
			if(password.length()>8) {
				longitud=true;
			}else if(Character.isUpperCase(i)) {
				esMayus=true;
			}else if(Character.isDigit(i)) {
				esDigito=true;
			}
			
			if(longitud && esMayus && esDigito) {
				esSegura=true;
			}
			
		}
		
		return esSegura;
		
	}	
	
	public void setPassword(String newpass) {
		
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj || (obj!=null && obj instanceof Credencial) && 
				Objects.equals(this.username, ((Credencial)obj).username);
	}

	@Override
	public String toString() {
		return "Credencial [username=" + username + ", password=" + password + ", secuencia=" + secuencia + "]";
	}

	public int getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
