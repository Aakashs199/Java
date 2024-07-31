import java.util.*;
public class Traps
{
static boolean issafe(int x,int y)
{

   if(x==y)
    {
      return true;
    }
   if(x%y==0||y%x==0)
   {
     return true;
   }
   if(x<10)
   {
     return false;
   }
 int sum=0;
  while(x>0)
   {
     sum+=x%10;
     x/=10;
   }
  
   if(issafe(sum,y))
    {
       return true;
    }
   return false;
   
}
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the N1 Value: ");
  int n1=sc.nextInt();
  System.out.print("Enter the N2 Value: ");
  int n2=sc.nextInt();
  System.out.print("Enter the Y Value: ");
  int y=sc.nextInt();
  for(int i=n1;i<=n2;i++)
  {
    if(issafe(i,y))
     {
       System.out.print(i+" ");
       y=y+2;
     }
    else
     {
      y--;
     }
    if(y<3)
     {
        y=3;
     }
  }
}
}