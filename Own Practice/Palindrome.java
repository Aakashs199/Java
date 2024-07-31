import java.util.*;
public class Palindrome
{

public static boolean checkPalindrome(String str,int start,int end)
{
    while(start<end)
	{
	    if(str.charAt(start++)!=str.charAt(end--))
		{
		    return true;
		}
	}
   return false;
}
public static void printWord(String str,int start,int end)
{
    for(int i=start;i<=end;i++)
	{
	   System.out.print(str.charAt(i));	
	}
	System.out.print(" ");
}


public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the String: ");
    String str=sc.nextLine().toLowerCase();
    int len=str.length();
    int start=0;
    for(int i=0;i<=len;i++)
	{
	    if(i==len||str.charAt(i)==' ')
		{
		    int end=i-1;
		    if(checkPalindrome(str,start,end))
			{
		           printWord(str,start,end);
			}
		  start=i+1;
		}
	     
	}
}
}