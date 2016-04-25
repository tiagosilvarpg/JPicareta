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
public abstract class Picareta extends Ferramenta implements Encantavel,Melhoravel{
    private static int totalMinerado=0;
    protected int forca;
    protected Spell []feitico; 
    
    abstract void minerar(Bloco target);
            
    public Picareta()
    {
        this.forca=0;
        this.feitico=new Spell[0];
    }
    
    public Picareta(final Picareta rValue)
    {
        super((Ferramenta)rValue);
        this.forca=rValue.forca;
        this.feitico=new Spell[rValue.feitico.length];
        for (int i=0;i<rValue.feitico.length;i++)
             this.feitico[i]=new Spell(rValue.feitico[i]);
    }
    
    boolean equals(final Picareta rValue){
        if (durabilidade!=rValue.durabilidade)
        if (this.forca==rValue.forca)
            return true;
        return false;
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
    @Override
    public boolean encantar()
    {
                
        Spell temp[]= new Spell[feitico.length+1];
        System.arraycopy(feitico, 0, temp, 0, feitico.length);
        temp[temp.length-1]=new Spell();
        feitico=temp;
        return true;
    }
    
    @Override
    public boolean remover(final String nome)//remove todas as ocorrencias com o mesmo nome
    {  
        int novoTamanho=this.feitico.length;
        
        for (int i=0;i<this.feitico.length;i++)//remove os que batem/mede o novo tamanho
            if ((this.feitico[i].getNome()).equals(nome))
            {
                this.feitico[i]=null;
                novoTamanho--; 
            }        
        if (novoTamanho!=this.feitico.length)//se removeu algum cria um novo vetor
        {
            Spell temp[]= new Spell[novoTamanho];
            int j=0;
            for (int i=0;i<this.feitico.length;i++)//copia os nao nulos
                if (this.feitico[i]!=null)
                {
                    temp[j]=this.feitico[i];
                    j++;
                }       
            this.feitico=temp;//troca as referencias
            return true;
        }
        return false;
    }
   
    @Override
    public Spell hasSpell(final String nome)//retorna o primeiro encontrado
    {
        int i;
        for(i=0;i<feitico.length;i++)
            if (nome.equals(feitico[i].getNome()))
                return (feitico[i]);
       return null;
    }

    

    
}
