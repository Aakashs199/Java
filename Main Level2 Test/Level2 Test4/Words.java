import java.util.*;
public class Words
{

public static boolean iscontains(String str,char[] arr,int n)
{
  
   int count=0;
    for(int i=0;i<str.length();i++)
	{
	    for(int j=0;j<n;j++)
	     {
	        if(str.charAt(i)==arr[j])
	 	{
		   count++;
		   break;
		}
	     }
	}
   if(count==str.length())
	{
	   return true;
	}
   else
	{
	   return false;
	}
}

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Number of characters: ");
int n=sc.nextInt();
char arr[]=new char[n];
for(int i=0;i<n;i++)
{
  arr[i]=sc.next().charAt(0);
}
String words[]={"one","two","three","four","five","six","seven","eigth","nine","ten"};

for(int i=0;i<10;i++)
 {
   String str=words[i];
   if(iscontains(str,arr,n))
	{
	   System.out.print(str+" ");
	}
 }


}
}