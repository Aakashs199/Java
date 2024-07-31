import java.util.*;
public class Strtask9
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  String str=sc.nextLine();
  StringBuilder a=new StringBuilder();
  StringBuilder b=new StringBuilder();
  int i,j;
  for(char c:str.toCharArray())
   {
     if(Character.isDigit(c))
      {
        a.append(c);
       }
     else
       {
         b.append(c);
       }
   }
  int n=a.length();
  int m=b.length();
  if(Math.abs(m-n)>1)
   {
     return;
    }
  StringBuilder ans=new StringBuilder();
  for(i=0;i<Math.min(m,n);++i)
   {
     if(m>n)
      {
        ans.append(a.charAt(i));
        ans.append(b.charAt(i));
      }
     else
      {
        ans.append(b.append(i));
        ans.append(a.append(i));
      }
   }
   if(m>n)
   {
    ans.append(a.charAt(m-1));
   }
   if(m<n)
   {
    ans.append(b.charAt(n-1));
   }
   System.out.println(ans.toString());
}
}