/* 4. Permutations II(Medium)
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Examples:
Input: nums = [1,1,2]
Output: [[1,1,2], [1,2,1], [2,1,1]]
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10   */


import java.util.*;
public class Permutationsduplicate
 {
    static void swap(int nums[],int l,int i)
     {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

 static void permutations(Set<String> set,ArrayList<int[]> res,int[] arr,int l,int h)
   {
      if(l==h)
        {
           StringBuilder permustr = new StringBuilder();
           for(int num : arr)
             {
                permustr.append(num).append(",");
             }
            String permutationStr = permustr.toString();
            if (!set.contains(permutationStr))
              {
                res.add(Arrays.copyOf(arr, arr.length));
                set.add(permutationStr);
              }
            return;
        }
    for(int i=l;i<=h;i++)
      {
         swap(arr, l, i);
         permutations(set, res, arr, l + 1, h);
         swap(arr, l, i);
      }
   }

 static ArrayList<int[]> permute(int[] arr) 
  {
     ArrayList<int[]> res = new ArrayList<>();
     Set<String> set = new HashSet<>();
     permutations(set, res, arr, 0, arr.length - 1);
     return res;
  }

 public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the size number: ");
      int n = sc.nextInt();
      System.out.println("Enter the Elements: ");
      int[] arr=new int[n];
       for(int i=0;i<n;i++)
         {
            arr[i] = sc.nextInt();
         }
        ArrayList<int[]> res=permute(arr);
 System.out.println("----Permutation without Duplicate------");
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
