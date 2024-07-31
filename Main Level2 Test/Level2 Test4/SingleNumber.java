import java.util.*;
public class SingleNumber
{
public static void singleNumber(int n)
  {
   System.out.println(n);
   
     int temp=n,rem;
     int sum=0;
	while(temp>0)
	{
	  rem=temp%10;
	  sum+=rem;
	  temp/=10;
	}

	if(sum<10)
 	{
         System.out.println("The Single Digit answer is: "+sum);
	  return; 
	}
        else
	{
	   singleNumber(sum);
	}
	
  }

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the Number: ");
int n=sc.nextInt();
singleNumber(n);
}
}