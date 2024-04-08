package Exec;

import utilities.Util;

public class Conta {
	
	private static int ContadorDeContas = 1;
	
	private int NumeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		super();
		NumeroConta = ContadorDeContas;
		this.cliente = cliente;
		ContadorDeContas += 1;	
	}
	

	public int getNumeroConta() {
		return NumeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		NumeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() +
				"\nNome: " + this.cliente.getNome() +
				"\nCPF: " + this.cliente.getCPF() +
				"\nEmail: " + this.cliente.getEmail() +
				"\nSaldo: " + Util.doubletoString(this.getSaldo()) + "\n";		
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu Deposito foi realizado com sucesso!");
	    }else {
	    	System.out.println("Não foi possivel realizar o seu deposito!");
	    }
	}
	
	public void sacar(double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar o saque!");
		}
	}
	
	public void transferir(Conta contaParaDeposito, double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Tranferência Realizada com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar a tranferência.");
		}
			
		
	}
	
	
	
	

}
