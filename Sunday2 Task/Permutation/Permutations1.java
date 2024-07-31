/* Permutations(Medium)
1. Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Examples:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Input: nums = [1]
Output: [[1]]
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.   */


import java.util.*;
public class Permutations1 
{ 
   static void swap(int nums[], int l, int i) 
    { 
	int temp = nums[l]; 
	nums[l] = nums[i]; 
	nums[i] = temp; 
    } 

static void permutations(ArrayList<int[]> res,int[] arr, int l, int h) 
   { 
    System.out.println("l "+l);
    System.out.println("h "+h);
    for(int ind=0;ind<3;ind++)
    {
        System.out.print(arr[ind]+" ");
    }
    System.out.println();
    System.out.println("--------");
     if(l==h)
	{ 
	   res.add(Arrays.copyOf(arr,arr.length)); 
	   return; 
	} 
    for(int i=l;i<=h;i++)
       { 
	   swap(arr,l,i); 
           System.out.println("********");
	   permutations(res,arr,l+1,h);
          System.out.println("$$$$$$$$$$"); 
	   swap(arr,l,i); 
	} 
    } 
  static ArrayList<int[]> permute(int[] arr) 
   { 
	ArrayList<int[]> res = new ArrayList<int[]>(); 
	int last=arr.length - 1; 
        permutations(res,arr,0,last); 
	return res; 
    } 
public static void main(String[] args) 
  { 
        Scanner sc=new Scanner(System.in);
	System.out.print("Enter the Number of Elements in Array: ");
	int n=sc.nextInt();
	System.out.println("Enter the Elements: ");
	int[] arr=new int[n];
        for(int i=0;i<n;i++)
	  {
   	     arr[i]=sc.nextInt();
	  }
	ArrayList<int[]> res = permute(arr); 
 	for(int[] x : res) 
	  { 
	    for(int y : x)
 	      { 
		 System.out.print(y + " "); 
	      } 
	      System.out.println(); 
	   } 
  } 
} 
