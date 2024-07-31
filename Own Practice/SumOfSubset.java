import java.util.*;
public class SumOfSubset
{

public static int callRecurtion(int start,int arr[],int n,int solution[],int ind,int sum)
{

  if(start==n)
   {
     solution[ind]=sum;
	return ind+1;
   }
ind=callRecurtion(start+1,arr,n,solution,ind,sum+arr[start]);
ind=callRecurtion(start+1,arr,n,solution,ind,sum);
return ind;

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
   int solution[]=new int[(int)Math.pow(2,n)];
   callRecurtion(0,arr,n,solution,0,0);
   Arrays.sort(solution);
   for(int i=0;i<solution.length;i++)
	{
	   System.out.print(solution[i]+" ");
	}
}

}