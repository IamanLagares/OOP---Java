package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidade.Usuario;

public class UsuarioDAO extends DAO<Usuario> {
	
	//Constructor calling the Father (DAO) Class constructor
	//Connection with the database;
	public UsuarioDAO() {
		super();
	}
	
	@Override
	public boolean insert(Usuario usuario) throws SQLException {
		//Insert SQL script 
		String query = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, NVACESSO) VALUES (?, ?, ?, ?)";
		
		//stmt to execute DatabaseQuery
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getNvAcesso());

			return stmt.executeUpdate() > 0;
		}
	}
	
	public int realizarLogin(String email, String senha) throws  SQLException{
		//Insert SQL script 
		String query = "SELECT NVACESSO FROM USUARIO WHERE EMAIL = ? AND SENHA = ?";
		
		//stmt to execute DatabaseQuery
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			//Try to execute the query, and if its executing returns nvAcesso data
			try (ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					System.out.println("\nLogin realizado com sucesso!\n");
					return rs.getInt("NVACESSO");
				}
			}
		}
		//Flag -1 signaling login failed 
		return -1;
	}

	@Override
	public String show(String obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String alt, int updateFlag, int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id_contato) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}




	
	
}
