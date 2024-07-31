/* 3.Given an array of distinct integers A and a target value val, find all unique combinations of integers
from A where their sum is equal to val.
Note: Each integer may be used multiple times in the combination.
Example
A: [1, 2]
val: 4
Combinations: [
[1, 1, 1, 1],
[1, 1, 2],
[2, 2]
]

Input Format
The first line contains an integer ‘T’, denoting the number of test cases.
For each test case the input has three lines.
• An integer ‘n’ denoting the length of the array A.
• n space-separated unique integers denoting the elements of the array A.
• An integer ‘val’ denoting the target value.
Output Format
For each test case, the output has the following lines:
• The first line contains an integer ‘m’ denoting the total no of distinct combinations.
• The next m line contains space-separated integers denoting elements in that particular
combination.
Sample Input
3
2
1 2
4
5
1 3 4 5 6
4
5
1 2 3 4 8
7
Expected Output
3
1 1 1 1
1 1 2
2 2
3
1 1 1 1
1 3
4
11
1 1 1 1 1 1 1
1 1 1 1 1 2
1 1 1 1 3
1 1 1 2 2
1 1 1 4
1 1 2 3
1 2 2 2
1 2 4
1 3 3
2 2 3
3 4
Constraint
1 <= T <= 10
1 <= n <= 30
1 <= target <= 500
1 <= Ai <= 500    */


import java.util.*;
class Combinations
{
static StringBuilder sb = new StringBuilder();
public static void main(String[] args)
  {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter n:");
	int n = in.nextInt();
	int[] arr = new int[n];
	System.out.println("Enter elements of array:");
	for(int i=0;i<n;i++)
          {
          arr[i]=in.nextInt();
          }
	System.out.println("Enter target:");
	int target = in.nextInt();
	combinationSum(arr,target,0,0);
  }
	
static void combinationSum(int[] arr, int target, int idx,int sum)
   {
	if(sum==target)
	 {
	   for(int i=0;i<sb.length();i++)
		{
		  System.out.print(sb.charAt(i)+",");
		}
	   System.out.println();
	   return;
	 }
   if(idx==arr.length || sum>target)
    {
     return;
    }
   sb.append(arr[idx]);
     System.out.println(idx+"-------"+sum);
   combinationSum(arr,target,idx,sum+arr[idx]);
   sb.deleteCharAt(sb.length()-1);
  System.out.println(idx+"**"+sum);
    combinationSum(arr,target,idx+1,sum);
	}
}