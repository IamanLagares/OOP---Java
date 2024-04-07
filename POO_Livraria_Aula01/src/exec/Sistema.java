package exec;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Livraria livraria = new Livraria();

        while(opcao != 4){
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Detalhar Livro");
            System.out.println("4 - Sair");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                System.out.println("Adicionando livro");
                 int id;
                 String autor;
                 String anopublicacao;
                 String titulo;
                 String editora;

                 System.out.println("Id: \n");
                 id = sc.nextInt();
                 sc.nextLine();
                 System.out.println("Titulo: \n");
                 titulo = sc.nextLine();
                 System.out.println("Autor: \n");
                 autor = sc.nextLine();
                 System.out.println("Ano da publicação: \n");
                 anopublicacao = sc.nextLine();
                 System.out.println("Editora: \n");
                 editora = sc.nextLine();

                 Livros l = new Livros(id, titulo, autor, anopublicacao, editora);
                 livraria.CadastrarLivro(l);

                break;

                case 2:
                System.out.println("Listando livro");
                System.out.println(livraria.ListarLivros());
                break;

                case 3:
                    System.out.println("Detalhando livro\n");
                    System.out.println("Digite o ID do livro:");
                    int idLivroDetalhe = sc.nextInt();
                    Livros livroDetalhe = livraria.DetalharLivro(idLivroDetalhe);
                    if (livroDetalhe != null) {
                        System.out.println("\n Detalhes do livro:\n");
                        System.out.println("ID: " + livroDetalhe.id);
                        System.out.println("Título: " + livroDetalhe.titulo);
                        System.out.println("Autor: " + livroDetalhe.autor);
                        System.out.println("Ano de publicação: " + livroDetalhe.anoPublicacao);
                        System.out.println("Editora: " + livroDetalhe.editora +"\n\n");
                    } else {
                        System.out.println("Livro não encontrado.\n\n");
                    }
                    break;

                case 4:
                System.out.println("Saindo");
                break;

                default:
                System.out.println("Opção Inválida");
                break;
            }
        }

        sc.close();
    }
}