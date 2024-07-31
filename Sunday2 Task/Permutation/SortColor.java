/* Sort Colors(Medium)
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with
the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?   */



import java.util.*;
public class SortColor 
{
   public static void sortColors(int[] nums)
    {
        int n=nums.length;
        int count=0,count1=0,count2=0;

        for(int i=0;i<n;i++)
          {
            if (nums[i] == 0) count++;	
            else if (nums[i] == 1) count1++;
            else if (nums[i]== 2) count2++;
        }
        for(int i=0;i<n;i++)
	 {
            if(count>0)
 	     {
                nums[i]=0;
                count--;
            } 
	    else if(count1 > 0)
	     {
                nums[i]=1;
                count1--;
             } 
	    else
	     {
                nums[i]=2;
             }
        }
    }

 public static void main(String[] args)
 {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n=sc.nextInt();
    int [] nums = new int[n];
    System.out.println("Enter the elements(0,1,or2): ");
    for (int i = 0; i < n; i++) 
      {
          nums[i]=sc.nextInt();
      }
     sortColors(nums);
     System.out.print("Sorted colors: ");
     for(int i=0;i<n;i++)
       {
            System.out.print(nums[i]+ " ");
        }
    }
}
