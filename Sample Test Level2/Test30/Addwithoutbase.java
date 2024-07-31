import java.util.*;
public class Addwithoutbase
{

public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the First number: ");
   int n=sc.nextInt();
   System.out.print("Enter the Second Number: ");
   int m=sc.nextInt();
   System.out.print("Enter the Base: ");
   int base=sc.nextInt();
   int i,j,rem=0,ind=0;
   int ans[]=new int[1000];
   while(n>0||m>0)
    {
      int sum=n%10+m%10+rem;
      ans[ind]=sum%base;
      ind++;
      rem=(n%10+m%10+rem)/base;
      n/=10;
      m/=10;
    }
   if(rem!=0)
    {
      ans[ind]=rem;
    }
  for(i=ind-1;i>=0;i--)
   {
     System.out.print(ans[i]);
   }
   
   
 }
}