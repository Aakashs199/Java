 import java.util.*;
 public class Cost
{
public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of Days: ");
   int n=sc.nextInt();
   int arr[]=new int[n];
   int i,j,val;
   System.out.print("Enter the Cost: ");
   for(i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
   int max=Integer.MIN_VALUE;
   for(i=0;i<n-1;i++)
    {
      for(j=i+1;j<n;j++)
       {
         val=arr[j]-arr[i];
         if(val>max)
          {
            max=val;
          }
       }
    }
  if(max>0)
  {
  System.out.print("Profit Amount: "+max);
   }
  else
   {
   System.out.print(" Profit Amount: 0");
   }
 }
}