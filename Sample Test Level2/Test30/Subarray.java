import java.util.*;
public class Subarray
{
static int subarray(int arr[],int i,int j,int key)
  {
    int max=Integer.MIN_VALUE;
     for(int ind=i;ind<=j;ind++)
      {
          if(arr[ind]>max)
           {
              max=arr[ind];
           }
      }
    return max;
  }
public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the number of Elements: ");
   int n=sc.nextInt();
   int arr[]=new int[n];
   int i;
   System.out.print("Enter the value: ");
   for(i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
  System.out.print("Enter the key: ");
  int key=sc.nextInt();
  int size=n-key;
  for(i=0;i<=size;i++)
   {
     int ans=subarray(arr,i,i+key-1,key);
     System.out.print(ans+" ");
   }
 }
}