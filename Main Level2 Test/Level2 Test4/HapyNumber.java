import java.util.*;
public class HapyNumber
{
public static void happyNumber(int n)
  {
   System.out.println(n);
   
     int temp=n,rem;
     int sum=0;
	while(temp>0)
	{
	  rem=temp%10;
	  sum+=rem*rem;
	  temp/=10;
	}

	if(sum==1)
 	{
         System.out.println("Happy Number");
	  return; 
	}
	else if(sum>=2 && sum<=9)
          {
	   System.out.println("Not a Happy Number");
	   return;
	  }
        else
	{
	   happyNumber(sum);
	}
	
  }

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Number: ");
int n=sc.nextInt();
if(n<10)
{
n=n*n;
}
happyNumber(n);
}
}