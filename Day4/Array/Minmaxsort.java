/* 5. (L1). Write a Java program to sort an array of positive integers 
of a given array. In the sorted array the value of the first element 
should be maximum, the second value should be the minimum value,
 the third should be the second maximum, the fourth second be the 
second minimum and so on. */


import java.util.Arrays;
import java.util.Scanner;
public class Minmaxsort
 {
  public static void main(String[] args)
   {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++) 
	{
            nums[i] = sc.nextInt();
        }
        sortInPattern(nums,n);
       System.out.println("Sorted Array in Pattern:"+Arrays.toString(nums));
    }
public static void insert(int arr[],int n)
   { 
      int i,j,k;
      for(i=1;i<n;i++)
     {
        j=i-1;
        int temp=arr[i];
        while(j>=0&&temp<arr[j])
             { 
                arr[j+1]=arr[j];
                j--;
             } 
         arr[j+1]=temp;  
     }
   }


 public static void sortInPattern(int[] nums,int n)
  {
        insert(nums,n);
        int[] result = new int[nums.length];
        int left = 0;  
        int right = nums.length-1;        
        for(int i=0;i<nums.length;i++)
	 {
            if(i%2 == 0) 
	       {               
                 result[i] = nums[right];
                 right--; 
               }
	 else
	   {
              result[i] = nums[left];
              left++; 
            }
        }
    for(int i=0;i<n;i++) 
	{
            nums[i] = result[i];
        }
    }
}
