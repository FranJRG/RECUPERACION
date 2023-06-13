package exam;

public class Main {

	public static void main(String[] args) throws Exception {
	
		Credencial c=new Credencial("Francisco Javier", "Ramirez", "1234455");
		Credencial c1=new Credencial("Alfonso", "Ramirez", "1234455");
		Usuario usu=new Usuario("Francisco Javier", "Ramirez", "framirezgarcia0@gmail.com", "74854741AsFA");
		
		System.out.println(c.getUsername());
		System.out.println(c1.getUsername());
		System.out.println(c.esPasswordSegura("aA2d3a1q"));
		
		System.out.println(usu.toString());
		System.out.println(usu.hacerLogin("Juan", "1321442443AAAas"));

	}

}
