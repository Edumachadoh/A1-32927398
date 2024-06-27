import java.util.List;
/* a quantidade de alunos na turma, quantos foram aprovados com nota igual ou superior a 6,0, quantos foram reprovados, a menor nota da turma, a maior nota e a média geral. */
public class Menu {
    public static void executar() {
        ControleAluno ControleAlunos = new ControleAluno();

        List<Aluno> listaDeAlunos = ControleAlunos.getAlunos();

        System.out.println("Matricula / Nome / Nota ");
        
        int qtdAlunos = 0;
        int qtdAprovados = 0;
        int qtdReprovados = 0;
        double menorNota = 0;
        double maiorNota = 0;
        double soma = 0;
        double media = 0;
        
        for (Aluno Aluno : listaDeAlunos) {
            /*System.out.println(Aluno.getMatricula() + " / " + Aluno.getNome() + " / " + Aluno.getNota());*/
            qtdAlunos ++;
            soma += Aluno.getNota();

            if (Aluno.getNota() >= 6) {
                qtdAprovados ++;
            } else {
                qtdReprovados ++;
            }

            if (qtdAlunos == 1) {
                maiorNota = Aluno.getNota();
                menorNota = Aluno.getNota();
            } else {
                if (Aluno.getNota() > maiorNota) {
                    maiorNota = Aluno.getNota();
                } else if (Aluno.getNota() < menorNota) {
                    menorNota = Aluno.getNota();
                }
            }
         }
         media = soma / qtdAlunos;

         System.out.println(qtdAlunos);
         System.out.println(qtdAprovados);
         System.out.println(qtdReprovados);
         System.out.println(maiorNota);
         System.out.println(menorNota);
         System.out.println(media);

        if (ControleAlunos.gravar(qtdAlunos, qtdAprovados, qtdReprovados, menorNota, maiorNota, media)) {
            System.out.println("Gravado com sucesso");
        }


    }
}