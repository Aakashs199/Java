/* 3. Given an n sized unsorted array, find median and mode using counting sort technique. This can be useful when array elements are in limited range.

Example-1:  

Input : array a[] = {1, 1, 1, 2, 7, 1}
Output : Mode = 1
Auxiliary(count) array before summing its previous counts, c[]: 
Index: 0 1 2 3 4 5 6 7 8 9 10 
count: 0 4 1 0 0 0 0 1 0 0 0
Mode = 1

Example-2:    
Input : array a[] = {9, 9, 9, 9, 9}
Output : Mode = 9       
Auxiliary(count) array before summing its previous counts, c[]: 
Index: 0 1 2 3 4 5 6 7 8 9 10 
count: 0 0 0 0 0 0 0 0 0 5 0
Mode = 9   */


import java.util.*;
public class FindMode
{
  public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Elements: ");
     int n=sc.nextInt();
     int arr[]=new int[n];
     System.out.print("Enter the Number of Elements: ");
     for(int i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }
     int count[]=new int[100];
     for(int i=0;i<n;i++)
	{
          count[arr[i]]++;
	}
    int max=count[0];
    int mode=0;
     for(int i=0;i<100;i++)
      {
        for(int j=i+1;j<100;j++)
	{
	  if(count[j]>max)
	   {
	      max=count[j];
              mode=j;
	   }
	}
      }
  System.out.print("Mode: "+mode);
   }
}
