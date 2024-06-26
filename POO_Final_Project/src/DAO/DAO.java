package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import conexao.Conexao;

public abstract class DAO<T> {
	protected Connection connection;
	
	//Constructor for database connection
	public DAO() {
		this.connection = Conexao.getConexao();
	}
	
	//Abstract methods
	//insert data
	public abstract boolean insert(T obj) throws SQLException;
	
	//show data
	public abstract String show(String obj) throws SQLException;
	
	//update data
	public abstract boolean update(String alt, int updateFlag, int id)throws SQLException;
	
	public abstract boolean delete(int id_contato)throws SQLException;
}
