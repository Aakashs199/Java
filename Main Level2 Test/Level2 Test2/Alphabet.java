import java.util.*;
public class Alphabet
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Character: ");
String str=sc.nextLine().toUpperCase();
int result=0;
for(int i=0;i<str.length();i++)
{
   result=result*26+(str.charAt(i)-'A'+1);
}
System.out.println(result);
}
}n