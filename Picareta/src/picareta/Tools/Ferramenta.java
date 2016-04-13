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
        super();
        feitico=new Spell[0];
    }
    Ferramenta( final Ferramenta rValue)
    {
        this();
        if (rValue.feitico!=null)
            this.feitico=rValue.feitico.clone();
        this.durabilidade=rValue.durabilidade;
    }
    public abstract void consertar(final Ferramenta tool);
    public abstract void usar(final Bloco target);    
    public int compareTo(final Ferramenta other) {
        // return this.id - otherStudent.id ; //result of this operation can overflow
        if (this.durabilidade==other.durabilidade) return 0;
        if (this.durabilidade>other.durabilidade) return 1;
        else return -1;

     }

}
