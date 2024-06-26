package Utils;

import java.util.Scanner;

public class Utils {
	
	public static int menuBackHandler(Scanner sc) {
		System.out.println("1 ----- Ação ---- ");
		System.out.println("1 - Voltar ao Menu");
		System.out.println("2 - Log Out rápido");
		
		int acaoRes = sc.nextInt();
		sc.nextLine();
		
		if(acaoRes == 1) {
			return 1;
		}else if(acaoRes == 2) {
			System.out.println("Log Out realizado com sucesso.");
			return 2;
		}else {
			System.out.println("Opção inválida");
		}
		return acaoRes;
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) { // Ajuste o número de linhas conforme necessário
			System.out.println();
		}
	}
}
