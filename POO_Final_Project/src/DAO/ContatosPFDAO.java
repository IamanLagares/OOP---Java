package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidade.ContatosPF;

public class ContatosPFDAO extends DAO<ContatosPF> {

	public ContatosPFDAO() {
		super();
	}

	@Override
	public boolean insert(ContatosPF contatoPf) throws SQLException {
		// Insert SQL script
		String query = "INSERT INTO ContatosPF (nome_completo, telefone, telefone_secundario, email, email_secundario, rua, numero, complemento, bairro, cidade, estado, cep, data_nascimento, observacao, email_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// stmt to execute DatabaseQuery
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, contatoPf.getNome_completo());
			stmt.setString(2, contatoPf.getTelefone());
			stmt.setString(3, contatoPf.getTelefone_secundario());
			stmt.setString(4, contatoPf.getEmail());
			stmt.setString(5, contatoPf.getEmail_secundario());
			stmt.setString(6, contatoPf.getRua());
			stmt.setString(7, contatoPf.getNumero());
			stmt.setString(8, contatoPf.getComplemento());
			stmt.setString(9, contatoPf.getBairro());
			stmt.setString(10, contatoPf.getCidade());
			stmt.setString(11, contatoPf.getEstado());
			stmt.setString(12, contatoPf.getCep());
			stmt.setString(13, contatoPf.getData_Nascimento());
			stmt.setString(14, contatoPf.getObservacao());
			stmt.setString(15, contatoPf.getEmail_usuario());

