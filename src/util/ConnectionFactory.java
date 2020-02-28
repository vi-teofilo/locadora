package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	public static Connection getConnection() {

		String local = "jdbc:mysql://localhost/locadora";
		String login = "root";
		String senha = "root";
//		   faz a coneci��o com o mysql
		Connection conexao = null;

//		 trata a Clss.forName, que vai carregar o Driver na unha   
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conexao = (Connection) DriverManager.getConnection(local, login, senha);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Falha ao carregar o Driver");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexao;

	}
	
}
