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
public abstract class Picareta extends Ferramenta implements Encantavel{
    private static int totalMinerado=0;
    protected int forca;
    
    
    abstract void minerar(Bloco target);
            
    public Picareta()
    {
        forca=0;
    }
    
    public Picareta(final Picareta rValue)
    {
        super((Ferramenta)rValue);
        forca=rValue.forca;
    }
    
    boolean equals(final Picareta rValue){
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
    public void usar(final  Bloco target )
    {
        minerar(target);
    }
    @Override
    public String toString() {
        return ("voce usou a picareta "+Picareta.totalMinerado+" vezes");
    }
    // metodos da interface

    /**
     *
     * @param nome
     * @return
     */

    @Override
    public boolean remover(final String nome)//remove todas as ocorrencias com o mesmo nome
    {  
        //primeiro checa se existe e remove caso exista
        int novoTamanho=feitico.length;
        for (int i=0;i<novoTamanho;i++)
            if ((feitico[i].getNome()).equals(nome))
            {
                feitico[i]=feitico[novoTamanho-1];
                novoTamanho--;
                i--;
                /* sempre que acha um feitico correspondente joga pro final
                   e diminui o tamanho do vetor
                   decrementa i para checar o valor que estava no final
                */
            }
        
        if (novoTamanho!=feitico.length)//se removeu algum cria um novo vetor
        {
            Spell temp[]= new Spell[novoTamanho];
            System.arraycopy(feitico, 0, temp, 0,novoTamanho);
            feitico=temp;
            return true;
        }else return false;

    }
   
    public Spell hasSpell(final String nome)
    {
       int i;
       for(i=0;i<feitico.length;i++)
       if (nome.equals(feitico[i].getNome()))
          return (feitico[i]);
       return null;
    }

    
}
