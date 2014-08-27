package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.model.Usuario;

@Repository
public class JdbcUsuarioDao  {
	
	Connection connection;
	
	@Autowired
	public JdbcUsuarioDao(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean existeUsuario(Usuario usuario){
		
		String sql = "select * from usuarios where login= ?  and senha= ?";
		
		try{
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		
		stmt.setString(1, usuario.getLogin());
		stmt.setString(2, usuario.getSenha());
		
		ResultSet rs = stmt.executeQuery();
		
		stmt.execute();
		
		//verifica se existe retorno na consulta
		if(rs.next())
		{
			stmt.close();
			return true;
		}
		else
		{
			stmt.close();
			return false;
		}
		
	}catch(SQLException e){
		throw new RuntimeException(e);
	}
}
}
