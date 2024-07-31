import java.util.*;
public class SnakeLadder
{
static String preveiousA;
static String preveiousB;

static void display(String arr[][])
{
  for(int i=0;i<10;i++)
    {
     for(int j=0;j<10;j++)
      {
        System.out.printf("%-5s",arr[i][j]);
      }
     System.out.println();
    }
}
  
public static String[][] alllocateBoard()
{
   String arr[][]=new String[10][10];
   int count=100;
   for(int i=0;i<10;i++)
      {
       if(i==0||i%2==0)
        {
           for(int j=0;j<10;j++)
            { 
              arr[i][j]=Integer.toString(count); 
              count--;
            }
        }
        if(i%2!=0)
        {
          for(int j=9;j>=0;j--)
           { 
             arr[i][j]=Integer.toString(count);
             count--;
           }
        }
      }  
     return arr;
}

public static int[][] allocateNumBoard()  
{
   int arr[][]=new int[10][10];
   int count=100;
   for(int i=0;i<10;i++)
      {
       if(i==0||i%2==0)
        {
           for(int j=0;j<10;j++)
            { 
              arr[i][j]=count; 
              count--;
            }
        }
        if(i%2!=0)
        {
          for(int j=9;j>=0;j--)
           { 
             arr[i][j]=count;
             count--;
           }
        }
      }  
     return arr;
}

 static void changesnake(String arr[][],String head,String tail,String ans,boolean[][] snake)
  {
     for(int i=0;i<10;i++)
      {
        for(int j=0;j<10;j++)
         {
            if(arr[i][j].equals(head))
             {
               arr[i][j]=ans;
	       snake[i][j]=true;
             }
            if(arr[i][j].equals(tail))
            {
              arr[i][j]=ans;
            }
         }
      }

   }


static void changelader(String arr[][],String head,String tail,String ans,boolean[][] ladder)
  {
     for(int i=0;i<10;i++)
      {
        for(int j=0;j<10;j++)
         {
           if(arr[i][j].equals(head))
            {
              arr[i][j]=ans;
            }
            if(arr[i][j].equals(tail))
            {
	      ladder[i][j]=true;
              arr[i][j]=ans;
            }
         }
      }
   }

public static int[] positionFind(String board[][],int position[],String value)
{
  
        for(int i=0;i<10;i++)
          {
             for(int j=0;j<10;j++)
               {
                 if(board[i][j].equals(value)||board[i][j].equals("AB")||board[i][j].equals("BA"))
		  {
		     position[0]=i;
		     position[1]=j;
		     if(value.equals("A")||value.equals("AB"))
			{
		           board[i][j]=preveiousA;
			}
		      else if(value.equals("B")||value.equals("BA"))
			{
			   board[i][j]=preveiousB;
			}		     
		     break;
		  }
               }
           }
     return position;
}
public static int[] positionFindNum(int numBoard[][],int position[],int value)
{    
        for(int i=0;i<10;i++)
          {
             for(int j=0;j<10;j++)
               {
                 if(numBoard[i][j]==value)
		  {
		     position[0]=i;
		     position[1]=j;
		     break;
		  }
               }
           }
    return position;
}

public static void findSnakeTail(String board[][],String player,String snakes,boolean snake[][])
{
     for(int i=0;i<10;i++)
          {
             for(int j=0;j<10;j++)
               {
                 if(board[i][j].equals(snakes) && !snake[i][j])
		   {
		       if(player.equals("A"))
		       {
		         preveiousA=board[i][j];
		       }
	     	   else
			{
	  	  	   preveiousB=board[i][j];
			}
	    	      board[i][j]=player;
		      break;
		  }
               }
           }
}

public static void findLaderhead(String board[][],String player,String laders,boolean lader[][])
{
     for(int i=0;i<10;i++)
          {
             for(int j=0;j<10;j++)
               {
                 if(board[i][j].equals(laders) && !lader[i][j])
		  {
		      if(player.equals("A"))
		       {
		         preveiousA=board[i][j];
		       }
	        	   else
			{
	  	  	   preveiousB=board[i][j];
			}
	    	      board[i][j]=player;
		      break;
		  }
               }
           }
}

public static void placePosition(String board[][],int position[],String player,boolean snake[][],boolean lader[][])
{
	int i=position[0];
	int j=position[1];


      if(snake[i][j])
	{
	     findSnakeTail(board,player,board[i][j],snake);
	}
     else if(lader[i][j])
	{
		findLaderhead(board,player,board[i][j],lader);
	}

     else if(board[i][j].equals("A"))
	{
	    
	    preveiousB=preveiousA;
	    preveiousA="B";
	    board[i][j]="A"+player;
	}

     else if(board[i][j].equals("B"))
	{
	    preveiousA=preveiousB;
	    preveiousB="A";
	    board[i][j]="B"+player;
	}

     else
	{
	     if(player.equals("A"))
		{
		    preveiousA=board[i][j];
		}
	     else
		{
	  	  preveiousB=board[i][j];
		}
	     board[i][j]=player;
	}
}



public static void move(String board[][],int numBoard[][],int value,String player,boolean snake[][],boolean lader[][])
{
    int position[]={Integer.MIN_VALUE,Integer.MIN_VALUE};
    positionFind(board,position,player);
   // System.out.println(position[0]+" "+position[1]);
    int temp;
    if(position[0]<0)
     {
	temp=0;
     }
    else
     {
	int i=position[0];
	int j=position[1];
	temp=numBoard[i][j];
	if(value+temp>100)
	{
	   board[i][j]=player;
	   System.out.println("Unable to Move");
	}
     }
     int moveSteps=value+temp;
     if(moveSteps==100)
	{
	    System.out.println(player+" HAS WON THE GAME!");
	    positionFindNum(numBoard,position,moveSteps);
            placePosition(board,position,player,snake,lader);
	    display(board);
	    System.exit(0);
	}
     else if(moveSteps<=99 && moveSteps>=0)
	{
           positionFindNum(numBoard,position,moveSteps);
           placePosition(board,position,player,snake,lader);
	}
    

}



