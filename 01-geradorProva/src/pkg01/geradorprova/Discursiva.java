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
final class Discursiva extends Questao 
{
    private String criteriosCorrecao;
    
    @Override
    public String retornaQuestao()
    {
        String questaoRetorno = "";
        questaoRetorno += "- " + this.getPergunta() + " (peso " + this.getPeso() + "):" + "\r\n";
                questaoRetorno += "______________________________________________________________\r\n";
                questaoRetorno += "______________________________________________________________\r\n";
                questaoRetorno += "______________________________________________________________\r\n";
                questaoRetorno += "Critérios de avaliação: " + this.getCriteriosCorrecao() + "\r\n\n";
        return questaoRetorno;
    } 
            
    
    public String getCriteriosCorrecao ()
    {
        return criteriosCorrecao;
    }
    
    public void setCriteriosCorrecao (String criteriosCorrecao)
    {
        this.criteriosCorrecao = criteriosCorrecao;
    }
}
