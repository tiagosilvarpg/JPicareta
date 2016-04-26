/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPicareta;

import Blocos.Bloco;
import Spells.Spell;
import java.io.IOException;
import javax.swing.JOptionPane;
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
    Picareta []picareta= new Picareta[3];
    
    String tipo=JOptionPane.showInputDialog("qual picareta ? (pedra ou diamante)","pedra");
    if (null != tipo)
        switch (tipo) {
            case "pedra":
                picareta[0]=new PicaretaPedra();
                break;
            case "diamante":
                picareta[0]=new PicaretaDiamante();
                break;
        }
    System.out.println("\n->encanta a primeira com 3 feiticos diferentes  \n");
    picareta[0].encantar(new Spell("invisivel","isso deve causar muitos acidentes",10));
    picareta[0].encantar();
    picareta[0].encantar(new Spell("resistente","tem uma chance de nao gastar quando usada",1));
    
    System.out.println("\n->picareta[1]=new PicaretaPedra((PicaretaPedra)picareta[0]);  \n");
    
    if (picareta[0] instanceof PicaretaPedra)
        picareta[1]=new PicaretaPedra((PicaretaPedra)picareta[0]);
    else if (picareta[0] instanceof PicaretaDiamante)
        picareta[1]=new PicaretaDiamante((PicaretaDiamante)picareta[0]);
    
    System.out.println(picareta[0]);
    
    System.out.println("\n3x->picareta[0].usar(new Bloco(\"pedra\"));\n");
    picareta[0].usar(new Bloco("pedra"));
    picareta[0].usar(new Bloco("pedra"));
    picareta[0].usar(new Bloco("pedra"));    
    System.out.println(picareta[0]);
    
    System.out.println("\n->((PicaretaPedra)picareta[0]).remover(((PicaretaPedra)picareta[0]).hasSpell(\"resistente\"));\n");
    picareta[0].remover(((PicaretaPedra)picareta[0]).hasSpell("resistente"));
    System.out.println(picareta[0]);
    
    System.out.println("\n->comparando as duas");
        System.out.println(picareta[0]);
        System.out.println(picareta[1]);
        
    picareta[2]=new PicaretaPedra();
   
}
}
    