			return stmt.executeUpdate() > 0;
		}
	}

	@Override
	public String show(String emailLogin) throws SQLException {
		String query = "SELECT * FROM CONTATOSPF WHERE EMAIL_USUARIO = ?";

		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, emailLogin);

			try (ResultSet rs = stmt.executeQuery()) {
				StringBuilder result = new StringBuilder();
				while (rs.next()) {
					// Supondo que a tabela CONTATOSPF tenha colunas ID, NOME, EMAIL
					int id = rs.getInt("ID_CONTATO");
					String nome = rs.getString("NOME_COMPLETO");
					String telefone = rs.getString("TELEFONE");
					String telefone_sec = rs.getString("TELEFONE_SECUNDARIO");
					String email = rs.getString("EMAIL");
					String email_sec = rs.getString("EMAIL_SECUNDARIO");
					String bairro = rs.getString("BAIRRO");
					String cidade = rs.getString("CIDADE");
					String estado = rs.getString("ESTADO");
					String cep = rs.getString("CEP");
					String obs = rs.getString("OBSERVACAO");
					String data_nasc = rs.getString("DATA_NASCIMENTO");

					 System.out.println("-------------------- Contatos ---------------------");
	 	                result.append("- ID: ").append(id)
	 	                      .append(",\n   Nome: ").append(nome)
	 	                      .append(",\n   Telefone: ").append(telefone)
	 	                      .append(",\n   Telefone Secundário: ").append(telefone_sec)
	 	                      .append(",\n   Email: ").append(email)
	 	                      .append(",\n   Email Secundário: ").append(email_sec)
	 	                      .append(",\n   Bairro: ").append(bairro)
	 	                      .append(",\n   Cidade: ").append(cidade)
	 	                      .append(",\n   Estado: ").append(estado)
	 	                      .append(",\n   CEP: ").append(cep)
	 	                      .append(",\n   Data de nascimento: ").append(data_nasc)
	 	                      .append(",\n   Observação: ").append(obs)
	 	                      .append("\n");
				}

				if (result.length() == 0) {
					return "Nenhum contato encontrado para o email fornecido.";
				}
				return result.toString();
			}
		}
	}

	public String BuscarContatosPorNome(String emailQuery, String nomeQuery) throws SQLException {
		String query = "SELECT * FROM CONTATOSPF WHERE EMAIL_USUARIO = ? AND NOME_COMPLETO = ?";

		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, emailQuery);
			stmt.setString(2, nomeQuery);

			try (ResultSet rs = stmt.executeQuery()) {
				StringBuilder result = new StringBuilder();
				while (rs.next()) {
					// Supondo que a tabela CONTATOSPF tenha colunas ID, NOME, EMAIL
					int id = rs.getInt("ID_CONTATO");
					String nome = rs.getString("NOME_COMPLETO");
					String telefone = rs.getString("TELEFONE");
					String telefone_sec = rs.getString("TELEFONE_SECUNDARIO");
					String email = rs.getString("EMAIL");
					String email_sec = rs.getString("EMAIL_SECUNDARIO");
					String bairro = rs.getString("BAIRRO");
					String cidade = rs.getString("CIDADE");
					String estado = rs.getString("ESTADO");
					String cep = rs.getString("CEP");
					String obs = rs.getString("OBSERVACAO");
					String data_nasc = rs.getString("DATA_NASCIMENTO");

				       System.out.println("-------------------- Contatos ---------------------");
	 	                result.append("- ID: ").append(id)
	 	                      .append(",\n   Nome: ").append(nome)
	 	                      .append(",\n   Telefone: ").append(telefone)
	 	                      .append(",\n   Telefone Secundário: ").append(telefone_sec)
	 	                      .append(",\n   Email: ").append(email)
	 	                      .append(",\n   Email Secundário: ").append(email_sec)
	 	                      .append(",\n   Bairro: ").append(bairro)
	 	                      .append(",\n   Cidade: ").append(cidade)
	 	                      .append(",\n   Estado: ").append(estado)
	 	                      .append(",\n   CEP: ").append(cep)
	 	                      .append(",\n   Data de nascimento: ").append(data_nasc)
	 	                      .append(",\n   Observação: ").append(obs)
	 	                      .append("\n");
				}

				if (result.length() == 0) {
					return "Nenhum contato encontrado para o nome fornecido.";
				}
				return result.toString();
			}

		}
	}
	
	public String BuscarContatosPorTelefone(String emailQuery, String telefoneQuery) throws SQLException {
		String query =  "SELECT * FROM CONTATOSPF WHERE EMAIL_USUARIO = ? AND (TELEFONE = ? OR TELEFONE_SECUNDARIO = ?)";

		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, emailQuery);
			stmt.setString(2, telefoneQuery);
			stmt.setString(3, telefoneQuery);

			try (ResultSet rs = stmt.executeQuery()) {
				StringBuilder result = new StringBuilder();
				while (rs.next()) {
					// Supondo que a tabela CONTATOSPF tenha colunas ID, NOME, EMAIL
					int id = rs.getInt("ID_CONTATO");
					String nome = rs.getString("NOME_COMPLETO");
					String telefone = rs.getString("TELEFONE");
					String telefone_sec = rs.getString("TELEFONE_SECUNDARIO");
					String email = rs.getString("EMAIL");
					String email_sec = rs.getString("EMAIL_SECUNDARIO");
					String bairro = rs.getString("BAIRRO");
					String cidade = rs.getString("CIDADE");
					String estado = rs.getString("ESTADO");
					String cep = rs.getString("CEP");
					String obs = rs.getString("OBSERVACAO");
					String data_nasc = rs.getString("DATA_NASCIMENTO");

				       System.out.println("-------------------- Contatos ---------------------");
	 	                result.append("- ID: ").append(id)
	 	                      .append(",\n   Nome: ").append(nome)
	 	                      .append(",\n   Telefone: ").append(telefone)
	 	                      .append(",\n   Telefone Secundário: ").append(telefone_sec)
	 	                      .append(",\n   Email: ").append(email)
	 	                      .append(",\n   Email Secundário: ").append(email_sec)
	 	                      .append(",\n   Bairro: ").append(bairro)
	 	                      .append(",\n   Cidade: ").append(cidade)
	 	                      .append(",\n   Estado: ").append(estado)
	 	                      .append(",\n   CEP: ").append(cep)
	 	                      .append(",\n   Data de nascimento: ").append(data_nasc)
	 	                      .append(",\n   Observação: ").append(obs)
	 	                      .append("\n");
				}

				if (result.length() == 0) {
					return "Nenhum contato encontrado para o Telefone fornecido.";
				}
				return result.toString();
			}

		}
	}

	@Override
	public boolean update(String alt, int updateFlag, int id) throws SQLException {
		
		switch(updateFlag) {
		case 1:
			String query1 = "UPDATE CONTATOSPF SET NOME_COMPLETO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query1)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
			
		case 2:
			String query2 = "UPDATE CONTATOSPF SET TELEFONE = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query2)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		case 3:
			String query3 = "UPDATE CONTATOSPF SET TELEFONE_SECUNDARIO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query3)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		case 4:
			String query4 = "UPDATE CONTATOSPF SET EMAIL = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query4)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		case 5:
			String query5 = "UPDATE CONTATOSPF SET EMAIL_SECUNDARIO = ? WHERE id_contato = ?";
			try (PreparedStatement stmt = connection.prepareStatement(query5)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
			
		case 6:
			String query6 = "UPDATE CONTATOSPF SET DATA_NASCIMENTO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query6)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0; 
			}
		case 8:
			String query8 = "UPDATE CONTATOSPF SET OBSERVACAO = ? WHERE id_contato = ?";
			try (PreparedStatement stmt = connection.prepareStatement(query8)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		}
		return false;
	}
	
	public Boolean updateEnderecoAux(int flag, int id, String alt) throws SQLException {
		
		switch(flag) {
		case 1:
			String query1 = "UPDATE CONTATOSPF SET RUA = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query1)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
			
		case 2:
			String query2 = "UPDATE CONTATOSPF SET NUMERO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query2)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		
		case 3:
			String query3 = "UPDATE CONTATOSPF SET COMPLEMENTO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query3)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		case 4:
			String query4 = "UPDATE CONTATOSPF SET BAIRRO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query4)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		
		case 5:
			String query5 = "UPDATE CONTATOSPF SET CIDADE = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query5)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		
		case 6:
			String query6 = "UPDATE CONTATOSPF SET ESTADO = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query6)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		case 7:
			String query7 = "UPDATE CONTATOSPF SET CEP = ? WHERE id_contato = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(query7)) {
				stmt.setString(1, alt);
				stmt.setInt(2, id);
				return stmt.executeUpdate() > 0;
			}
		}
		return null;
	}

	@Override
	public boolean delete(int id_contato) throws SQLException {
		String query = "DELETE FROM CONTATOSPF WHERE id_contato = ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id_contato);
			return stmt.executeUpdate() > 0;
		}
	}

}
