import java.util.*;
public class Strtask4
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  String Str=sc.nextLine();
  
  Str=Str.replaceAll("\\s","");
  Str=Str.replaceAll("[^a-zA-Z0-9]","");
  if(Str.isEmpty())
  {
      System.out.print("Palindrome");
      return;
  }
  int i=0;
  int j=Str.length()-1;
  int len=j+1;
  while(i<j)
  {
   if(Character.toLowerCase(Str.charAt(i))!=Character.toLowerCase(Str.charAt(len-i-1)))
   {
     break;
   }
   i++;
   j--;
  }
  if(i==j)
   {
     System.out.println("Palindrome");
   }
   else
    {
      System.out.println("Not a Palindrome");
    }
}
}