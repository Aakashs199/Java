import java.util.*;
public class Partition
{

public static void printPath(String path[],int ind)
{
   for(int i=0;i<ind;i++)
	{
	   System.out.print(path[i]+" ");
	}
    System.out.println();
}

public static boolean checkPalindrome(String str,int start,int end)
{
   while(start<=end)
	{
	   if(str.charAt(start++) != str.charAt(end--))
		{
		    return false;
		}
	}
  return true;
}

public static void funPartition(int index,String str,String path[],int ind)
{
    if(index==str.length())
	{
	     printPath(path,ind);
	     return;	
	}
     for(int i=index;i<str.length();i++)
	{
	    if(checkPalindrome(str,index,i))
		{
		   path[ind]=str.substring(index,i+1);
		   funPartition(i+1,str,path,ind+1);
		}	
	}
}



public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    String path[]=new String[str.length()];
    funPartition(0,str,path,0);
 }
}