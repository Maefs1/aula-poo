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
public class Prova 
{
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private Objetiva [] questoesObjetivas;
    private Discursiva [] questoesDiscursivas;
    
    public String obtemDetalhes ()
    {
        String retorno = "";
        retorno += "Nome da disciplina: "+this.getNomeDisciplina()+'\n';
        retorno += "Data da prova: "+this.getData() +'\n';
        retorno += "Local da prova: "+this.getLocal() + '\n';
        retorno += "Peso da prova: "+this.getPeso() + '\n';
        
        return retorno;   
    }
    
    public String obtemProvaImpressao()
        {
            String retorno = "";
            int contQuestao = 1;
            
            for (int i = 0; i < this.questoesDiscursivas.length; i++)
            {
                retorno += contQuestao + "- " + this.questoesDiscursivas[i].getPergunta() + " (" + this.questoesDiscursivas[i].getPeso() + "):" + '\n';
                retorno += "R: " + this.questoesDiscursivas[i].getCriteriosCorrecao() + "\n\n";
                contQuestao++;
            }
        String[] auxString = new String[5];
            for(int i = 0; i < this.questoesObjetivas.length; i++)
            {
                retorno += contQuestao + "- " + this.questoesObjetivas[i].getPergunta() +" (" + this.questoesObjetivas[i].getPeso() + "):" + '\n';
                auxString = this.questoesObjetivas[i].getOpcoes();
                for(int j = 0; j < 5; j++)
                    retorno += " (" + (j+1) + ") " + auxString[j] + '\n';
                retorno += "R: " + this.questoesObjetivas[i].getRespostaCorreta() + "\n\n";
                contQuestao++;
            }
            
            return retorno;
        }
    
    public String getNomeDisciplina()
    {
        return nomeDisciplina;
    }
    
    public void setNomeDisciplina (String nomeDisciplina)
    {
        this.nomeDisciplina = nomeDisciplina;
    }
      
    public int getPeso()
    {
        return peso;
    }
    
    public void setPeso (int peso)
    {
        this.peso = peso;
    }
    
    public String getLocal ()
    {
        return local;
    }
    
    public void setLocal (String local)
    {
        this.local = local;
    }
    
    public String getData ()
    {
        return data;
    }
    
    public void setData (String data)
    {
        this.data = data;
    }
    
    public Discursiva[] getQuestoesDiscursivas () 
    {
        return questoesDiscursivas;
    }
    
    public void setQuestoesDiscursivas (Discursiva[] questoesDiscursivas)
    {
        this.questoesDiscursivas = questoesDiscursivas;
    }
    
    public Objetiva[] getQuestoesObjetivas () 
    {
        return questoesObjetivas;
    }
    
    public void setQuestoesObjetivas(Objetiva[] questoesObjetivas) 
    {
        this.questoesObjetivas = questoesObjetivas;
    }
}

