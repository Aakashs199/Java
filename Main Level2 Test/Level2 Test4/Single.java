import java.util.*;
public class Single
{
 public static int singleNumber(int n)
  {
     if(n==0)
	{
	  return 0;
	}
     int sum = (n%10)+singleNumber(n/10);
    if(sum<10)
     {
       return sum;
      } 
    else
     {
        return singleNumber(sum);
     }
  }

  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the Number: ");
    int n=sc.nextInt();
    System.out.println(singleNumber(n));
  }
}