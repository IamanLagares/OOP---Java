package exec;

public class Numero {
    
    private int valor;

    public Numero() {
        this.valor = 0;
    }

    public void SetValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public boolean isPrime() {
        if (this.valor <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(this.valor); i++) {
            if (this.valor % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
