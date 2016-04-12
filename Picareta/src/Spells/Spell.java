/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Spells;

/**
 *
 * @author Tiago
 */
public class Spell {
    String nome,descricao;
    int duracao;
    
    public Spell()
    {
        duracao=100;
        nome="resistente";
        descricao="tem uma chance de nao gastar quando usada";
    }
    public Spell(final Spell original)
    {
        this.duracao=original.duracao;
        this.nome=original.nome;
        this.descricao=original.descricao;
    }
    
    public boolean usar()
    {    if (duracao==0)
            return false;
         duracao-=1;
         return true;
    }
    /*
    ostream & operator<<(ostream & output,const Spell & feitico)
    {
        output <<feitico.nome
               <<"("
               <<feitico.duracao
               <<")-\""
               <<feitico.descricao
               <<"\"";
        return output;
    }*/
    public String getNome()
    {
        return nome;
    }
    public int getDuracao()
    {
        return duracao;
    }
}
