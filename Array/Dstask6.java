import java.util.*;
public class Dstask6
{
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the n value");
      int n=sc.nextInt();
      int arr[]=new int[n];
      int i,j,freq,val,ind=0;
      int temp[]=new int[1000];
      for(i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }
      for(i=0;i<n;i+=2)
       {
          freq=arr[i];
          val=arr[i+1];
         for(j=0;j<freq;j++)
           {
              temp[ind]=val;
              ind++;
            }
       }
      for(i=0;i<ind;i++)
      {
         System.out.print(temp[i]+" ");
      }
  }
}