  public static void main(String args[])
    {
     Scanner sc=new Scanner(System.in);  
     String board[][]=alllocateBoard();
     int numBoard[][]=allocateNumBoard();
     display(board);
     //display(numBoard);
     System.out.println();

   System.out.println("------After Inserting the Snakes------");
   boolean snake[][]=new boolean[10][10];
   changesnake(board,"40","3","S1",snake);
   changesnake(board,"43","18","S2",snake);
   changesnake(board,"27","5","S3",snake);
   changesnake(board,"54","31","S4",snake);
   changesnake(board,"89","53","S5",snake);
   changesnake(board,"66","45","S6",snake);
   changesnake(board,"76","58","S7",snake);
   changesnake(board,"99","41","S8",snake);
   display(board);
   
   System.out.println("------After Inserting the Ladder------");
   boolean lader[][]=new boolean[10][10];
   changelader(board,"25","4","L1",lader);
   changelader(board,"46","13","L2",lader);
   changelader(board,"49","33","L3",lader);
   changelader(board,"69","50","L4",lader);
   changelader(board,"63","42","L5",lader);
   changelader(board,"81","62","L6",lader);
   changelader(board,"92","74","L7",lader);
   display(board);

   int n=0,choice;
      while(true)
       {
	    System.out.println();
	    System.out.println();
           System.out.println("----Press 1 to Roll Dice------");
	    System.out.println();
           int exit=sc.nextInt(); 
	   n++; 
           if(n%2!=0)
           {      
             choice=1;
           }
           else
           {
             choice=2;
           }
           
         switch(choice)
          {
		
            case 1:
		   System.out.println("-------Player 1----------");
		   System.out.println();
                   Random random1 = new Random();
		  int value1= random1.nextInt(6)+1;
		  //System.out.print("The Dice Value: ");
		  // int data1=sc.nextInt();
		   System.out.println("Dice Value of Player 1: "+value1);
                   move(board,numBoard,value1,"A",snake,lader);
                   display(board);
		   System.out.println();
                   break;
            case 2:
		   System.out.println("-------Player 2----------- ");
		    System.out.println();
		   Random random2=new Random();
		   int value2= random2.nextInt(6)+1;
		   System.out.println("Dice Value of Player 2: "+value2);
		   
		   //int data2=sc.nextInt();
                  move(board,numBoard,value2,"B",snake,lader);
		   display(board);
		    System.out.println();
                   break;
            default:
		    break;
                   
          }
    
       }



   


   }
}