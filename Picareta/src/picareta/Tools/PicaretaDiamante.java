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
    private static int forcaBase=10;
    
    public PicaretaDiamante()
    {
        super();
        durabilidade=durabilidadeMaxima;
        forca=forcaBase;
    }
    public PicaretaDiamante( PicaretaDiamante rValue)
    {
        super(rValue);        
    }
    
    @Override
    public String toString()
    {
        int i;
        String output;
        output ="Picareta de Diamante,"
               +durabilidade
               +"/"
               +durabilidadeMaxima
               +"\n";

        
        for ( i=0; i<feitico.length; i++ )
        {
            output +="#spell["
                   +i
                   +"]="
                   +feitico[i]
                   +"\n";  
        }
        return output;
    }

    boolean equals(final  PicaretaDiamante rValue)
    {
           
        if (durabilidade==rValue.durabilidade)
            if (feitico==rValue.feitico)          
                return true;
        return false;
    }
    
    @Override
    public void consertar(final  Ferramenta  rValue)
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
    void minerar(final Bloco target)
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
    public Spell hasSpell(final String nome)//retorna o com menos duracao restante;
    {
       int i,escolhido=-1,duracao=-1;
       for(i=0;i<feitico.length;i++)
       if (nome.equals(feitico[i].getNome()))
       {
           if (duracao==-1)//se nao tiver achado nenhum guarda esse
            {
                duracao=feitico[i].getDuracao();
                escolhido=i;
            }
           else if (feitico[i].getDuracao()<duracao)//se ja tiver achado checa se esse é menor
           {
               escolhido=i;
               duracao=feitico[i].getDuracao();
           }
               
       }
        if (escolhido==-1) 
            return null;
        else return (feitico[escolhido]);
    }

    @Override
    public void upgrade() {
        if (forca<forcaBase+5)
            forca+=1;
            
    }
    
}
