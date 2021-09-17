package andre.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

		public Connection getConnection() {
			try {
				
				// Define os par�metros da conex�o
				String url = "jdbc:mysql://localhost:3306/livraria";
				String usuario = "root";
				String senha = "root";
				
				// Caminho para o Driver do msql para JDBC
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// Requisita conex�o
				Connection conexao = DriverManager.getConnection(url, usuario, senha);
				
				// Retorna a refer�ncia da conex�o estabelecida
				return conexao;
				
				
			} catch(Exception e) {
				throw new RuntimeException(e);
			}

			
		}
		
	
}
