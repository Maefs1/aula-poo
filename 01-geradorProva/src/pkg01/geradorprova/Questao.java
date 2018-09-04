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
abstract class Questao 
{
    private String pergunta;
    private double peso;
    
    abstract String retornaQuestao();
            
    public String getPergunta()
    {
        return pergunta;
    }
    
    public void setPergunta (String pergunta)
    {
        this.pergunta = pergunta;
    }
    
    public double getPeso()
    {
        return peso;
    }
    
    public void setPeso (double peso)
    {
        this.peso = peso;
    }
}
