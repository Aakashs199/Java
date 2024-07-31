import java.util.*;
public class Dstask8
{
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the N");
      int n=sc.nextInt();
      int arr[]=new int[n];
      int i,j,count=0;
      double sum=0;
      for(i=0;i<n;i++)
       {
         arr[i]=sc.nextInt();
       }
     Arrays.sort(arr);
     int len=n/20;
      for(i=len;i<n-len;i++)
      {
        sum+=arr[i];
      }
      System.out.print(sum/(n-len*2));
  }
}