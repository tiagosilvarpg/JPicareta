/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Blocos;

/**
 *
 * @author Tiago
 */
public class Bloco {
    int resistencia,cor;
    String material;
    
    public Bloco(String str)
    {
     material=str;
     init(material);
    }
    public Bloco()
    {
     material="pedra";
     init(material);
    }
    public Bloco(final  Bloco original)
    {
     this.material=original.material;
     this.resistencia=original.resistencia;
    }

    public boolean damage(int forca)
    {
          if (resistencia!=0)
          {
             //Sleep(resistencia*200/forca);
             this.init("ar");         
             return true;
          }
          else 
          return false;

    }
    public int getResistencia()
    {
        return resistencia;
    }   
    public void init( String  mtr)
    {
        

        if ("ouro".equals(mtr))
         { 
           material=mtr;
           resistencia= 40;
           cor=6;
         }
         if ("ar".equals(mtr))
         { 
           material=mtr;
           resistencia= 0;
           cor=15;
         }
         if ("ferro".equals(mtr))
         { material=mtr;
           resistencia= 20;
           cor=12;
         }
         if ("diamante".equals(mtr))
         { material=mtr;
           resistencia= 80;
           cor=9;
         }
         else         
         { material=mtr;
           resistencia=10;
           cor=8;
         }
    }
    public boolean isAir()
    {
         return "ar".equals(material);
    }
    // SOBRECARGA
    @Override
    public String toString()
    {

        String output;
         if (resistencia!=0)
         {
            //textcolor(cor);
            //cout<<(char)178;//imprime o simbolo 178 da tabela ascii
             output=(material.substring(0,0));
         }
         else
         {
             //textcolor(0);
             //cout<<(char)176;//imprime o simbolo 176 da tabela ascii
             output=(" ");
         }
         //textcolor(15);
         return output;
    }
    public boolean equals(final  Bloco toCompare)
    {
         if (!material.equals(toCompare.material)) return false;
         return resistencia == toCompare.resistencia;
    }


}
