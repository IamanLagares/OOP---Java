package controller;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.ContatosPFDAO;
import Utils.Utils;
import entidade.ContatosPF;

public class ContatoController {
	public static String cadastrarContato(Scanner sc){
		
		System.out.println("------------------- Forumlário para novo contato -------------------\n");
		System.out.println("Nome completo:\n");
		sc.nextLine();
		String nomeCompleto = sc.nextLine();
		
		System.out.println("Telefone:                Telefone Secundário:\n");
	 	String telefone = sc.nextLine();
	 	String telefoneSec = sc.nextLine();
		
	 	System.out.println("Email: 	                 Email Secundário:\n");
	 	String email = sc.nextLine();
	 	String emailSec = sc.nextLine();
		
		System.out.println("\\\\\\\\\\ Dados de Endereço //////////");
							
		System.out.println("rua:\n");
		String rua = sc.nextLine();
		
		System.out.println("numero:\n");
		String numero = sc.nextLine();
		
		System.out.println("Complemento:\n");
		String complemento = sc.nextLine();
		
		System.out.println("Bairro:       Cidade:           Estado: \n");
	 	String bairro = sc.nextLine();	
	 	String cidade = sc.nextLine();
	 	String estado = sc.nextLine();
	 	
	 	System.out.println("CEP:\n");
	 	String cep = sc.nextLine();
	 	
	 	System.out.println("\\\\\\\\\\\\\\\\\\\\///////////////////");
	
		System.out.println("Data de Nascimento:");
		String dataNascimento = sc.nextLine();
		
		System.out.println("digite uma observação sobre seu novo contato:");
		String obs = sc.nextLine();
		
		System.out.println("digite seu email de usuário:");
		String email_usuario = sc.nextLine();
		
		System.out.println("-------------------------------------------------------------------\n");
		
		ContatosPF c = new ContatosPF();
		c.setNome_completo(nomeCompleto);
		c.setTelefone(telefone);
		c.setTelefone_secundario(telefoneSec);
		c.setEmail(email);
		c.setEmail_secundario(emailSec);
		c.setRua(rua);
		c.setNumero(numero);
		c.setComplemento(complemento);
		c.setBairro(bairro);
		c.setCidade(cidade);
		c.setEstado(estado);
		c.setCep(cep);
		c.setData_Nascimento(dataNascimento);
		c.setObservacao(obs);
		c.setEmail_usuario(email_usuario);
		
		String successResponse = "Contato criado com sucesso!\n";
		String failureResponse = "Falha ao criar contato.\n";
		String error = "ERRO - Erro na função de criar contato PF\n";
		
		ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
		try {
			boolean criado = contatoPFDAO.insert(c);
			 if(criado) {
				 return successResponse;
			 }else {
				 return failureResponse;
			 }
			
		}catch (SQLException e) {
			System.err.println("Erro ao cadastrar usuário no banco de dados.");
			e.printStackTrace();
		}
	
		 return error;
		
	}
	
	public static String listarContato(Scanner sc) {
	    System.out.println("\n\n -- Qual seu email de login?");
	    sc.nextLine();String emailLogin = sc.nextLine();

	    String error = "ERRO - Erro na função de listar contato PF\n";

	    ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
	    try {
	        String contatos = contatoPFDAO.show(emailLogin);
	        return contatos;
	    } catch (SQLException e) {
	        System.err.println("Erro ao listar contato do usuário no banco de dados.");
	        e.printStackTrace();
	    }
	    return error;
	}
	
