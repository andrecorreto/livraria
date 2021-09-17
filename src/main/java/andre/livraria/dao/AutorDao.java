package andre.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import andre.livraria.factory.ConnectionFactory;
import andre.livraria.modelo.Autor;

public class AutorDao {

	private Connection conexao;

	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Autor autor) {
		try {
		// Query para inserção no Banco de Dados
		String sql = "insert into autores(nome, email, data_nascimento, curriculo )" + " values (?, ?, ?, ?)";

		// Configura o Statment informando os valores para o Insert
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, autor.getNome());
		ps.setString(2, autor.getEmail());
		ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
		ps.setString(4, autor.getCurriculo());

		// Executa a Query/Statment
		ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);			
		}
	}

	public List<Autor> listar() {
		try {
			// Define a Query para o SELECT no Banco de Dados
			String sql = "SELECT * FROM AUTORES";

			// Gera conexão a partir da Factory
			Connection conexao = new ConnectionFactory().getConnection();	
			
			// Configura o Statment informando a conexão e o SQL para consulta
			PreparedStatement ps = conexao.prepareStatement(sql);

			// Executa a Query/Statment e guarda o retorno no ResultSet
			ResultSet rs = ps.executeQuery();

			// Cria lista de autores vazia
			List<Autor> autores = new ArrayList<>();

			// Navega no ResultSet para tratar cada um dos registros
			while (rs.next()) {

				// Cria um objeto Autor para cada registro encontrado
				// no ResultSet
				Autor a = new Autor(rs.getString("nome"), rs.getString("email"),
						rs.getDate("data_nascimento").toLocalDate(), rs.getString("curriculo"));

				// Inclui na lista o objeto Autor gerado
				autores.add(a);
			}
			// Retorna a lista de autores
			return autores;

		} catch (SQLException e) {
			// Devolve a exceção para quem chamou
			throw new RuntimeException(e);
		}
	}

}
