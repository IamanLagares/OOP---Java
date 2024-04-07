package exec;

import java.util.ArrayList;

public class Livraria {
    private ArrayList<Livros> livros;

    public Livraria(){
        this.livros = new ArrayList<>();
    }

    public void CadastrarLivro(Livros livro){
        this.livros.add(livro);
    }

    public String ListarLivros(){
        StringBuilder listaLivros = new StringBuilder();

        for (Livros l : this.livros){
            listaLivros.append(l.id).append("-").append(l.titulo).append("\n\n");
        }

        return listaLivros.toString();
    }

    public Livros DetalharLivro(int idLivro) {
        for (Livros livro : this.livros) {
            if (livro.id == idLivro) {
                return livro;
            }
        }
        return null;
    }
}
