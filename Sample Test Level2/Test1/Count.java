import java.util.*;
public class Count
{
public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the Integer: ");
    int n=sc.nextInt();
    int counts[]=new int[10];
    int ans[]=new int[10];
    int i,rem,ind=0,count=1;
    while(n>0)
    {
      rem=n%10;
      n/=10;
      if(rem==n%10)
       {
         count++;
       }
      else
       {
        ans[ind]=rem;
        ind++;
        ans[ind]=count;
        ind++;
        count=1;
       }
    }
    for(i=ind-1;i>=0;i--)
     {
       System.out.print(ans[i]);
     }
  }
}