	public static String listarContatoPorNome(Scanner sc) {
	    System.out.println("\n\n -- Qual seu email de login?");
	    sc.nextLine();
	    String emailLogin = sc.nextLine();
	    
	    System.out.println("\n\n -- -- Qual o nome do contato que deseja buscar?");
	    String nomeContato = sc.nextLine();
	    
	    String error = "ERRO - Erro na função de listar contato PF\n";

	    ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
	    try {
	        String contatos = contatoPFDAO.BuscarContatosPorNome(emailLogin, nomeContato);
	        return contatos;
	    } catch (SQLException e) {
	        System.err.println("Erro ao listar contato do usuário no banco de dados.");
	        e.printStackTrace();
	    }
	    return error;
	}
	
	
	public static String listarContatoPorTelefone(Scanner sc) {
	    System.out.println("\n\n -- Qual seu email de login?");
	    sc.nextLine();
	    String emailLogin = sc.nextLine();
	    
	    System.out.println("\n\n -- -- Qual o Telefone do contato que deseja buscar?");
	    String telefoneContato = sc.nextLine();
	    
	    String error = "ERRO - Erro na função de listar contato PF\n";

	    ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
	    try {
	        String contatos = contatoPFDAO.BuscarContatosPorTelefone(emailLogin, telefoneContato);
	        return contatos;
	    } catch (SQLException e) {
	        System.err.println("Erro ao listar contato do usuário no banco de dados.");
	        e.printStackTrace();
	    }
	    return error;
	}
	
