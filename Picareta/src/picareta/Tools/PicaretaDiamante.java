/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta.Tools;

import Blocos.Bloco;
import Spells.Spell;
import java.util.Random;


/**
 *
 * @author Tiago
 */
public class PicaretaDiamante extends Picareta{
    private static int durabilidadeMaxima =1561;
    private static int forca=10;
    
    int forcaBase=10;
    //CONSTRUTOR
    PicaretaDiamante()
    {
        durabilidade=durabilidadeMaxima;
        forca=forcaBase;
    }
    PicaretaDiamante( PicaretaDiamante rValue)
    {
        durabilidade=rValue.durabilidade;
        forca=rValue.forca;
    }
    
    @Override
    public String toString()
    {
        int i;
        String output;
        output ="Picareta de Diamante,"
               +durabilidade
               +"/"
               +durabilidadeMaxima;

        for ( i=0; i<feitico.length; i++ )
        {
            output += "   spell["
                   +i
                   +"]="
                   +feitico[i];  
        }
        return output;
    }

    boolean equals( PicaretaDiamante rValue)
    {
           
        if (durabilidade==rValue.durabilidade)
            if (feitico==rValue.feitico)          
                return true;
        return false;
    }
    
    @Override
    public void consertar( Ferramenta  rValue)
    {    
        
        if (rValue instanceof PicaretaDiamante)
        {
            this.durabilidade+=rValue.durabilidade;
            if (this.durabilidade>this.durabilidadeMaxima)
               this.durabilidade=this.durabilidadeMaxima ;
            rValue.durabilidade=0;
        }
        else System.out.println("precisa de uma picareta de diamante para isso");
    }
    @Override
    void minerar(Bloco target)
    {
        Spell spellTemp;
        Random random=new Random();
        if (durabilidade==0) 
        {  System.out.println("sua picareta esta quebrada");
        }
        if (target.getResistencia()<=80)//se for abaixo ou igual a diamante
        {
           if (target.damage(forca))
            {
               increaseTotalMinerado();
               spellTemp=hasSpell("resistente");

               if (spellTemp!=null)
               {
                  if (spellTemp.usar())
                     durabilidade-= random.nextInt() % 2;
                  else
                  {   System.out.println(spellTemp+" expirou");
                      remover(spellTemp);                      
                      durabilidade-=1;
                  }
               }
               else durabilidade-=1;
            }
        }
        else System.out.println("essa picareta é muito fraca pra isso");    
    }

    
}
