package pkg01.geradorprova;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class GeradorProva
{
    public static float verificaFloat()
    {
        float n = 0;
        boolean sair = false;
        do
        {
            try
            {
                n = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso da questão:"));

                if(n <= 0)
                    JOptionPane.showMessageDialog(null, 
                            "Por favor, digite um número maior que zero.", 
                            "Erro!", 
                            JOptionPane.ERROR_MESSAGE);
                else
                    sair = true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, 
                        "Por favor, digite um número inteiro ou decimal.", 
                        "Erro!", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        while(!sair);
        return n;
    }
    

    public static String verificaString(String msg, String msgErro)
    {
        String retorno;
        do
        {
            retorno = JOptionPane.showInputDialog(msg);
            if(retorno == null || retorno.isEmpty())
                JOptionPane.showMessageDialog(null, 
                        msgErro, 
                        "Erro!", 
                        JOptionPane.ERROR_MESSAGE);
        }
        while(retorno == null || retorno.isEmpty());
        return retorno;
    }
    
    public static void main(String[] args)
    {
        Prova prova = new Prova();
        
        prova.setNomeDisciplina(verificaString("Digite o nome da disciplina:", 
                "Por favor, digite o nome da disciplina."));
        prova.setLocal(verificaString("Digite o local da prova:", 
                "Por favor, digite o local da prova."));
        prova.setData(verificaString("Digite a data da prova:", 
                "Por favor, digite a data da prova."));
        
        boolean sair = false;
        int intAux = 0;
        do
        {
            try
            {
                intAux = Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da prova:"));
                
                if(intAux <= 0)
                    JOptionPane.showMessageDialog(null, 
                            "Por favor, digite um número maior que zero.", 
                            "Erro!", 
                            JOptionPane.ERROR_MESSAGE);
                else
                    sair = true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, 
                        "Por favor, digite um número inteiro.", 
                        "Erro!", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        while(!sair);
        sair = false;
        
        prova.setPeso(intAux);
        
        ArrayList<Questao> listaQuestoes = new ArrayList();
        
        Object[] opcoes = {"Objetiva", "Discursiva", "Sair"};
        do
        {
            intAux = JOptionPane.showOptionDialog(null, 
                    "Escolha o tipo de questão:", 
                    "Entrada" ,
                    JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opcoes, 
                    opcoes[0]);
            
            switch(intAux)
            {

                case JOptionPane.NO_OPTION:
                    Discursiva questaoDiscursiva = new Discursiva();
                    
                    questaoDiscursiva.setPergunta(verificaString("Digite a questão:", 
                            "Por favor, digite a questão."));
                    questaoDiscursiva.setPeso(verificaFloat());
                    questaoDiscursiva.setCriteriosCorrecao(verificaString("Digite os critérios de correção:", 
                            "Por favor, digite os critérios de correção."));
                    
                    listaQuestoes.add(questaoDiscursiva);
                    break;

                case JOptionPane.YES_OPTION:
                    Objetiva questaoObjetiva = new Objetiva();
                    
                    questaoObjetiva.setPergunta(verificaString("Digite a questão:", 
                            "Por favor, digite a questão."));
                    questaoObjetiva.setPeso(verificaFloat());
                    
                    String[] stringAux = new String[5];
                    for(int i = 0;i < stringAux.length; i++)
                        stringAux[i] = verificaString("Opção " + (i+1) + ":", "Por favor, digite a alternativa.");
                    questaoObjetiva.setOpcoes(stringAux);
                    
                    do
                    {
                        try
                        {
                        Integer[] possibilidades = {1, 2, 3, 4, 5};
                            intAux = (Integer)JOptionPane.showInputDialog(null, 
                                    "Digite a alternativa correta:", 
                                    "Alternativa Correta", 
                                    JOptionPane.PLAIN_MESSAGE, 
                                    null, 
                                    possibilidades, 
                                    possibilidades[0]);
                            sair = true;
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(null, 
                                    "Por favor, escolha a alternativa correta.", 
                                    "Erro!", 
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    while(!sair);
                    sair = false;
                    
                    questaoObjetiva.setRespostaCorreta(intAux-1);
                    
                    listaQuestoes.add(questaoObjetiva);
                    break;
                default:
                    sair = true;
                    break;
            }
            
        }
        while(!sair);
        
        prova.setListaQuestoes(listaQuestoes);
        

        String salvar = prova.obtemProvaImpressao();
        JOptionPane.showMessageDialog(null, 
                salvar, 
                "Prova para impressão", 
                JOptionPane.PLAIN_MESSAGE);
        

        try
        {
            Files.write(Paths.get("prova.txt"), salvar.getBytes());
            JOptionPane.showMessageDialog(null,
                    "Prova salva em um arquivo de texto.");
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível salvar a prova.",
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}