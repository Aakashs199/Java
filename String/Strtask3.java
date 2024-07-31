import java.util.*;
public class Strtask3
{
public static void main(String args[])
{ 
   Scanner sc=new Scanner(System.in);
   String a=sc.nextLine();
   String b=sc.nextLine();
   int rem=0,sum=0,len1=a.length()-1,len2=b.length()-1;
   StringBuilder ans=new StringBuilder();
   while(len1>=0||len2>=0||rem==1)
   {
      sum=rem;
      if(len1>=0)
       {
         sum+=a.charAt(len1)-'0';
       }  
       if(len2>=0)
       {
         sum+=b.charAt(len2)-'0';
       }
      ans.append((char)(sum%2+'0'));  
      rem=sum/2;
      len1--;
      len2--;
   }
 System.out.print(ans.reverse());

}
}