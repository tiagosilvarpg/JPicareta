
package Mapa;

import Blocos.Bloco;
import Data.Data;

public class Mapa {
    Bloco [][]grid;
    int size=20;
    int playerX,playerY;
    Data creationTime;
    String name;


void changeMapSize( int temp)
{
    if (temp>8 && temp<40)
    size=temp;
}

public Mapa( String  str, Data  data )
{
int i,j,letra;
 //inicializar
 playerX=0;
 playerY=0;
 //alocacao dinamica
 grid=new Bloco[size][size];
 letra=0; 
 for (j=0;j<size;j++)
      for (i=0;i<size;i++)
      if ((int)letra<str.length())
         {   
    switch (str.substring(letra)) {
        case "f":
            grid[i][j].init("ferro");
            break;
        case "o":
            grid[i][j].init("ouro");
            break;
        case "d":
            grid[i][j].init("diamante");
            break;
        case "i":
            grid[i][j].init("ar");//se houver mais de um i todos seram vazio mas o ultimo sera o inicio
            playerX=i;
            playerY=j;
            break;
        default:
            grid[i][j].init("pedra");
            break;
    }
             letra++;     
         }
 grid[playerX][playerY].init("ar");//garante que nao haja bloco no inicio caso ele nao seja especificado; 
}
Mapa( Data  data )
{
 int i,j;
 grid=new Bloco[size][size];

     
 for (j=1;j<size;j++)
     for (i=1;i<size;i++)
     grid[i][j].init("pedra");
 grid[0][0].init("ar");
 playerX=0;
 playerY=0;
}
public void refresh()
{int i,j;
 for (j=0;j<size;j++)
 {
     for (i=0;i<size;i++)
     {    if (i==playerX && j==playerY)
          {
             //textcolor(15);
              System.out.println("\2");
             //textcolor(15);
          }
          else System.out.print(grid[i][j]);
          
     }
     System.out.println("");
 }
    System.out.println("");
}
public Bloco getBloco(char op)
{
      int x=0,y=0;
      switch (op)
      {
      case 'a':
           {
           y=playerY;
           x=playerX-1;    
           break;
           }
      case 's':
           {
           y=playerY+1;
           x=playerX;              
           break;
           }
      case 'd':
           {
           y=playerY;
           x=playerX+1;    
           break;
           }
      case 'w':
           {
           y=playerY-1;
           x=playerX;     
           break;
           }
      }
      if (x>=size || x<0 || y<0 ||y>=size)
      {
       return grid[playerX][playerY];//retorna a atual se a nova nao for valida
      }
      else
      {
      return (grid[x][y]);//retorna a nova
      }   
}
void movePlayer(char op)
{
      int x=0,y=0;
      switch (op)
      {
      case 'a':
           {
           y=playerY;
           x=playerX-1;    
           break;
           }
      case 's':
           {
           y=playerY+1;
           x=playerX;              
           break;
           }
      case 'd':
           {
           y=playerY;
           x=playerX+1;    
           break;
           }
      case 'w':
           {
           y=playerY-1;
           x=playerX;     
           break;
           }
      }
      if (x<size && x>=0 && y>=0 && y<size)
      {
         if (grid[x][y].isAir())
          { 
              playerY=y;
              playerX=x;
          }
          
      }
      
}

int getPlayerX()
{
return playerX;
}
int getPlayerY()
{
return playerY;
}

    
}
