package taskmanager.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import taskmanager.model.StatusTarefa;
import taskmanager.model.Tarefa;
public class GerenciadorTarefas {
    List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }
    
    public void mostrarTarefas(){
        int i = 0;
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa.getInfo());
            i++;
        }
        System.out.println("Tarefas totais: "+i);
    }

    public List<Tarefa> mostrarPorStatus(StatusTarefa status){
        List<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus() == status) {
                filtradas.add(tarefa);
            }
        }
        return filtradas;
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
