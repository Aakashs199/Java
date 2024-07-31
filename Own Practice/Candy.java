import java.util.*;
public class Candy
{
public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    int left[]=new int[n];
    int right[]=new int[n];
    for(int i=0;i<n;i++)
	{
	   arr[i]=sc.nextInt();
	}

    left[0]=1;
    right[n-1]=1;
    for(int i=1;i<=n-1;i++)
     {
	if(arr[i]>arr[i-1])
	{
	  left[i]=left[i-1]+1;
	}
	else
	{	
	   left[i]=1;
	}
     }

    for(int i=n-2;i>=0;i--)
     {
	if(arr[i]>arr[i+1])
	{
	  right[i]=right[i+1]+1;
	}
	else
	{	
	   right[i]=1;
	}
     }

	for(int i=0;i<n;i++)
	{
	   System.out.print(left[i]+" ");
	}
	System.out.println();
	for(int i=0;i<n;i++)
	{
	   System.out.print(right[i]+" ");
	}
	int sum=0;
	for(int i=0;i<n;i++)
	{
	   sum+=Math.max(left[i],right[i]);
	}
	System.out.print(sum);


 }
}