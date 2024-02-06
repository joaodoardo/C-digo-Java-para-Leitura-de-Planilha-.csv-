/**
 * Programa principal para Leitura de Planilha
 * @author joaoeduardo e givanildo
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();

        String notasAlunos = "src/notas_alunos.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(notasAlunos))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados[0].equals("Matricula")) {
                    continue;
                }

                int matricula = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double nota = Double.parseDouble(dados[2]);
                Aluno aluno = new Aluno(matricula, nome, nota);
                alunos.add(aluno);
            }

            System.out.println("Alunos com direito a exame final:");
            for (Aluno aluno : alunos) {
                if (aluno.getNota() >= 40 && aluno.getNota() < 60) {
                    System.out.println(aluno.getNome());
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
