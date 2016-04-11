/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPicareta;

import Data.Data;
import Mapa.Mapa;

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
        Data hoje=new Data(11,01,1992);
        Mapa mundo=new Mapa("impolgante",hoje);
        mundo.refresh();
    }
    
}
