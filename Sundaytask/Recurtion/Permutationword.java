/* 4. Given a string S, the task is to write a program to print all permutations of a given string.
A permutation also called an arrangement number or order, is a rearrangement of the elements
of an ordered list S into a one-to-one correspondence with S itself. A string of length N has N!
permutations.
Examples:Input: S = ABC Output: ABC, ACB, BAC, BCA, CBA, CAB  */
 
import java.util.*;
public class Permutationword
{
void permutate(String str,int left,int right)
{
   if(left==right)
    {
      System.out.print(str);
      System.out.println();
    }
   else
   {
      for(int i=left;i<=right;i++)
       {
         str=swap(str,left,i);
         permutate(str,left+1,right);
         str=swap(str,left,i); 
	}
   }
}
public String swap(String str,int i,int j)
{
	char[] arr=str.toCharArray();
	char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      return String.valueOf(arr);
}
public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a String: ");
    String str=sc.nextLine();
    int len=str.length();
    Permutationword ob=new Permutationword();
   ob.permutate(str,0,len-1);
  }

}