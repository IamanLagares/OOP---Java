package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Util {
	
	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
		
		public static String doubletoString (Double valor) {
			return formatandoValores.format(valor);
		}
}


/*Implementa um método para formatar valores monetários em uma string */
/*no formato de moeda brasileira (R$), com separadores de milhares e duas casas decimais*/
/*utilizando as classes DecimalFormat e NumberFormat da biblioteca Java.*/
