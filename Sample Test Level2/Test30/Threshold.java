import java.util.*;
public class Threshold
{
public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the number of Elements: ");
   int n=sc.nextInt();
   int arr[]=new int[n];
   int i,count=0;
   System.out.print("Enter the value: ");
   for(i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
  System.out.print("Enter the Threshold value: ");
  int threshold=sc.nextInt();
  for(i=0;i<n;i++)
   {
     int quatient=arr[i]/threshold;
      if(arr[i]%threshold!=0)
        {
          count+=quatient+1;
        }
      else
       {
          count+=quatient;
       }
   }
   System.out.print("OUTPUT: "+count);
 }
}