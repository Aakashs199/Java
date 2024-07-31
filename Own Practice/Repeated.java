import java.util.*;
public class Repeated
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
   ArrayList<Integer> duplicate=new ArrayList<>();
  //int duplicate[]=new int[n];
   int len=0,j;

  for(int i=0;i<n;i++)
  {
       for(j=0;j<len;j++)
	{
	     if(arr[i]==duplicate.get(j))
		{
		  break;
		}	  
	}
	if(j==len)
	{
	   duplicate.add(arr[i]);
	   len++;
	}
  }

   System.out.print(duplicate);

  
}
}