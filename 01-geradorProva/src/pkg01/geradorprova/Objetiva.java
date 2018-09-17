/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author mathe
 */
final class Objetiva extends Questao 
{
    private String[] opcoes;
    private int respostaCorreta;
   
    public String retornaQuestao()
    {
        String retornaQuestao = "";
        String[] auxString = new String[5];
        char letra = 'a';
        
        retornaQuestao += "- " + this.getPergunta() +" (peso " + this.getPeso() + "):" + "\r\n";
        auxString = this.opcoes;
        for(int j = 0; j < 5; j++)
        {
            retornaQuestao += " (" + (letra) + ") " + auxString[j] + "\r\n";
            letra++;
        }
            

        
        return retornaQuestao;
                
    }
    
    public Objetiva ()
    {
        this.opcoes = new String[5];
    }
    
    public String[] getOpcoes () 
    {
        return opcoes;
    }
    
    public void setOpcoes (String[] opcoes) 
    {
        this.opcoes = opcoes;
    }
    
    public int getRespostaCorreta () 
    {
        return respostaCorreta;
    }
    
    public void setRespostaCorreta (int respostaCorreta) 
    {
        this.respostaCorreta = respostaCorreta;
    }
}
