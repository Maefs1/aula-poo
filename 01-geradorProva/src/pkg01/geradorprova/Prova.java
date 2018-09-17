/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.ArrayList;

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
    private ArrayList <Questao> listaQuestoes;
    
    public String obtemDetalhes ()
    {
        String retorno = "";
        retorno += "Nome da disciplina: " +this.getNomeDisciplina()+ "\r\n";
        retorno += "Data da prova: " +this.getData() + "\r\n";
        retorno += "Local da prova: " +this.getLocal() + "\r\n";
        retorno += "Peso da prova: " +this.getPeso() + "\r\n";
        retorno += "=========================================================================\r\n\n";
        
        return retorno;   
    }
    
    public String obtemProvaImpressao()
    {
        String retorno = this.obtemDetalhes();
        
        for (int i = 0; i < listaQuestoes.size(); i++)
        {
            retorno += this.listaQuestoes.get(i).retornaQuestao();
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
    
    public ArrayList <Questao> getListaQuestoes()
    {
        return listaQuestoes;
    }
    
    public void setListaQuestoes (ArrayList <Questao> listaQuestoes)
    {
        this.listaQuestoes = listaQuestoes;
    }   
}

