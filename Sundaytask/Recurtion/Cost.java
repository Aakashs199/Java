/*7. The cost of a stock on each day is given in an array. Find the maximum profit that you can make
by buying and selling on those days. If the given array of prices is sorted in decreasing order, then
profit cannot be earned at all.
Examples:
Input: arr[] = {100, 180, 260, 310, 40, 535, 695}
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
Maximum Profit = 210 + 655 = 865
Input: arr[] = {4, 2, 2, 2, 4}
Output: 2
Explanation: Buy the stock on day 1 and sell it on day 4 => 4 – 2 = 2
Maximum Profit = 2 */


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