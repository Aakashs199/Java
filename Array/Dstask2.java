import java.util.*;
public class Dstask2
{
public static void main(String args[])
{
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int arr[]=new int[n];
   int i,j,sum=0,k;
   for(i=0;i<n;i++)
    {
       arr[i]=sc.nextInt();
    }
     for(i=0;i<n;i++)
       {
      
              System.out.println("i= "+i);
          for(j=i;j<n;j+=2)
           {
              System.out.println("j= "+j);
             for(k=i;k<=j;k++)
              {
                
              System.out.println("k= "+k);
                sum+=arr[k];
              }   
           }
       }
   System.out.println(sum);
}
}