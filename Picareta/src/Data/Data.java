/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

/**
 *
 * @author Tiago
 */
public class Data {
    int day,month,year;
    
    public Data(int day,int month,int year)
    {
    if (month>0 &&month<13) 
        this.month=month;
    else
        this.month=1;
    this.year=year;
    
    this.day=checkDay(day);
    }
   public int checkDay(int dia)
    {
    int diasPorMes[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    if (dia>0 && dia<diasPorMes[month])
        return dia;
    else 
        return 1;    
    }



    
    
}
