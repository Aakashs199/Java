import java.util.*;
public class Sumoftarget
{
public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of Value: ");
   int n=sc.nextInt();
   int arr[]=new int[n];
   for(int i=0;i<n;i++)
    {
      arr[i]=sc.nextInt();
    }
   for(int i=0;i<n-2;i++)
    {
       for(int j=i+1;j<n-1;j++)
	{
	   for(int k=j+1;k<n;k++)
	   {
	      int sum=arr[i]+arr[j]+arr[k];
	      if(sum==0)
		{
		   System.out.print("["+arr[i]+" "+arr[j]+" "+arr[k]+"]");
		   System.out.println();
		}
	   }
	}
    }
 }
}

