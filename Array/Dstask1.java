import java.util.*;
public class Dstask1
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int arr[][]=new int[n][n];
  int i,j,sum=0;
  for(i=0;i<n;i++)
     for(j=0;j<n;j++)
         arr[i][j]=sc.nextInt();

   for(i=0;i<n;i++)
   {
     for(j=0;j<n;j++)
      {
         if(i==j||j==n-i-1)
          {
            sum+=arr[i][j];
          }
      }
   }
System.out.println(sum);
 
}
}