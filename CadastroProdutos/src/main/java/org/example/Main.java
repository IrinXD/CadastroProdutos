import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, Produto> produtos = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    buscarProduto(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        scanner.close();
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        if(produtos.containsKey(codigo)) {
            System.out.println("Código já cadastrado!");
            return;
        }

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        produtos.put(codigo, new Produto(codigo, nome, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void buscarProduto(Scanner scanner) {
        System.out.print("Digite o código para busca: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtos.get(codigo);
        if(produto == null) {
            System.out.println("Produto não encontrado!");
        } else {
            System.out.println("\nDetalhes do Produto:");
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
        }
    }
}