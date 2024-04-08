package exec;

import java.util.Scanner;

public class Calc {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        Numero n1 = new Numero();
        Numero n2 = new Numero();
        Numero res = new Numero();
        String opc = "S";
        
        while (opc.equalsIgnoreCase("S")) {
            
            System.out.printf("%nDigite o valor 1: ");
            n1.SetValor(scan.nextInt());
            
            System.out.printf("%nDigite o valor 2: ");
            n2.SetValor(scan.nextInt());
            
            System.out.printf("%nEscolha a operação: %n1. Soma%n2. Subtração%n3. Multiplicação%n4. Divisão%n5. Verificar se são primos%nEscolha: ");
            int escolha = scan.nextInt();
            
            switch (escolha) {
                case 1:
                    res.SetValor(n1.getValor() + n2.getValor());
                    System.out.printf("%nA soma de %d com %d é igual a %d%n", n1.getValor(), n2.getValor(), res.getValor());
                    break;
                case 2:
                    res.SetValor(n1.getValor() - n2.getValor());
                    System.out.printf("%nA subtração de %d por %d é igual a %d%n", n1.getValor(), n2.getValor(), res.getValor());
                    break;
                case 3:
                    res.SetValor(n1.getValor() * n2.getValor());
                    System.out.printf("%nA multiplicação de %d por %d é igual a %d%n", n1.getValor(), n2.getValor(), res.getValor());
                    break;
                case 4:
                    if (n2.getValor() == 0) {
                        System.out.printf("%nNão é possível dividir por zero%n");
                    } else {
                        res.SetValor(n1.getValor() / n2.getValor());
                        System.out.printf("%nA divisão de %d por %d é igual a %d%n", n1.getValor(), n2.getValor(), res.getValor());
                    }
                    break;
                case 5:
                    System.out.printf("%nO número %d é primo? %s%n", n1.getValor(), n1.isPrime() ? "Sim" : "Não");
                    System.out.printf("%nO número %d é primo? %s%n", n2.getValor(), n2.isPrime() ? "Sim" : "Não");
                    break;
                default:
                    System.out.printf("%nOpção inválida%n");
            }
            
            System.out.printf("%nDeseja realizar outra operação? (S/N): ");
            opc = scan.next();
            System.out.printf("%n%n%n");
        }
        
        scan.close();
    }
}

