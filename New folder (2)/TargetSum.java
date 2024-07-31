public class TargetSum
 {
  private static int findWays(int[] nums, int index, int sum, int target)
    {
    if(index==nums.length)
     {
       if(sum==target)
           return 1;
       else
           return 0;
     }
    int positiveWays=findWays(nums,index + 1,sum + nums[index],target);
    int negativeWays=findWays(nums,index + 1,sum - nums[index],target);

        return positiveWays + negativeWays;
    }

public static void main(String[] args)
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
     System.out.print("Enter the Target: ");
     int target=sc.nextInt();
     int ways = findWays(arr,0,0,target);
     System.out.println("Number of ways to assign symbols: " + ways);
    }
}
