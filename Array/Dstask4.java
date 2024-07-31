import java.util.*;
public class Dstask4
{
public static void main(String args[])
{
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int arr[]=new int[n];
   int i,j;
   for(i=0;i<n;i++)
   {
      arr[i]=sc.nextInt();
   }
 Boolean bo[]=new Boolean[n];
  System.out.println("Enter the extra candies:");
  int extra=sc.nextInt();
    int max=arr[0];
   for(i=1;i<n;i++)
    {
         max=Math.max(max,arr[i]);
    }
  for(i=0;i<n;i++)
   {
      if(extra+arr[i]>=max)
        {
         bo[i]=true; 
        }
       else
         {
           bo[i]=false;
         }
   }
for(i=0;i<n;i++)
{
   System.out.print(bo[i]+" ");
}
    
}
}