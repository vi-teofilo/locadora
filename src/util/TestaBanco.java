package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//classe esta dentro do java util porque � um teste para o meu projeto


public class TestaBanco {
	
   public static void main(String[] args) {
	   String local="jdbc:mysql://localhost/locadora";
	   String login="root";
	   String senha="root";
//	   faz a coneci��o com o mysql
	   Connection bd= null;

	   

//	 trata a Clss.forName, que vai carregar o Driver na unha   
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Driver carregado com sucesso!!");
		 
		 bd= (Connection) DriverManager.getConnection(local,login,senha);
		 
		 System.out.println("Conex�o Realizada com sucesso!!");
		 
		 bd.close();
		 
		 System.out.println("Conex�o encerrada com sucesso!!");
		 
		 
		 
		 
		 
		 
		 
		 
		 
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		System.out.println("Falha ao carregar o Driver");
	} catch (SQLException e) {
		System.out.println("Erro ao conectar!");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	   
}
}
