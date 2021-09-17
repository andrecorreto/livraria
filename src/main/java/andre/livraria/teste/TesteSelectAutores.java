package andre.livraria.teste;

import java.util.List;
import andre.livraria.dao.AutorDao;
import andre.livraria.factory.ConnectionFactory;
import andre.livraria.modelo.Autor;

public class TesteSelectAutores {

	public static void main(String[] args) {
		
		AutorDao dao = new AutorDao(new ConnectionFactory().getConnection());
		List<Autor> autores = dao.listar();
		
		autores.forEach(System.out::println);
	}

}
