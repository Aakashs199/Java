import java.util.*;

public class PascalTriangle 
{
  public static int functionnCr(int n,int r)
   {
        int ans=1;
	int ans2=1;
        for (int i=0;i<r;i++) 
	{
           ans=ans*(n-i);
           ans2=ans2*(i+1);
        }
       return ans/ans2;
    }

public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the N Value: ");
    int n=sc.nextInt();
    for(int i=0;i<n;i++)
      {
            for(int j=0;j<n-i;j++) 
	    {
                System.out.print(" ");
            }

            for(int j=0;j<=i;j++)
	    {
                System.out.printf(functionnCr(i,j)+" ");
            }
            System.out.println();
      }
    
}
}