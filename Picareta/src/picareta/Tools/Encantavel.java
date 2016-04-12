/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta.Tools;

import Spells.Spell;

/**
 *
 * @author Tiago
 */
public interface Encantavel {
    //ira gerenciar os encantamentos no lugar de Ferramenta
    public boolean encantar(final Spell novo);
    public boolean encantar();

    public boolean remover(final Spell spellTemp);
    public boolean remover(final String nome);
    
    public Spell hasSpell(final String nome);
    
       
    
}
