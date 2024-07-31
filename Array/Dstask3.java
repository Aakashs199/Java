import java.util.*;
public class Dstask3
{
public static void main(String args[])
{
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   String arr[]=new String[n];
   sc.nextLine();
   int i,j;
   for(i=0;i<n;i++)
   {
      arr[i]=sc.nextLine();
   }
      System.out.println("Enter the prefix:");
      String str=sc.nextLine();
   for(String temp:arr)
   {
  int count=0;
       for(j=0;j<str.length();j++)
        {
           if(temp.charAt(j)==str.charAt(j))
            {
              count++;
            }
            else
             {
                break;
              }
        }
     if(count==str.length())
      {
           System.out.println("The words maths are: "+temp);
      }
   }
}
}