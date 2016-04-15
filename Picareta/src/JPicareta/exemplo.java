/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPicareta;

import Blocos.Bloco;
import Data.Data;
import Mapa.Mapa;
import Spells.Spell;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import picareta.Tools.*;

/**
 *
 * @author Tiago
 */
public class exemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Ferramenta []picareta= new Ferramenta[3];
    
    System.out.println("\n->picareta[0]=new PicaretaPedra();\n");
    picareta[0]=new PicaretaPedra();
    System.out.println("\n->encanta a primeira com 3 feiticos diferentes  \n");
    ((PicaretaPedra)picareta[0]).encantar(new Spell("invisivel","isso deve causar muitos acidentes",10));
    ((PicaretaPedra)picareta[0]).encantar();
    ((PicaretaPedra)picareta[0]).encantar(new Spell("resistente","tem uma chance de nao gastar quando usada",1));
    
    System.out.println("\n->picareta[1]=new PicaretaPedra((PicaretaPedra)picareta[0]);  \n");
    picareta[1]=new PicaretaPedra((PicaretaPedra)picareta[0]);
    System.out.println(picareta[0]);
    
    System.out.println("\n3x->picareta[0].usar(new Bloco(\"pedra\"));\n");
    picareta[0].usar(new Bloco("pedra"));
    picareta[0].usar(new Bloco("pedra"));
    picareta[0].usar(new Bloco("pedra"));    
    System.out.println(picareta[0]);
    
    System.out.println("\n->((PicaretaPedra)picareta[0]).remover(((PicaretaPedra)picareta[0]).hasSpell(\"resistente\"));\n");
    ((PicaretaPedra)picareta[0]).remover(((PicaretaPedra)picareta[0]).hasSpell("resistente"));
    System.out.println(picareta[0]);
    
    System.out.println("\n->comparando as duas");
        System.out.println(picareta[0]);
        System.out.println(picareta[1]);
        
    picareta[2]=new PicaretaPedra();
    
    try {
    Runtime.getRuntime().exec("pause");
} catch (IOException ex) {
}

}
}
    