import java.util.*;
public class Pattern
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the String: ");
String str=sc.nextLine();
int len=str.length();
int mid=len/2;
int start=mid,last=mid;
for(int i=0;i<=mid;i++)
{
   for(int j=i;j<mid;j++)
	{
	   System.out.print(" ");
	}

    int limit=(i+i)+1;
    for(int k=0;k<limit;k++)
	{
	   if(k==0)
	    {
		System.out.print(str.charAt(start));
	    }
	   else if(k==limit-1)
	    {
 		System.out.print(str.charAt(last));
	    }
	   else
	    {
		System.out.print(" ");
	    }
	  
	}
	 start--;
	 last++;
	System.out.println();
}

start=1;
last=len-2;
for(int i=mid-1;i>=0;i--)
{
   for(int j=0;j<mid-i;j++)
	{
	   System.out.print(" ");
	}

    int limit=(i+i)+1;
    for(int k=0;k<limit;k++)
	{
	   if(k==0)
	    {
		System.out.print(str.charAt(start));
	    }
	   else if(k==limit-1)
	    {
 		System.out.print(str.charAt(last));
	    }
	   else
	    {
		System.out.print(" ");
	    }
	  
	}
	 start++;
	 last--;
	System.out.println();
}
 
}
}