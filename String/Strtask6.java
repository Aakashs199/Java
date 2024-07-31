import java.util.*;
public class Strtask6
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  String S=sc.nextLine();
  String goal=sc.nextLine();
  int i,j,len1,len2,index=0;
  len1=S.length();
  len2=goal.length();
   for(i=len2-1;i>=0;i--)
    { 
       if(goal.charAt(i)==S.charAt(0))
         {
           index=i;
           break;
          }  
   }
   System.out.println("I= "+index);
  for(i=0;i<len1;i++)
   {
     if(index==len2)
       {
          index=0;
       }
      if(S.charAt(i)!=goal.charAt(index))
       {
         break;
       }
     index++;
   }
  if(i==len1)
   {
     System.out.println("TRUE");
   }
  else
   {
    System.out.println("FALSE");
    }
}
}