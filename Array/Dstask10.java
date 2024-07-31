import java.util.*;
public class Dstask10
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the rows: ");
  int n=sc.nextInt();
  System.out.println("Enter the coloumn: ");
  int m=sc.nextInt();
  int arr[][]=new int[n][m];
  int i,j,sum,max=0;
  for(i=0;i<n;i++)
     for(j=0;j<m;j++)
         arr[i][j]=sc.nextInt();

   for(i=0;i<n;i++)
   {
      sum=0;
     for(j=0;j<m;j++)
      {
         sum+=arr[i][j];
      }
     if(sum>max)
      {
         max=sum;
      }
   }
System.out.println("Maximum value is: "+max);
 
}
}