	public static String EditarContato(Scanner sc) throws SQLException {
	    System.out.println("\n\n -- Qual a ID do contato?");
	    int idContato = sc.nextInt();
	    sc.nextLine(); // Consumir a nova linha

	    ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
	    boolean continueEditing = true;

	    while (continueEditing) {
	        System.out.println("-------------- Menu de edição --------------\n");
	        System.out.println("1. Nome Completo\n");
	        System.out.println("2. Telefone\n");
	        System.out.println("3. Telefone Secundário\n");
	        System.out.println("4. Email\n");
	        System.out.println("5. Email Secundário\n");
	        System.out.println("6. Data de nascimento\n");
	        System.out.println("7. Observação\n");
	        System.out.println("8. Endereço\n");
	        System.out.println("9. Sair\n");

	        int updateFlag = sc.nextInt();
	        sc.nextLine(); // Consumir a nova linha

	        switch(updateFlag) {
	            case 1:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Digite o novo Nome:\n");
	                String novoNome = sc.nextLine();
	                Boolean result = contatoPFDAO.update(novoNome, updateFlag, idContato);

	                if (result == true) {
	                    System.out.println("Nome atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar nome");
	                }
	                break;
	            case 2:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Digite o novo Telefone:\n");
	                String novoTelefone = sc.nextLine();
	                Boolean result2 = contatoPFDAO.update(novoTelefone, updateFlag, idContato);

	                if (result2 == true) {
	                    System.out.println("Telefone atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar Telefone");
	                }
	                break;
	            case 3:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Digite o novo Telefone Secundário:\n");
	                String novoTelefoneSecundario = sc.nextLine();
	                Boolean result3 = contatoPFDAO.update(novoTelefoneSecundario, updateFlag, idContato);

	                if (result3 == true) {
	                    System.out.println("Telefone secundário atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar Telefone Secundário");
	                }
	                break;
	            case 4:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Digite o novo Email:\n");
	                String novoEmail = sc.nextLine();
	                Boolean result4 = contatoPFDAO.update(novoEmail, updateFlag, idContato);

	                if (result4 == true) {
	                    System.out.println("Email atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar email");
	                }
	                break;
	            case 5:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Digite o novo Email Secundário:\n");
	                String novoEmailSecundario = sc.nextLine();
	                Boolean result5 = contatoPFDAO.update(novoEmailSecundario, updateFlag, idContato);

	                if (result5 == true) {
	                    System.out.println("Email Secundário atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar Email Secundário");
	                }
	                break;
	            case 6:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Digite o nova Data de Nascimento:\n");
	                String novoDataNasc = sc.nextLine();
	                Boolean result6 = contatoPFDAO.update(novoDataNasc, updateFlag, idContato);

	                if (result6 == true) {
	                    System.out.println("Data de nascimento atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar Data de nascimento");
	                }
	                break;
	            case 7:
	                Utils.clearScreen();
	                System.out.println("\n\n -- Nova observação:\n");
	                String novoObs = sc.nextLine();
	                Boolean result7 = contatoPFDAO.update(novoObs, updateFlag, idContato);

	                if (result7 == true) {
	                    System.out.println("Observação atualizado!\n");
	                } else {
	                    System.out.println("ERRO - não foi possível atualizar Observação");
	                }
	                break;
	            case 8:
	                boolean continueEditingAddress = true;
	                while (continueEditingAddress) {
	                    System.out.println("------------------------- Menu Endereço Update -------------------");
	                    System.out.println("1. Rua\n");
	                    System.out.println("2. Numero\n");
	                    System.out.println("3. Complemento\n");
	                    System.out.println("4. Bairro\n");
	                    System.out.println("5. Cidade\n");
	                    System.out.println("6. Estado\n");
	                    System.out.println("7. CEP\n");
	                    System.out.println("8. Voltar ao menu anterior\n");

	                    int enderecoResponse = sc.nextInt();
	                    sc.nextLine(); // Consumir a nova linha

	                    switch(enderecoResponse) {
	                        case 1:
	                            System.out.println("\n\n -- Qual a nova Rua?");
	                            String novaRua = sc.nextLine();
	                            Boolean queryResponse1 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novaRua);
	                            if (queryResponse1 == true) {
	                                System.out.println("Rua Atualizada!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar Rua");
	                            }
	                            break;
	                        case 2:
	                            System.out.println("\n\n -- Qual o novo Número?");
	                            String novoNumero = sc.nextLine();
	                            Boolean queryResponse2 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novoNumero);
	                            if (queryResponse2 == true) {
	                                System.out.println("Numero Atualizado!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar Numero");
	                            }
	                            break;
	                        case 3:
	                            System.out.println("\n\n -- Qual o novo Complemento?");
	                            String novoComplemento = sc.nextLine();
	                            Boolean queryResponse3 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novoComplemento);
	                            if (queryResponse3 == true) {
	                                System.out.println("Complemento Atualizado!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar Complemento");
	                            }
	                            break;
	                        case 4:
	                            System.out.println("\n\n -- Qual o novo Bairro?");
	                            String novoBairro = sc.nextLine();
	                            Boolean queryResponse4 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novoBairro);
	                            if (queryResponse4 == true) {
	                                System.out.println("Bairro Atualizado!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar Bairro");
	                            }
	                            break;
	                        case 5:
	                            System.out.println("\n\n -- Qual a nova Cidade?");
	                            String novaCidade = sc.nextLine();
	                            Boolean queryResponse5 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novaCidade);
	                            if (queryResponse5 == true) {
	                                System.out.println("Cidade Atualizada!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar Cidade");
	                            }
	                            break;
	                        case 6:
	                            System.out.println("\n\n -- Qual o novo Estado?");
	                            String novoEstado = sc.nextLine();
	                            Boolean queryResponse6 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novoEstado);
	                            if (queryResponse6 == true) {
	                                System.out.println("Estado Atualizado!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar Estado");
	                            }
	                            break;
	                        case 7:
	                            System.out.println("\n\n -- Qual o novo CEP?");
	                            String novoCEP = sc.nextLine();
	                            Boolean queryResponse7 = contatoPFDAO.updateEnderecoAux(enderecoResponse, idContato, novoCEP);
	                            if (queryResponse7 == true) {
	                                System.out.println("CEP Atualizado!\n");
	                            } else {
	                                System.out.println("ERRO - não foi possível atualizar CEP");
	                            }
	                            break;
	                        case 8:
	                            continueEditingAddress = false;
	                            break;
	                    }
	                }
	                break;
	            case 9:
	                continueEditing = false;
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	                break;
	        }
	    }
	    return "\nEdição concluída.\n";
	}

	
	
	public static String ExcluirContato(Scanner sc) throws SQLException {
		
		System.out.println("\n\n -- Você tem CERTEZA?\n");
		System.out.println("1. Sim\n");
		System.out.println("2. Não\n");
		
		int response = sc.nextInt();
		
		ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
		if (response == 1) {
			Utils.clearScreen();
			System.out.println("\n -- Qual id do contato?\n");
			int idContato = sc.nextInt();
			Boolean result = contatoPFDAO.delete(idContato);
			
			if(result = true) {
				return "DELETADO com sucesso!";
			}else {
				return "ERRO - ERRO AO DELETAR CONTATO";
			}
		} else if (response == 2){
			return "Voltando...";
		}
		return null;
	}
	
	
	
}
