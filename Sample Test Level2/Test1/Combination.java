import java.util.*;

public class Combination 
{
  static void parenthesis(char str[], int ind,int n,int first,int last) 
  {
    if(ind==str.length)
     {
      for(char ch:str)
       {
        System.out.print(ch);
       }
     System.out.println();
     return;
    }
    else
    {
      if(first<n)
        {
         str[ind]='{';
         System.out.println(ind+","+n+","+first+","+last+"----");
         parenthesis(str,ind+1,n,first+1,last);
        }
      if(last<first)
        {
         str[ind]='}';
          System.out.println(ind+","+n+","+first+","+last);
         parenthesis(str,ind+1,n,first,last+1);
        }
     }
    }

public static void main(String args[]) 
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number: ");
   int n=sc.nextInt();
   char str[]=new char[2 * n];
   if (n>0)
    {
       parenthesis(str, 0, n, 0, 0);
    } 
  else
   {
     System.out.print("Not Possible");
 }
    }
}
