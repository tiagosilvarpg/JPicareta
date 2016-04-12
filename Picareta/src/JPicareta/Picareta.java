/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPicareta;

import Data.Data;
import Mapa.Mapa;
import Spells.Spell;
import java.util.Scanner;
import picareta.Tools.*;

/**
 *
 * @author Tiago
 */
public class Picareta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Data hoje;
    Mapa mundo;
    hoje = new  Data(23,03,2016);
    Scanner input=new Scanner(System.in);
    char op='1',charArray[] = {'s'};
    String str;
    int selecionada=0,inputSize=0;
    Ferramenta ferramentas[]=new Ferramenta[3];
    
    System.out.println("insira uma cadeia de blocos (ouro=0,pedra=p,ferro=f,diamante=d,inicio=i)");
    str=input.next();
    mundo=new  Mapa(str,hoje);
    
    ferramentas[0]=new PicaretaDiamante();
    ferramentas[1]=new PicaretaDiamante((PicaretaDiamante)ferramentas[0]);
    ferramentas[2]=new PicaretaDiamante();
    while (op!='x')
    {
    
    //mundo.refresh();
    System.out.println(ferramentas[selecionada]);
    System.out.println("mover(a,s,d,w),encantar(e),consertar(c),sair(x),selecionar picareta(1,2,3)\n:");
    /* essa parte é treta, para funcionar como em c++ onde ele tratava um palavra como varias entradas consecutivar de char
    guarda a palavra e usa as letras aos poucos ate nao ter mais nenhuma ai ele le denovo;
    */
    if (inputSize==0)
    {
      charArray=input.next().toCharArray();
      inputSize=charArray.length;
    }
    else
    {
        op=charArray[charArray.length-inputSize];
        inputSize--;
    }
    //op=getch();
 
    if ((op=='d')||(op=='a')||(op=='w')||(op=='s'))
    {
       
       ferramentas[selecionada].usar(mundo.getBloco(op));
       mundo.movePlayer(op);
    }
    if ((op=='1')||(op=='2')||(op=='3'))
    {
       selecionada=op-1 - '0';
    }
    if (op=='t')
        {   
            int temp;
            temp=input.nextInt();
            Mapa.changeMapSize(temp);
        }
    if (op=='e')
       {
       Spell spellTemp=new Spell();       
       ((PicaretaDiamante)ferramentas[selecionada]).encantar(spellTemp);
           System.out.println("picareta encantada");
       }
    if (op=='c')
       {
               System.out.println("consertando picareta numero "+(selecionada+1)+" qual picareta sera gasta para o conserto ?");
               op=input.next().toCharArray()[0];
               if ((op=='1')||(op=='2')||(op=='3'))
               {
                  if (selecionada!=op-1 - '0')
                  ferramentas[selecionada].consertar(ferramentas[(op-1 - '0')]);
               }
       }
    }

     

}

}
    