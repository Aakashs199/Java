import java.util.*;
public class Singlenumberfind
{
  
public static int containsSingle(int n)
{

if(n==0)
{
 return 0;
}

int res=n%9;
return res==0 ? 9 : res;
}

public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the Number: ");
  int n=sc.nextInt();
  System.out.print("Single Digit Answer: "+containsSingle(n));
}
}