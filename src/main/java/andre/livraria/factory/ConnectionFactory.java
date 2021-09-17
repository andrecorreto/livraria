package andre.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

		public Connection getConnection() {
			try {
				
				// Define os parâmetros da conexão
				String url = "jdbc:mysql://localhost:3306/livraria";
				String usuario = "root";
				String senha = "root";
				
				// Caminho para o Driver do msql para JDBC
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// Requisita conexão
				Connection conexao = DriverManager.getConnection(url, usuario, senha);
				
				// Retorna a referência da conexão estabelecida
				return conexao;
				
				
			} catch(Exception e) {
				throw new RuntimeException(e);
			}

			
		}
		
	
}
