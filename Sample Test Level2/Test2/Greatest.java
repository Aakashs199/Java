/*3. Find the next greater element for each element in given array.
Input: array[]={6, 3, 9, 10, 8, 2, 1, 15, 7};
Output: {7, 5, 10, 15, 9, 3, 2, _, 8}*/

import java.util.*;
public class Greatest
{
public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Number of Elements: ");
     int n=sc.nextInt();
     int arr[]=new int[n];
     System.out.print("Enter the Elements: ");
     int i,j;
     for(i=0;i<n;i++)
      {
        arr[i]=sc.nextInt();
      }
     for(i=0;i<n;i++)
       {
         int min=Integer.MAX_VALUE;
         int flag=0;
         for(j=0;j<n;j++)
          {
             if(j!=i && arr[j]>arr[i])
               {
                  if(arr[j]<min)
                   {
                     min=arr[j];
                     flag=1;
                   }
               }
          }
         if(flag==1)
         {
           System.out.print(min+" ");
         }
          else
        {
         System.out.print("- ");
        }
       }
  }
}