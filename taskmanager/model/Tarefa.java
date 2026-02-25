    package taskmanager.model;

    public class Tarefa {
        private int id;
        private String titulo;
        private String descricao;
        private StatusTarefa status;

        public Tarefa(int id, String titulo, String descricao){
            this.id = id;
            this.titulo = titulo;
            this.descricao = descricao;
            this.status = StatusTarefa.PENDENTE;
        }

        public void iniciarTarefa(){
            status = StatusTarefa.EM_ANDAMENTO;
        }

        public void concluirTarefa(){
            status = StatusTarefa.CONCLUIDA;
        }

        public StatusTarefa getStatus(){
            return status;
        }

        public int getId(){
            return id;
        }

        public String getTitulo(){
            return titulo;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getInfo(){
            return "ID: "+id+
                    " Título: "+titulo+
                    " Descrição: "+descricao+
                    " Concluída? "+status;
        }
    }
