import java.util.*;
public class MatchesCombinationKey
{

public static void callRecurcive(int i,int arr[],int n,int combination[],int index,int key,int sum)
{
   if(i==n)
    {
	if(sum==key)
	{
	  System.out.print("[");
	   for(int j=0;j<index;j++)
	    {
	      System.out.print(combination[j]+" ");
	    }
	    System.out.print("]");
	    System.out.println();
	}
	return;
    }
    combination[index]=arr[i];
    sum+=arr[i];
    callRecurcive(i+1,arr,n,combination,index+1,key,sum);
    sum-=arr[i];
    callRecurcive(i+1,arr,n,combination,index,key,sum);
}

  public static void main(String args[])
   {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	{
	   arr[i]=sc.nextInt();
	}
	int key=sc.nextInt();
	int combination[] =new int[n];
	callRecurcive(0,arr,n,combination,0,key,0);
   }
}
