package taskmanager.service;
import java.util.ArrayList;
import java.util.Iterator;
import taskmanager.model.StatusTarefa;
import taskmanager.model.Tarefa;
public class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }
    
    public void mostrarTarefas(){
        int i = 0;
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa.getInfo());
            i++;
            System.out.println("Tarefas totais: "+i);
        }
    }

    public void motrarConcluidas(){
        int i = 0;
        for (Tarefa tarefa : tarefas){
            if (tarefa.getStatus() == StatusTarefa.CONCLUIDA){
                System.out.println(tarefa.getInfo());
                i++;
                System.out.println("Tarefas concluídas: "+i);
            }
        }
    }

    public void mostrarPendentes(){
        int i = 0;
        for (Tarefa tarefa : tarefas){
            if (tarefa.getStatus() == StatusTarefa.PENDENTE) {
                System.out.println(tarefa.getInfo());
                i++;
                System.out.println("Tarefas pendentes: "+i);
            }
        }
    }

    public Tarefa encontrarId(int id){
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId()==id) {
                return tarefa;
            }
        }
        return null;
    }
    
    public boolean removerTarefa(int id){
        Iterator<Tarefa> iterator = tarefas.iterator();

        while (iterator.hasNext()) {
            Tarefa tarefa = iterator.next();
            if (tarefa.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean marcarConcluida(int id){
        Tarefa tarefa = encontrarId(id);
        if (tarefa != null) {
            tarefa.concluirTarefa();
            return true;
        }
        return false;
    }
}
