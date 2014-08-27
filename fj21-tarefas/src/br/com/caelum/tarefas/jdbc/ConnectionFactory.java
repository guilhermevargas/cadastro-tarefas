package br.com.caelum.tarefas.jdbc;
import java.sql.*;

public class ConnectionFactory {
	public Connection getConnection(){
		System.out.println("Conectando ao Banco de Dados...");
		
		
		String stringDeConexao="jdbc:mysql://localhost/fj21";
		String user="root";
		String pass="partytime231208";
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance ();  
			return DriverManager.getConnection
			(stringDeConexao,user,pass);
		}catch(SQLException e){
			throw new RuntimeException(e+"\nNAO FOI POSSIVEL CONECTAR NO BANCO DE DADOS");
		}catch (Exception ex) {
			throw new RuntimeException(ex+"\nNAO FOI POSSIVEL CONECTAR NO BANCO DE DADOS");
		}
	}
}