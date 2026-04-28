
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LivroController controller = new LivroController();
        int opcao;

        do {
            System.out.println("\n=== MENU LIVROS ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Remover Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    controller.adicionarLivro(titulo, autor, ano);
                    System.out.println("Livro cadastrado!");
                    break;
                case 2:
                    for (Livro l : controller.listarLivros()) {
                        System.out.println(l);
                    }
                    break;
                case 3:
                    System.out.print("ID do livro para emprestar: ");
                    int idEmp = sc.nextInt();
                    Livro le = controller.buscarPorId(idEmp);
                    if (le != null && !le.isEmprestado()) {
                        le.emprestar();
                        controller.salvar();
                        System.out.println("Livro emprestado.");
                    } else {
                        System.out.println("Livro não encontrado ou já emprestado.");
                    }
                    break;
                case 4:
                    System.out.print("ID do livro para devolver: ");
                    int idDev = sc.nextInt();
                    Livro ld = controller.buscarPorId(idDev);
                    if (ld != null && ld.isEmprestado()) {
                        ld.devolver();
                        controller.salvar();
                        System.out.println("Livro devolvido.");
                    } else {
                        System.out.println("Livro não encontrado ou não emprestado.");
                    }
                    break;
                case 5:
                    System.out.print("ID do livro para remover: ");
                    int idRem = sc.nextInt();
                    boolean removido = controller.removerLivro(idRem);
                    System.out.println(removido ? "Removido com sucesso." : "Livro não encontrado.");
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
        sc.close();
    }
}
