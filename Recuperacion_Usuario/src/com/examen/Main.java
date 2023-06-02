package com.examen;

public class Main {

	public static void main(String[] args) {
		
		Usuario usu=new Usuario("Francisco","Ramirez","framirezgarcia0@gmail.com","174Hc2a1");
		Credencial cred=new Credencial("Francisco","Ramirez", "174H=c2a1");
		Credencial cred3=new Credencial("Alfonso","Ramirez", "748a569P.@");
		System.out.println(usu.esPasswordSegura("174C2HC2A1l"));
		System.out.println(cred.getUsername());
		System.out.println(cred3.getUsername());
	}

}
