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
    
    Bloco(String str)
    {
     material=str;
     init(material);
    }
    Bloco()
    {
     material="pedra";
     init(material);
    }
    Bloco( Bloco original)
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
         if (mtr=="ouro")
         { 
           material=mtr;
           resistencia= 40;
           cor=6;
         }
         if (mtr=="ar")
         { 
           material=mtr;
           resistencia= 0;
           cor=15;
         }
         if (mtr=="pedra")
         { material=mtr;
           resistencia=10;
           cor=8;
         }
         if (mtr=="ferro")
         { material=mtr;
           resistencia= 20;
           cor=12;
         }
         if (mtr=="diamante")
         { material=mtr;
           resistencia= 80;
           cor=9;
         }                                  
    }
    public boolean isAir()
    {
         if (material=="ar")
         return true;
         return false;
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
    public boolean equals( Bloco toCompare)
    {
         if (!material.equals(toCompare.material)) return false;
         if (resistencia != toCompare.resistencia) return false;
         return true;

    }


}
