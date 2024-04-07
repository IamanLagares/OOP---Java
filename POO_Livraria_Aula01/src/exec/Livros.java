package exec;

public class Livros {
    public int id;
    public String autor;
    public String anoPublicacao;
    public String titulo;
    public String editora;

    public Livros (int id, String titulo, String autor, String anoPublicacao, String editora){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
    }
}
