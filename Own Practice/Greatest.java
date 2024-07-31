import java.util.*;
public class Greatest
{
public static void main(String args[])
{
 Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int arr[]=new int[n];
  for(int i=0;i<n;i++)
  {
    arr[i]=sc.nextInt();
  }
  for(int i=0;i<n;i++)
   {
	int min=Integer.MAX_VALUE;
	int flag=0;
      for(int j=0;j<n;j++)
	{
	    if(i!=j && arr[j]>arr[i] && arr[j]<min)
		{
		     min=arr[j];
		     flag=1;
		}
	}
	if(flag==1)
	{
	   System.out.print(min+" ");
	}
	else
	{
	   System.out.print("- ");
	}
   }
}
}