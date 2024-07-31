/* 4(L2).Write a Java program to print all the LEADERS in the array.   
Note: An element is leader if it is greater than all the elements to its right side. */

import java.util.*;
public class Leader
{
   public static void main(String args[])
     {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[1000];
        int i,j;
        for(i=0;i<n;i++)
          {
             arr[i]=sc.nextInt();
          }
        for(i=0;i<n;i++)
          { 
            int flag=0;
            for(j=i+1;j<n;j++)
               {
                    if(arr[i]<arr[j])
                      {
                         flag=1;
                         break;
                      }
               }   
              if(flag==0||i==n-1)
              {
                 System.out.println("The Leader Element is: "+arr[i]);
                 break;
              }
          }
      }
}