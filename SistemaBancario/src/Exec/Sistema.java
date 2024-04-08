package Exec;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> ContasBancarias;
	
	public static void main(String[] args) {
		ContasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		 System.out.println("------------------------------------------------------");
	        System.out.println("------------------Sistema Bancário----------------");
	        System.out.println("------------------------------------------------------");
	        System.out.println("***** Selecione uma operação que deseja realizar *****");
	        System.out.println("------------------------------------------------------");
	        System.out.println("|   Opção 1 - Criar conta   |");
	        System.out.println("|   Opção 2 - Depositar     |");
	        System.out.println("|   Opção 3 - Sacar         |");
	        System.out.println("|   Opção 4 - Transferir    |");
	        System.out.println("|   Opção 5 - Listar Contas |");
	        System.out.println("|   Opção 6 - Sair          |");
	        
	        int operacao = input.nextInt();
	        
	        switch(operacao) {
	        case 1:
	        	CriarConta();
	        	break;
	        case 2:
	        	Depositar();
	        	break;
	        case 3:
	        	Sacar();
	        	break;
	        case 4:
	        	Transferir();
	        	break;
	        case 5:
	        	ListarContas();
	        	break;
	        case 6:
	        	System.out.println("Obrigado pela Confiança! Volte Sempre.");
	        	System.exit(0);
	        	
	        	default:
	        		System.out.println("Opção invalida!");
	        		operacoes();
	        		break;
	        }
	     }
	
			public static void CriarConta() {
				System.out.println("\nNome: ");
				String nome = input.next();
				
				System.out.println("\nCPF: ");
				String cpf = input.next();
				
				System.out.println("\nEmail: ");
				String email = input.next(); 
				
				Cliente cliente = new Cliente(nome, cpf, email);
				
				Conta conta = new Conta(cliente);
				
				ContasBancarias.add(conta);
				System.out.println("Sua Conta foi criada com sucesso!");
				
				operacoes();
				
			}
			
			private static Conta encontrarConta(int numeroConta) {
				Conta conta = null;
				if(ContasBancarias.size() > 0) {
					for(Conta c: ContasBancarias) {
						if(c.getNumeroConta() == numeroConta) {
							conta = c;
						}
					}
				}
			
				return conta;	
      }
	      
			public static void Depositar() {
				System.out.println("Número da conta: ");
				int numeroConta = input.nextInt();
				
				Conta conta= encontrarConta(numeroConta);
				
				if(conta != null) {
					System.out.println("Qual valor você deseja depositar? ");
					double valorDeposito = input.nextInt();
					conta.depositar(valorDeposito);
				}else {
					System.out.println("Conta Não encontrada. ");
				}
				operacoes();
			}
			
			
			public static void Sacar() {
				System.out.println("Numero da conta: ");
				int numeroConta = input.nextInt();
				
				Conta conta= encontrarConta(numeroConta);
				
				if(conta != null) {
					System.out.println("Qual valor você deseja Sacar? ");
					double valorSaque = input.nextInt();
					conta.sacar(valorSaque);
				}else {
					System.out.println("Conta Não encontrada. ");
				}
				operacoes();			
			}
			
			public static void Transferir() {
				System.out.println("Número da conta do remetente: ");
				int numeroContaRemetente = input.nextInt();
				
				Conta contaRemetente = encontrarConta(numeroContaRemetente);
				
				if(contaRemetente != null) {
					System.out.println("Numero da conta do destinatario: ");
					int numeroContaDestinatario = input.nextInt();
					
					Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
					
					if(contaDestinatario != null) {
						System.out.println("Valor da Tranferência: ");
						double valor = input.nextDouble();
						
						contaRemetente.transferir(contaDestinatario, valor);
					}else {
						System.out.println("Conta para tranferência não encontrada!");
					}
					operacoes();
				}
				
			}
			
			public static void ListarContas() {
				if(ContasBancarias.size() > 0) {
					for(Conta conta: ContasBancarias) {
						System.out.println(conta);
					}
				}else {
					System.out.println("Não há contas cadastradas.");
				}
				operacoes();
			}
	
}
