package pkg01.geradorprova;

import java.util.Scanner;

/**
 *
 * @author AndriyFujii
 */
public class GeradorProva {

    public static void main(String[] args) {
        Prova prova = new Prova();
        Scanner scannerAux = new Scanner(System.in);
        
        //Preenche o cabeçalho
        System.out.println("Digite o nome da disciplina da prova: ");
        prova.setNomeDisciplina(scannerAux.nextLine());
        
        System.out.println("Digite o local da prova:");
        prova.setLocal(scannerAux.nextLine());
        
        System.out.println("Digite a data da prova:");
        prova.setData(scannerAux.nextLine());
        
        System.out.println("Digite o peso da prova:");
        while(!scannerAux.hasNextInt())
        {
            System.out.println("Erro. Digite um número inteiro.");
            scannerAux.next();
        }
        prova.setPeso(scannerAux.nextInt());
        scannerAux.nextLine();
        
        int tamanho;
        
        //Preenche as questões discursivas
        System.out.println("Digite a quantidade de questões discursivas:");
        while(!scannerAux.hasNextInt())
        {
            System.out.println("Erro. Digite um número inteiro.");
            scannerAux.next();
        }
        tamanho = scannerAux.nextInt();
        scannerAux.nextLine();
        
        Discursiva[] questoesDiscursivas = new Discursiva[tamanho];
        for(int i = 0; i < tamanho; i++)
        {
            questoesDiscursivas[i] = new Discursiva();
            
            System.out.println("Digite a questão:");
            questoesDiscursivas[i].setPergunta(scannerAux.nextLine());
            
            System.out.println("Digite o peso da questão:");
            while(!scannerAux.hasNextDouble())
            {
                System.out.println("Erro. Digite um número inteiro ou decimal.");
                scannerAux.next();
            }
            questoesDiscursivas[i].setPeso(scannerAux.nextDouble());
            scannerAux.nextLine();
            
            System.out.println("Digite os critérios de correção da questão:");
            questoesDiscursivas[i].setCriteriosCorrecao(scannerAux.nextLine());
        }
        prova.setQuestoesDiscursivas(questoesDiscursivas);
        
        //Preenche as questões objetivas
        System.out.println("Digite a quantidade de questões objetivas:");
        while(!scannerAux.hasNextInt())
        {
            System.out.println("Erro. Digite um número inteiro.");
            scannerAux.next();
        }
        tamanho = scannerAux.nextInt();
        scannerAux.nextLine();
        
        Objetiva[] questoesObjetivas = new Objetiva[tamanho];
        for(int i = 0; i < tamanho; i++)
        {
            questoesObjetivas[i] = new Objetiva();
            
            System.out.println("Digite a questão:");
            questoesObjetivas[i].setPergunta(scannerAux.nextLine());
            
            System.out.println("Digite o peso da questão:");
            while(!scannerAux.hasNextDouble())
            {
                System.out.println("Erro. Digite um número inteiro ou decimal.");
                scannerAux.next();
            }
            questoesObjetivas[i].setPeso(scannerAux.nextDouble());
            scannerAux.nextLine();
            
            System.out.println("Digite as cinco opções da pergunta");
            String[] opcoes = new String[5];
            for(int j = 0; j < opcoes.length; j++)
            {
                System.out.println("Opção "+ (j+1) +":");
                opcoes[j] = scannerAux.nextLine();
            }
            questoesObjetivas[i].setOpcoes(opcoes);
            
            int auxInt;
            do
            {
                System.out.println("Digite a alternativa correta (1 a 5):");
                while(!scannerAux.hasNextInt())
                {
                    System.out.println("Erro. Digite um número inteiro ou decimal.");
                    scannerAux.next();
                }
                auxInt = scannerAux.nextInt();
                if(auxInt < 1 || auxInt > 5)
                    System.out.println("Erro. Digite um número entre 1 e 5.");
            }
            while(auxInt < 1 || auxInt > 5);
            questoesObjetivas[i].setRespostaCorreta(auxInt-1);
            scannerAux.nextLine();
        }
        scannerAux.close();
        prova.setQuestoesObjetivas(questoesObjetivas);
        
        //Mostra a prova para impressão
        System.out.println("\n\n" + prova.obtemDetalhes());
        System.out.println(prova.obtemProvaImpressao());
    }
    
}