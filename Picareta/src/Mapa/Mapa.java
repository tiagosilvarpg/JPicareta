
package Mapa;

import Blocos.Bloco;
import Data.Data;

public class Mapa {
    Bloco [][]grid;
    static int size=20;
    int playerX,playerY;
    Data creationTime;
    String name;

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
{
    for (i=0;i<size;i++)
        if (letra<str.length())
        {   
            switch (str.toCharArray()[letra]) 
            {
                case 'f':
                    grid[i][j]=new Bloco("ferro");
                    break;
                case 'o':
                    grid[i][j]=new Bloco("ouro");
                    break;
                case 'd':
                    grid[i][j]=new Bloco("diamante");
                    break;
                case 'i':
                    grid[i][j]=new Bloco("ar");//se houver mais de um i todos serao vazio mas o ultimo sera o inicio
                    playerX=i;
                    playerY=j;
                    break;
                default:
                    grid[i][j]=new Bloco("pedra");
                    break;
            }
        letra++;     
        }
        else grid[i][j]=new Bloco("pedra");
}
grid[playerX][playerY]=new Bloco("ar");//garante que nao haja bloco no inicio caso ele nao seja especificado;

}
public Mapa(final Data  data )
{
 int i,j;
 grid=new Bloco[size][size];

     
 for (j=1;j<size;j++)
     for (i=1;i<size;i++)
     grid[i][j]=new Bloco("pedra");
 grid[0][0]=new Bloco("ar");
 playerX=0;
 playerY=0;
}
@Override
public String toString(){
     int i,j;
     String output="";
     for (j=0;j<size;j++)
     {
         for (i=0;i<size;i++)
        {    if (i==playerX && j==playerY)
             {
                //textcolor(15);
                 output+="T";
                //textcolor(15);
             }
             else output+=(grid[i][j]);

        }
         output+="\n";
     }
    return output;
}
public static void changeMapSize(final int temp)
{
    if (temp>8 && temp<40)
    size=temp;
}
public Bloco getBloco(char op)
{
      int x=playerX,y=playerY;
      switch (op)
      {
      case 'a':
           {
           x=playerX-1;    
           break;
           }
      case 's':
           {
           y=playerY+1;              
           break;
           }
      case 'd':
           {
           x=playerX+1;    
           break;
           }
      case 'w':
           {
           y=playerY-1;     
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
public void movePlayer(char op)
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
