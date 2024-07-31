import java.util.*;
public class Substring
{
public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   int i,j,flag=0;
   System.out.print("Enter the String: ");
   String str=sc.nextLine();
   System.out.print("Enter the Sub String: ");
   String sub=sc.nextLine();
   int len1=str.length()-sub.length();
   int len2=sub.length();
   for(i=0;i<=len1;i++)
    {
       if(str.charAt(i)==sub.charAt(0))
         {
              for(j=0;j<len2;j++)
               {
                 if(str.charAt(i+j)!=str.charAt(j))
                   {
                     flag=1;
                     break;
                   }
               }
                 if(flag==1)
                    {
                      System.out.print("Index: "+i);
                      break;
                     }
         } 
      }
       if(flag==0)
        {
          System.out.print("No substring found");
        }
 }
}