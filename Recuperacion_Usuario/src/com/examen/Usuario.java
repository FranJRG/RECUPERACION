package com.examen;

import java.util.Objects;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private int  intentos=2;
	private Credencial credencial;
	
	public Usuario(String nombre, String apellidos, String password) {
		super();
		this.nombre=nombre;
		this.apellidos=apellidos;
		Credencial c=new Credencial(nombre, apellidos, password);
		this.credencial=c;
	}
	
	public Usuario(String nombre, String apellidos, String email, String password) {
		super();
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.email=email;
		Credencial c=new Credencial(nombre, apellidos, password);
		this.credencial=c;
		
	}
	
	public boolean esCuentaBloqueada() {
		return this.intentos==0;
	}
	
	private Credencial setCredencial(Credencial credencial) {
		return this.credencial=credencial;
		
	}
	
	public boolean modificarPassword(String oldpass, String newpass, String newpassverif) {
		boolean mod=false;
		
		if(this.credencial.getPassword()==oldpass && newpass==newpassverif) {
			this.credencial.setPassword(newpass);
			mod=true;
		}
		
		return mod;
	}
	
	public boolean esPasswordSegura(String password) {
		return this.credencial.esPasswordSegura(password);
	}
	
	public boolean hacerLogin(String username,String password) {
		boolean login=true;
		int cont=0;
		
		if(!this.credencial.getUsername().equals(username) && !this.credencial.getPassword().equals(password)) {
			cont++;
			if(cont>this.intentos) {
				cont=0;
				login=false;
			}
		}
		
		return login;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return this==obj || (obj!=null && obj instanceof Usuario) && 
				Objects.equals(this.nombre, ((Usuario)obj).nombre) && 
				Objects.equals(this.apellidos, ((Usuario)obj).apellidos) && 
				Objects.equals(this.email, ((Usuario)obj).email)
				|| Objects.equals(this.credencial, ((Usuario)obj).credencial);
	}
	
	
	@Override
	public String toString() {
		return "Usuari@: " + nombre + apellidos + " con email " + email + ", " + "username" 
	+ this.credencial.getUsername() + " y contraseña " + this.credencial.getPassword();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	
}
