import java.util.List;


public class ControleAluno {
     private GerenciadorArquivosAlunos gravadorArquivos = new GerenciadorArquivosAlunos();
    private List<Aluno> alunos;

    public ControleAluno() {
        this.alunos = gravadorArquivos.getAlunos();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
 
    public boolean gravar(int qtdAlunos, int qtdAprovados, int qtdReprovados, double maiorNota, double menorNota, double media) {
        return gravadorArquivos.gravar(qtdAlunos, qtdAprovados, qtdReprovados, menorNota, maiorNota, media);
    }

}