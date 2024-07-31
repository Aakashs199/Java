import java.util.*;
public class OddNumbers
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Number of Terms: ");
int n=sc.nextInt();
int arr[]=new int[n];
for(int i=0;i<n;i++)
{
  arr[i]=sc.nextInt();
}

int sum=0;
for(int i=1;i<n;i++)
{
 if(arr[i]%2==0)
  {
   sum+=arr[i];
  }
 if(arr[i]%2!=0&&arr[i-1]%2!=0)
  {
    sum+=arr[i];
  }
 
}
if(n>0)
{
sum+=arr[0];
System.out.print("Sum of Odd Integers: "+sum);
}
}
}
