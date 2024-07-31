
/* Combinations(Medium)
5. Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
Examples:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
Constraints:
1 <= n <= 20
1 <= k <= n  */



import java.util.*;
class Combination 
{
   static void combinationUtil(int arr[], int data[], int start,int end, int index, int r)
     {
        if(index == r)
        {
            for (int j=0;j<r;j++)
            {
                System.out.print(data[j]+" ");
	    }
          System.out.println();
          return;
        }

    for(int i=start;i<=end && end-i+1 >= r-index;i++)
        {
            data[index] = arr[i];
            combinationUtil(arr,data,i+1,end,index+1,r);
        }
    }
public static void main (String[] args)
 { 
        Scanner sc=new Scanner(System.in);
	System.out.print("Enter the Value of N: ");
	int n=sc.nextInt();
	System.out.println("Enter the Elements: ");
	int[] arr=new int[n];
        int count =1;
        for(int i=0;i<n;i++)
	  {
   	     arr[i]=count;
             count++;
	  }
        System.out.print("Enter the Value of R: ");
	int r=sc.nextInt();
        int data[]=new int[r];
        combinationUtil(arr,data,0,n-1,0,r);
    }
}

