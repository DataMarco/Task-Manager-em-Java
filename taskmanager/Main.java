package taskmanager;
import java.util.Scanner;
import taskmanager.model.Tarefa;
import taskmanager.service.GerenciadorTarefas;
public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean rodando = true;
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        while (rodando) {
            System.out.println("O que deseja fazer? [1] - Adicionar tarefa | [2] - Listar tarefas | [3]- Marcar como concluída | [4]- Remover Tarefa | 0- sair");
            int escolha = leitor.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Qual o ID da tarefa? ");
                    int Idnovo = leitor.nextInt();
                    Tarefa adicionar = gerenciador.encontrarId(Idnovo);
                    if (adicionar != null) {
                        System.out.println("Esse ID já existe.");
                        break;
                    }
                    leitor.nextLine();
                    System.out.println("Qual o título da tarefa? ");
                    String titulonovo = leitor.nextLine();
                    System.out.println("Qual a sua descrição? ");
                    String descricaonovo = leitor.nextLine();
                    Tarefa novatarefa = new Tarefa(Idnovo, titulonovo, descricaonovo);
                    gerenciador.adicionarTarefa(novatarefa);
                    System.out.println("Tarefa adicionada com sucesso.");
                    break;
                case 2:
                    System.out.println("Deseja listar as tarefas pendentes [1] | tarefas concluídas [2] | ou todas as tarefas? [3]");
                    int escolha2 = leitor.nextInt();
                    switch (escolha2) {
                        case 1:
                            gerenciador.mostrarPendentes();
                            break;
                        case 2:
                            gerenciador.motrarConcluidas();
                            break;
                        case 3:
                            gerenciador.mostrarTarefas();
                            break;
                        default:
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Qual o id da tarefa?");
                    int idnovo = leitor.nextInt();
                    gerenciador.encontrarId(idnovo);
                    if (gerenciador.encontrarId(idnovo) != null) {
                        gerenciador.marcarConcluida(idnovo);
                        System.out.println("Tarefa marcada como concluída.");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Qual o id da tarefa?");
                    int idremover = leitor.nextInt();
                    leitor.nextLine();
                    Tarefa tarefa = gerenciador.encontrarId(idremover);
                    if (tarefa != null) {
                        System.out.println("Deseja remover a tarefa: "+tarefa.getTitulo()+"? [S]/[N]");
                        String escolha3 = leitor.nextLine();
                        if (escolha3.equalsIgnoreCase("s")) {
                            gerenciador.removerTarefa(idremover);
                            System.out.println("Tarefa removida com sucesso.");
                        } else {
                            break;
                        }

                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Você saiu do programa.");
                    rodando = false;
            }
        }
        leitor.close();
    }
}
