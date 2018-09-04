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
        String auxString = "";
        
        retornaQuestao += "- " + this.getPergunta() +" (" + this.getPeso() + "):" + '\n';
                auxString = this.getOpcoes();
                for(int j = 0; j < 5; j++)
                    retornaQuestao += " (" + (j+1) + ") " + auxString[j] + '\n';
                retornaQuestao += "R: " + this.questoesObjetivas[i].getRespostaCorreta() + "\n\n";
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
