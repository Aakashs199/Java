import java.util.*;
public class Strtask1
{
public static void main(String args[])
{ 
   Scanner sc=new Scanner(System.in);
   String a=sc.nextLine();
   String str[]=a.split("");
   int i=0;
   int j=str.length-1; 
   int n=str.length;
   while(i<j)
   {
     String temp=str[i];
     str[i]=str[n-i-1];
     str[n-i-1]=temp;
     i++;
     j--;
   }
   for(i=0;i<n;i++)
    {
      System.out.print(str[i]);
    }

}
}