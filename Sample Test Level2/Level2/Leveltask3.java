import java.util.*;
public class Leveltask3
{
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the String");
      String str=sc.nextLine();
      System.out.println("Enter the n value");
      int n=sc.nextInt();
      int len=str.length();
      int count=0,i;

      for(i=0;i<len;i++)
       {
         if(str.charAt(i)=='a')
           {
              count++;
           }
       }
       count*=(n/len);
       for(i=0;i<(n%len);i++)
       {
         if(str.charAt(i)=='a')
           {
              count++;
           }
       }

        System.out.println("The number of a is: "+count);
  }
}