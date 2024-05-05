import java.util.ArrayList;
import java.util.Scanner;

import interfaces.trabalhavel;

public class Sistema {

    public static  void iniciarSistema(){

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Menu de opções
        int opcao;
        do {
            System.out.println("1. Adicionar funcionario");
            System.out.println("2. Remover funcionario");
            System.out.println("3. Exibir todos os funcionarios");
            System.out.println("4. Buscar funcionario por nome");
            System.out.println("5. Buscar funcionario por matricula");
            System.out.println("6. Realizar acoes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(funcionarios, scanner);
                    break;
                case 2:
                    removerFuncionario(funcionarios, scanner);
                    break;
                case 3:
                    exibirFuncionarios(funcionarios);
                    break;
                case 4:
                    buscarFuncionarioPorNome(funcionarios, scanner);
                    break;
                case 5:
                    buscarFuncionarioPorMatricula(funcionarios, scanner);
                    break;
                case 6:
                    realizarAcoes(funcionarios);
                break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Métodos auxiliares
    private static void adicionarFuncionario(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.println("Digite o tipo de funcionario (1. Gerente, 2. Desenvolvedor, 3. Estagiario): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome do funcionario: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matricula do funcionario: ");
        int matricula = scanner.nextInt();
               

        switch (tipo) {
            case 1:
                System.out.print("Digite o bonus anual do gerente: ");
                double bonusAnual = scanner.nextDouble();
                funcionarios.add(new Gerente(nome, matricula, bonusAnual));
                break;
            case 2:
                System.out.print("Digite salario base do funcionario: ");
                double salarioBase = scanner.nextDouble();
                System.out.print("Digite nivel de experiencia do funcionario: ");
                int nivelExperiencia = scanner.nextInt();
                funcionarios.add(new Desenvolvedor(nome, matricula, salarioBase, nivelExperiencia));
                break;
            case 3:
                System.out.print("Digite as horas de trabalho do estagiario: ");
                int horasTrabalho = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome do supervisor do estagiario: ");
                String supervisor = scanner.nextLine();
                System.out.print("Digite taxa da hora do estagiario: ");
                double taxaHora = scanner.nextDouble();
                funcionarios.add(new Estagiario(nome, matricula, horasTrabalho, supervisor, taxaHora));
                break;
            default:
                System.out.println("Tipo de funcionario invalido!");
        }
    }

    private static void removerFuncionario(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite a matricula do funcionario a ser removido: ");
        int matricula = scanner.nextInt();
        boolean removido = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                funcionarios.remove(funcionario);
                removido = true;
                break;
            }
        }
        if (removido) {
            System.out.println("Funcionario removido com sucesso!");
        } else {
            System.out.println("Funcionario nao encontrado!");
        }
    }

    private static void exibirFuncionarios(ArrayList<Funcionario> funcionarios) {
        System.out.println("Lista de funcionarios:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - " + funcionario.getClass().getSimpleName());
        }
    }

    private static void buscarFuncionarioPorNome(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite o nome do funcionario a ser buscado: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Funcionario encontrado:");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Matricula: " + funcionario.getMatricula());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Funcionario nao encontrado!");
        }
    }

    private static void buscarFuncionarioPorMatricula(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite a matricula do funcionario a ser buscado: ");
        int matricula = scanner.nextInt();
        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                System.out.println("Funcionario encontrado:");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Matricula: " + funcionario.getMatricula());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Funcionario nao encontrado!");
        }
    }

    private static void realizarAcoes(ArrayList<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof trabalhavel) {
                trabalhavel trabalhavel = (trabalhavel) funcionario;
                trabalhavel.trabalhar();
                trabalhavel.relatarProgresso();
            }
        }
    }

}
