import java.util.*;
public class Dstask7
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  String arr[]=new String[n];
   int i,j,flag=0;
   sc.nextLine();
  for(i=0;i<n;i++)
   {
     arr[i]=sc.nextLine();
   }
   char temp[][]=new char[n][n];
   for(i=0;i<n;i++)
    {
      String current=arr[i];
      for(j=0;j<n;j++)
      {
        temp[i][j]=current.charAt(j);
      }
    }
   for(i=0;i<n;i++)
    {
      for(j=1;j<n;j++)
      {
         if(temp[j-1][i]>temp[j][i])
          {
           break;
          }
      }
      if(j!=n)
       {
        System.out.println("The coloumn "+i+" is not sorted");
         flag=1;
      }
    }
   if(flag==0)
   {
      System.out.println("All coloumn are sorted");
   }
}
}