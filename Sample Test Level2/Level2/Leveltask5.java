import java.util.*;
public class Leveltask5
{
public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     String str=sc.nextLine();
     int i,flag=0;
     int len=str.length();
     for(i=0;i<len-1;i++)
      {
         int temp1=Math.abs((int)str.charAt(i)-(int)str.charAt(i+1));
         int temp2=Math.abs((int)str.charAt(len-i-1)-(int)str.charAt(len-i-2));
         System.out.println(temp1+" "+temp2);
         if(temp1==temp2)
          {
            flag=0;
          }
         else
          {
             flag=1;
             break;
          }
      }
      if(flag==0)
       {
          System.out.println("Beautiful");
       }
      else
       {
          System.out.println("NOt a Beautiful");
        }
  }
}