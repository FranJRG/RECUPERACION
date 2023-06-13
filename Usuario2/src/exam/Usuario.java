package exam;

import java.util.Objects;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String email;
	private int intentos=2;
	private Credencial credencial;
	
	
	public Usuario(String nombre, String apellidos, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.credencial=new Credencial(nombre,apellidos,password);
	}


	public Usuario(String nombre, String apellidos, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.credencial=new Credencial(nombre,apellidos,password);
	}
	
	
	
	public boolean esCuentaBloqueada() {
		return this.intentos==0;
	}
	
	private void setCredencial(Credencial credencial) {
		this.credencial=credencial;
	}
	
	public boolean modificarPassword(String oldpass, String newpass, String newpassverif) {
		boolean mod=false;
		
		if(this.credencial.getPassword().equals(oldpass) && !oldpass.equals(newpass) && newpass.equals(newpassverif)) {
			mod=true;
			this.credencial.setPassword(newpass);
		}
		
		return mod;
	}
	
	public boolean esPasswordSegura(String password) {
		return this.credencial.esPasswordSegura(password);
	}
	
	public boolean hacerLogin(String username, String password) throws Exception {
		boolean logearse=true;
		int cont=0;
		
		if(esCuentaBloqueada()) {
			throw new Exception("Su cuenta ha sido bloqueada no puede acceder a ella");
		}
		
		if(!username.equals(this.credencial.getUsername()) && !password.equals(this.credencial.comprobarPassword(password))){
			cont++;
		}
		
		if(cont>intentos) {
			logearse=false;
			throw new Exception("Ha superado el numero de intentos(2) no puede logearse");
		}else {
			logearse=true;
			cont=0;
		}
		
		return logearse;
	}


	@Override
	public String toString() {
		return "Usuari@ " + this.nombre + this.apellidos + " con email " + email + "," + " username " + this.credencial.getUsername() + " y contraseña " + this.credencial.getPassword();
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj || (obj!=null && obj instanceof Usuario) && 
				Objects.equals(this.nombre, ((Usuario)obj).nombre) &&
				Objects.equals(this.apellidos, ((Usuario)obj).apellidos) &&
				Objects.equals(this.email, ((Usuario)obj).email) ||
				Objects.equals(this.credencial, ((Usuario)obj).credencial);
	}
	
	
	
}
