import java.util.*;
public class Dynamictask1
{
public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the String 1 : ");
    String str1=sc.nextLine();
    System.out.println("Enter the String 2: ");
    String str2=sc.nextLine();
    int i,j,count=0,ind=0;
    for(i=0;i<str1.length();i++)
     {
       for(j=ind;j<str2.length();j++)
         {
            if(str1.charAt(i)==str2.charAt(j))
             {
                ind=j;
                count++;
                break;
             }
         }
     }
if(str1.length()==count)
  {
   System.out.print("TRUE");
  }
else
  {
 System.out.println("FALSE");
  }
    
 }
}