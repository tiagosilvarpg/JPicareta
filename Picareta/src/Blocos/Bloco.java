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
    
    public Bloco(String material)
    {
     super();
     if (null != material)
         switch (material) {
            
            case "ar":
                this.material=material;
                resistencia=0;
                cor=15;
                break;
            case "ferro":
                this.material=material;
                resistencia= 20;
                cor=12;
                break;
            case "ouro":
                this.material=material;
                resistencia= 40;
                cor=6;
                break;
            case "diamante":
                this.material=material;
                resistencia= 80;
                cor=9;
                break;
            default:
                this.material="pedra";
                resistencia=10;
                cor=8;
                break;
        }
    }
    public Bloco()
    {
     this("pedra");
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
             this.material="ar";
             resistencia=0;
             cor=15;        
             return true;
          }
          else 
          return false;

    }
    public int getResistencia()
    {
        return resistencia;
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
             output=material.substring(0,1);
         }
         else
         {
             //textcolor(0);
             //cout<<(char)176;//imprime o simbolo 176 da tabela ascii
             output=("_");
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
