/* 5. Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, in O(log n + log m) time complexity, when n is the number of elements in the first array, and m is the number of elements in the second array.

Input: ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
Output : The median is 3.
Explanation : The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15},
       So the median of the merged array is 3

Input: ar1[] = {2, 3, 5, 8}
        ar2[] = {10, 12, 14, 16, 18, 20}
Output : The median is 11.
Explanation : The merged array is :
        ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
        if the number of the elements are even, 
        so there are two middle elements,
        take the average between the two :
        (10 + 12) / 2 = 11.  */

import java.util.*;
public class MergeMode
{
  public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Number of Elements int Array1: ");
     int n=sc.nextInt();
     int arr1[]=new int[n];
     System.out.print("Enter the Elements: "); 
     for(int i=0;i<n;i++)
      {
         arr1[i]=sc.nextInt();
      }
    System.out.print("Enter the Number of Elements int Array2: ");
    int m=sc.nextInt();
    int arr2[]=new int[m];
    System.out.print("Enter the Elements: "); 
     for(int i=0;i<m;i++)
      {
         arr2[i]=sc.nextInt();
      }
    int arr3[]=new int[n+m];
    int i=0;
    int j=0;
    int k=0;
    while(i<n && j<m)
     {
        if(arr1[i]<arr2[j])
	{
	  arr3[k]=arr1[i];
	  i++;
	}
	else
	{
	   arr3[k]=arr2[j];
	   j++;
	}
	k++;
     }
   while(i<n)
    {
      arr3[k]=arr1[i];
      i++;
      k++;
    }
  while(j<m)
    {
      arr3[k]=arr2[j];
      j++;
      k++;
    }
  for(int ind=0;ind<n+m;ind++)
   {
     System.out.print(arr3[ind]+" ");
   }
System.out.println();
 int size=m+n;
   if(size%2!=0)
    {
      int ind=size/2;
      System.out.println("Mode: "+arr3[ind]);
    }
   else
    {
      int value=arr3[size/2]+arr3[size/2-1];
     System.out.print("Mode: "+value/2);
    }

  }
}