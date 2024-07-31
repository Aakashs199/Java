/* 7(L2). Write a Java program to check if a given array contains a sub array with 0 sum

Input :
nums1= { 1, 2, -2, 3, 4, 5, 6 }
nums2 = { 1, 2, 3, 4, 5, 6 }
nums3 = { 1, 2, -3, 4, 5, 6 }

Output:

Does the said array contain a subarray with 0 sum: true

Does the said array contain a subarray with 0 sum: false

Does the said array contain a subarray with 0 sum: true   */


public class Zeros
{ 
   public static boolean zero(int arr[])
     {
         int len=arr.length;
         int i,j;
        for(i=0;i<len;i++)
          {
              int sum=0;
             for(j=0;j<len;j++)
                {
                   sum+=arr[j];
                   if(sum==0)
                     {
                       return true;
                     }
               }
          }
         return false;
     }  
   public static void main(String args[])
      {
         int a[]={1,2,-2,3,4,5,6};
         int b[]={1,2,3,4,5,6};
         int c[]={1,2,-3,4,5,6};
         if(zero(a))
           {
               System.out.print("Yes");
           }
          else
            {
               System.out.print("No");
            }
      }
}