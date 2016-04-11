/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta.Tools;

import Blocos.Bloco;
import Spells.Spell;

/**
 *
 * @author Tiago
 */
public abstract class Ferramenta {
    protected int durabilidade;
    protected Spell []feitico;    
    
    
    Ferramenta()
    {

    }
    Ferramenta( Ferramenta rValue)
    {
        this.feitico=rValue.feitico.clone();
        this.durabilidade=rValue.durabilidade;
    }
    public abstract void consertar(Ferramenta tool);
    public abstract void usar(Bloco target);
    public boolean encantar(Spell novo)
    {
        if (novo==null) return false;
        
        Spell temp[]= new Spell[feitico.length+1];
        System.arraycopy(feitico, 0, temp, 0, feitico.length);
        temp[temp.length]=novo;
        feitico=temp;
        return true;
    } 

    public boolean remover(Spell spellTemp)
    { 
    boolean flag=false;  
        //primeiro checa se existe e remove caso exista
        for (int i=0;i<feitico.length;i++)
            if ((feitico[i])==spellTemp)
            {
                flag=true;
                feitico[i]=feitico[feitico.length-1];
            }
        //se removeu cria um novo vetor
        if (flag==true)
        {
            Spell temp[]= new Spell[feitico.length-1];
            System.arraycopy(feitico, 0, temp, 0, feitico.length-1);
            feitico=temp;
            return true;
        }else return false;

    }
    public Spell hasSpell(String nome)
    {
       int i;
       for(i=0;i<feitico.length;i++)
       if (nome.equals(feitico[i].getNome()))
          return (feitico[i]);
       return null;
    }   
    public int compareTo(Ferramenta other) {
        // return this.id - otherStudent.id ; //result of this operation can overflow
        if (this.durabilidade==other.durabilidade) return 0;
        if (this.durabilidade>other.durabilidade) return 1;
        else return -1;

     }

}
