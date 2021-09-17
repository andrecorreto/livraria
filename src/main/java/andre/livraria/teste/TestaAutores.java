package andre.livraria.teste;

import java.time.LocalDate;

import andre.livraria.modelo.Autor;

public class TestaAutores {

	public static void main(String[] args) {
		Autor autor = new Autor(
				"Autor1", 
				"autor@alura.com",
				LocalDate.of(1969, 3, 21),
				"Fez muita coisa");
		
		System.out.println(autor.toString());		
	}

}

