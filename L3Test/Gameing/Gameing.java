import java.util.*;
public class Gameing
 {
static Scanner sc=new Scanner(System.in);
public static void display(String box[][],int row,int col)
{
  for(int i=0;i<row;i++)
   {
     for(int j=0;j<col;j++)
	{
	   System.out.print(box[i][j]+"  ");
	}
	System.out.println();
   }
}


public static void allocateMatrix(String box[][],int row,int col)
{
  for(int i=0;i<row;i++)
   {
       box[0][i]="W";
       box[i][0]="W";
       box[i][row-1]="W";
   }
   int mid=row/2;
   for(int i=1;i<row-1;i++)
    {
      
       if(i==mid)
	{
          box[row-1][i]="O";
	}
       else
          {
	    box[row-1][i]="G";
          }
    }
   for(int i=1;i<row-1;i++)
    {
       for(int j=1;j<col-1;j++)
	{
	   if(box[i][j]==null)
	  {
	   box[i][j]=" ";
	  }
	}
    } 
}


public static void getDecrement(String box[][],int i,int mid)
{

 if(box[i][mid].matches("\\d+"))
  {

  int num=Integer.parseInt(box[i][mid]);
  num-=1;
   if(num==0)
    {
	box[i][mid]=" ";
    }
  else
   {
     String newValue=Integer.toString(num);
     box[i][mid]=newValue;
   }
 }
}

public static void performDeOperation(String box[][],int ind,int row)
{
     for(int i=1;i<row-1;i++)
	{
	   box[i][ind]=" ";
	}
}

public static boolean isValid(int i,int j,String box[][],int row,int col)
{
  if(i>=1 && j>=1 && i<row-1 && j<col-1 && !box[i][j].equals("W"))
   {
     return true;
   }
  return false;
}
public static void performDsOperation(String box[][],int ind1,int ind2,int row)
{
    int arr1[]={-1,-1,-1,0,0,1,1,1};
    int arr2[]={-1,0,1,-1,1,-1,0,1};
    for(int i=0;i<8;i++)
     {
        int value1=arr1[i]+ind1;
	int value2=arr2[i]+ind2;
	if(isValid(value1,value2,box,row,row))
	  {
		box[value1][value2]=" ";
	  }
     }
     
}


public static void playGame(String box[][],int row,int col,int ball)
{
  while(ball>0)
   {
      System.out.println("Press 0 to contineue Game: ");
      System.out.println("Press 1 to Exit Game: ");
      int ans=sc.nextInt();
      if(ans==1)
      {
	break;
      }
      sc.nextLine();
      System.out.print("Enter the Direction(ST,LD,RD): ");
      String direct=sc.nextLine();
     
     if(direct.equalsIgnoreCase("st"))
	{
	   int mid=row/2;
	   for(int i=row-2;i>=1;i--)
	    {
		if(box[i][mid]=="W")
		{
		   break;
		}
		if(box[i][mid].equalsIgnoreCase("de"))
		{
		    performDeOperation(box,mid,row);
		}

		if(box[i][mid].equalsIgnoreCase("ds"))
		{
		   performDsOperation(box,i,mid,row);
		}

		if(!box[i][mid].equals(" "))
		 {
	            getDecrement(box,i,mid);
		    break;
		 }
	    }
	}


    else if(direct.equalsIgnoreCase("ld"))
	{
	     int mid=row/2;
	      mid--;
	      for(int i=row-2;i>=0;i--)
		{
		   if(box[i][mid].equals("W"))
			{
			   int ind=i;
			   int flag=0;
			   for(int j=1;j<row-1;j++)
			    {
				if(!box[ind][j].equals(" "))
				{
				   getDecrement(box,ind,j);
				   flag=1;
				   break;
				}
			    }
		 	   if(flag==0)
			   {
			     ball--;
			   }
			    break;
			   	
			 }

		     if(box[i][mid].equals(" "))
		      {
			mid--;
 		      }

		    else
		     {
		           getDecrement(box,i,mid); 
		           break;
		      }
		}
	}


    else if(direct.equalsIgnoreCase("rd"))
	{
	      int mid=row/2;
	      mid++;
	      for(int i=row-2;i>=0;i--)
		{
		   if(box[i][mid].equals("W"))
			{
			   int ind=i;
			   int flag=0;
			   for(int j=row-2;j>=1;j--)
			    {
				if(!box[ind][j].equals(" "))
				{
				   getDecrement(box,ind,j);
				   flag=1;
				   break;
				}
			    }
		 	   if(flag==0)
			   {
			     ball--;
			   }
			    break;
			   	
			 }

		     if(box[i][mid].equals(" "))
		      {
			mid++;
 		      }

		    else
		     {
		           getDecrement(box,i,mid); 
		           break;
		      }
		}
	}  

    
  else
	{
	   System.out.println("-----Invalid Direction-----");
	}
  
      System.out.println("The Number of Balls is: "+ball);
      display(box,row,col);

  }
      
}




public static void main(String args[])
 { 
   int row,col,ind1,ind2,ball;
   String direct;
   boolean check=true;
   while(check)
    {
        System.out.println("1.Create Game Paly");
	System.out.println("2.Paly Game: ");
	System.out.println("");
	System.out.print("Enter the Choice ");
	int choice=sc.nextInt();
	switch(choice)
	{
	   case 1:
		  System.out.print("Enter the Number of Row: ");
		  row=sc.nextInt();
		  System.out.print("Enter the Number of Col: ");
		  col=sc.nextInt();
		  String box[][]=new String[row][col];
		 
	          System.out.println("Alocating the Bricks");
		  while(true)
		  {
		     System.out.print("Do you Want to Continue(Y/N): ");
		     char valid=sc.next().charAt(0);
		     if(valid=='Y'||valid=='y')
		     {
			System.out.println("Enter the brick's position and the brick type: ");
			ind1=sc.nextInt();
			ind2=sc.nextInt();
			String value=sc.nextLine();
			box[ind1][ind2]=value;
		     }
		      else
		      {
                         break;
		      }
		  }
		  allocateMatrix(box,row,col);
		  display(box,row,col);
		  System.out.print("Enter the Ball count: ");
		  ball=sc.nextInt();
		  System.out.print("The Number of Balls is: "+ball);
		  break;
	   case 2:
		  System.out.print("Enter the Number of Row: ");
		  row=sc.nextInt();
		  System.out.print("Enter the Number of Col: ");
		  col=sc.nextInt();
		  String box2[][]=new String[row][col];
		  allocateMatrix(box2,row,col);
	          System.out.println("Alocating the Bricks");
		  while(true)
		  {
		     System.out.print("Do you Want to Continue(Y/N): ");
		     char valid=sc.next().charAt(0);
		     if(valid=='Y'||valid=='y')
		     {
			System.out.println("Enter the brick's position and the brick type: ");
			ind1=sc.nextInt();
			ind2=sc.nextInt();
			String value=sc.nextLine();
			box2[ind1][ind2]=value;
		     }
		      else
		      {
                         break;
		      }
		  }
		  display(box2,row,col);
		  System.out.print("Enter the Ball count: ");
		  ball=sc.nextInt();
		  playGame(box2,row,col,ball);
		  break;
	   default :
		  break;
	}  
    }
    
 }
}


