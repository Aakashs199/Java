import java.util.Scanner;
public class Pattern
 {
  public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Value of N: ");
        int n=sc.nextInt();

        System.out.println("-----1st Pattern Printing-----");
        for(int i=1;i<=n;i++)
	  {
            for(int k=1;k<=n-i;k++)
	     {
                System.out.print(" ");
             }
            for(int j=1;j<=i;j++) 
	     {
                System.out.print("* ");
             }
            System.out.println();
        }

        System.out.println("----2nd Pattern Printing----");
        int mid=n/2+1;
        for(int i=1;i<=mid;i++)
	 {
            for(int k=1;k<=mid-i;k++)
	    {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
	    {
                System.out.print("R ");
            }
            System.out.println();
        }

        mid-=1;
        for(int i=1;i<=mid;i++)
	 {
            for(int k=1;k<=i;k++)
	    {
              System.out.print(" ");
            }
            for(int j=i;j<=mid;j++)
	    {
                System.out.print("R ");
            }
            System.out.println();
        }
    }
}
