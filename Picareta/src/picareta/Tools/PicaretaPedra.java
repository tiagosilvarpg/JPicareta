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
public class PicaretaPedra extends Picareta{
    private static int durabilidadeMaxima =131;
    private static int forcaBase=6;
    public PicaretaPedra()
    {
        super();
        durabilidade=durabilidadeMaxima;
        forca=forcaBase;
    }
    public PicaretaPedra(final PicaretaPedra rValue)
    {
        super(rValue);
    }
    @Override
    public String toString()
    {
        int i;
        String output;
        output ="Picareta de Pedra,"
               +durabilidade
               +"/"
               +durabilidadeMaxima;

        for ( i=0; i<feitico.length; i++ )
        {
            output += "\n   spell["
                   +i
                   +"]="
                   +feitico[i];  
        }
        return output;
    }

    boolean equals(final PicaretaPedra rValue)
    {
           
        if (durabilidade==rValue.durabilidade)
            if (feitico==rValue.feitico)          
                return true;
        return false;
    }
    
    @Override
    public void consertar(final  Ferramenta  rValue)
    {    
        
        if (rValue instanceof PicaretaPedra)
        {
            this.durabilidade+=rValue.durabilidade;
            if (this.durabilidade>this.durabilidadeMaxima)
               this.durabilidade=this.durabilidadeMaxima ;
            rValue.durabilidade=0;
        }
        else System.out.println("precisa de uma picareta de pedra para isso");
    }
    @Override
    void minerar(final Bloco target)
    {
        Spell spellTemp;
        Random random=new Random();
        if (durabilidade==0) 
        {  System.out.println("sua picareta esta quebrada");
        }
        if (target.getResistencia()<=20)//se for abaixo ou igual a diamante
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
    @Override
    public boolean remover(final Spell spellTemp)//remove um feitico especifico do array trabalha em conjunto com o hasspell pra retornar o fetico correto
    { 
        boolean flag=false;
        for (int i=0;i<feitico.length;i++)
        {
            if (flag) feitico[i-1]=feitico[i];//se ja houver encontrado vai movendo os elementos para esquerda
            else if (feitico[i]==spellTemp)flag=true;//caso contrario procura o elemento 
        }
        if (flag)//se removeu cria um novo vetor
        {
            Spell temp[]= new Spell[feitico.length-1];
            System.arraycopy(feitico, 0, temp, 0,feitico.length-1);
            feitico=temp;
        }
        return flag;
    }
    @Override
    public boolean encantar(final Spell novo)
    {
        if (novo==null) return false;
        
        Spell temp[]= new Spell[feitico.length+1];
        System.arraycopy(feitico, 0, temp, 0, feitico.length);
        temp[temp.length-1]=novo;
        feitico=temp;
        return true;
    }
    @Override
    public Spell hasSpell(final String nome)//retorna o com menos duracao restante;
    {
       int i,escolhido=-1,duracao=-1;
       for(i=0;i<feitico.length;i++)
       if (nome.equals(feitico[i].getNome()))
       {
           if ((duracao==-1) || (feitico[i].getDuracao()<duracao))//se nao tiver achado nenhum guarda esse
            {
                escolhido=i;
                duracao=feitico[i].getDuracao();                
            }               
       }
        if (escolhido>=0) 
            return (feitico[escolhido]);
        return null;
    }
    @Override
    public void upgrade() {
        if (forca<forcaBase+3)
            forca+=1;
            
    }    
}
