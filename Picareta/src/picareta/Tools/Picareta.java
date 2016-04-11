/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta.Tools;

import Blocos.Bloco;

/**
 *
 * @author Tiago
 */
public abstract class Picareta extends Ferramenta implements Encantavel,Melhoravel{
    private static int totalMinerado=0;
    
    
    abstract void minerar(Bloco target);
            
    public Picareta()
    {
    }
    
    public Picareta(Picareta rValue)
    {
        durabilidade=rValue.durabilidade;
    }
    
    boolean equals(Picareta rValue){
        if (durabilidade!=rValue.durabilidade)
            if (feitico!=feitico)
                return false;
        return true;
    }

    
    public void increaseTotalMinerado()
    {
           totalMinerado++;
    }
    
    @Override
    public void usar( Bloco target )
    {
        minerar(target);
    }
    @Override
    public String toString() {
        return ("voce usou a picareta "+Picareta.totalMinerado+" vezes");
    }

    
}
