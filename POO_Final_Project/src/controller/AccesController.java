package controller;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.UsuarioDAO;
import entidade.Usuario;

public class AccesController {
	
	public static String cadastrarCliente(Scanner sc, boolean running) {
		//Defining user access level
		int nvAcesso = 1;
		
		//reading data
		System.out.println("------- Insira os seguintes dados --------\n");
		System.out.println("Nome Completo:");
		sc.nextLine();
		String nomeCadastro = sc.nextLine();
		System.out.println("Email:");
		String emailCadastro = sc.nextLine();
		System.out.println("Senha:");
		String senhaCadastro = sc.nextLine();
		
		
		
		
		//Setting data, Instantiating new entity
		Usuario u = new Usuario();
		u.setNome(nomeCadastro);
		u.setEmail(emailCadastro);
		u.setSenha(senhaCadastro);
		u.setNvAcesso(nvAcesso);
		
		//Response Messages
		String successResponse = "Usuário cadastrado com sucesso!\n";
		String failureResponse = "Falha ao cadastrar usuário.\n";
		String error = "ERRO - Erro na função de cadastro do cliente\n";
		
		//Instantiating Referenced DAO, inserting data in the DataBase treating it
		UsuarioDAO usuarioDAOCadastro = new UsuarioDAO();
		try {
			boolean cadastrado = usuarioDAOCadastro.insert(u);
			if (cadastrado) {
				return successResponse;
			} else {
				return failureResponse;
			}
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar usuário no banco de dados.");
			e.printStackTrace();
		}
		return error;
	}
	
	public static int LoginController(Scanner sc) throws SQLException{
		//reading data
		System.out.println("------- Insira os seguintes dados --------\n");
		System.out.println("Insira o Email: \n");
		sc.nextLine();
		String emailLogin = sc.nextLine();
		
		System.out.println("Insira a Senha: \n");
		String senhaLogin = sc.nextLine();
		
		//Instantiating Referenced DAO
		UsuarioDAO usuarioDAOLogin = new UsuarioDAO();
		
		int nvAcesso = usuarioDAOLogin.realizarLogin(emailLogin, senhaLogin);
		
		return nvAcesso;
	}
	
	
}
