package andre.livraria.teste;

import java.time.LocalDate;
import andre.livraria.dao.AutorDao;
import andre.livraria.factory.ConnectionFactory;
import andre.livraria.modelo.Autor;

public class TesteInsereAutor {
	public static void main(String[] args) {
		AutorDao dao = new AutorDao(new ConnectionFactory().getConnection());
		
		// Define um Autor
		Autor autor = new Autor(
				"Um qualquer", 
				"umqualquer@qualquer.com",
				LocalDate.of(1980, 05, 30),
				"Bom curriculo");
		
		// Insere Autor no banco de dados
		dao.cadastrar(autor);
		
	}

}
