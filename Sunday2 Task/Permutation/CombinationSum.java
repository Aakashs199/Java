/* Combination Sum(Medium)
6. Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
where the chosen numbers sum to target. You may return the combinations in any order. The same number may be chosen from
candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is
different. The test cases are generated such that the number of unique combinations that sum up to target is less than 150
combinations for the given input.
Examples:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7. These are the only two combinations.
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Input: candidates = [2], target = 1
Output: []
Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40   */


import java.util.*;
public class CombinationSum 
{
 public List<List<Integer>> combinationSum(int[] candidates,int target)
   {
        if(candidates==null) 
        {
            return null;
        }   
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    
public void findCombinations(int[] candidates,int index,int target,List<Integer>current,List<List<Integer>> result)
   {
     if(target == 0)
        {
          result.add(new ArrayList<>(current));
          return;
        } 
        for(int i=index;i<candidates.length;i++)
          {
            if(candidates[i]<=target)
	     {
               current.add(candidates[i]);
               findCombinations(candidates,i,target-candidates[i],current,result);
               current.remove(current.size()-1);
             }
        }
    }
    
 public static void main(String[] args) 
  {
    CombinationSum solution = new CombinationSum();
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the Number of Elements in Array: ");
    int n=sc.nextInt();
    System.out.println("Enter the Elements: ");
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
       {
   	  arr[i]=sc.nextInt();
       }
       System.out.print("Enter the Target: ");
       int target=sc.nextInt();
       List<List<Integer>> combinations=solution.combinationSum(arr,target);
       System.out.println("Combination sums for target "+target);
        for (List<Integer> combination : combinations) 
         {
            System.out.println(combination);
         }
    }
}
