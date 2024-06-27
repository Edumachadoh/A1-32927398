import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GerenciadorArquivosAlunos {
    public class GerenciadorDeArquivosAeronaves {

    public GerenciadorDeArquivosAeronaves() {
       
    }
}

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        try {
            File arquivoLeitura = new File("C:\\A1 GEucimar\\alunos.csv");
            Scanner leitor = new Scanner(arquivoLeitura);

            String header =leitor.nextLine();
            

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                int matricula = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double nota = Double.parseDouble(dados[2]);

                Aluno aluno = new Aluno(matricula, nome, nota);

                alunos.add(aluno);

            }    
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo Pessoas nao encontrado!");
        }

        return alunos;
    }

    public boolean gravar(int qtdAlunos, int qtdAprovados, int qtdReprovados, double maiorNota, double menorNota, double media) {
        try {
            FileWriter arquivoGravar = new FileWriter("C:\\A1 GEucimar\\resumo.csv");
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println("quantidadeAlunos / aprovados / reprovados / maiorNota / menorNota / media");
            gravador.println(qtdAlunos + ";" +qtdAprovados + ";" + qtdReprovados + ";"+ menorNota + ";" + maiorNota + ";" + media);
            gravador.close();
            
            return true;

        } 
        catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }

        return false;
    }
}