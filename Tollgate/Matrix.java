import java.util.Scanner;

public class Matrix 
{
 public static void change(char arr[][], boolean visited[][], int col, int m, int n, char color) 
    {
        for(int i=m;i>=0;i--)
         {
            if(!visited[i][col]) 
		{
                arr[i][col] = color;
                visited[i][col] = true;
                break;
              }
        }
    }
 public static int change2(char arr[][], boolean visited[][], int col, int m, int n, char color) 
    {
       if(visited[0][col])
	{
	   return 0;
	}
        for(int i=m;i>=0;i--)
         {
            if(!visited[i][col]) 
		{
                arr[i][col] = color;
                visited[i][col] = true;
                break;
              }
        }
    return 1;
    }
/*public static int change3(char arr[][], boolean visited[][], int col, int m, int n, char color) 
    {
           if(!visited[i][col]) 
		{
                arr[i][col] = color;
                visited[i][col] = true;
                return;
              }
        for(int i=m;i>=0;i--)
         {
           
	    else
	    {
	      for(int j=0;j<=n;j++)
		{
		   
		}
	    }
        }
    return 1;
    } */

 public static void main(String args[])
   {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of M: ");
        int m = sc.nextInt();
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();
        char arr[][] = new char[m][n];
        boolean visited[][] = new boolean[m][n];
        for(int i=0; i < m; i++) 
	  {
            for (int j=0;j<n;j++)
	    {
                arr[i][j] = '-';
                visited[i][j] = false;
            }
        }

        while (true)
	 {
            System.out.println("Choose an option:");
            System.out.println("1. Module");
            System.out.println("2. Module");
            int choice = sc.nextInt();
            switch (choice) 
		{
                  case 1:
		  {
		   int size=m*n;
		   while(size>=1)
		   {
                     System.out.print("Enter the column value: ");
                     int col=sc.nextInt()-1;
                     if(col < 0 || col >= n)
		     {
                        System.out.println("Invalid column value. Try again.");
                        break;
                    }
                    System.out.print("Enter the color: ");
                    char color = sc.next().charAt(0);
                    change(arr, visited, col, m - 1, n - 1, color);
                     
                    for(int i = 0; i < m; i++) 
			{
                        for(int j = 0; j < n; j++)
			 {
                            System.out.print(arr[i][j] + " ");
                         }
                        System.out.println();
                    }
		   System.out.println("Enter the 1 to continue: ");
		   System.out.println("Enter the 0 to exit: ");
                   int conti=sc.nextInt();
                    if(conti==1)
			{
                           size--;
			}
		    else
			{
				break;
			}
		  }
                    break;
                }
                case 2: 
		{
		    for(int i=0; i < m; i++) 
	             {
                     for(int j=0;j<n;j++)
	               {
                        arr[i][j] = '-';
                        visited[i][j] = false;
                       }
                     }
		int size=m*n;
		while(size>=1)
		{
		    System.out.print("Enter the column value: ");
                    int col=sc.nextInt()-1;
                    if(col< 0|| col>=n)
		    {
                        System.out.println("Invalid column value. Try again.");
                        break;
                    }
                     System.out.print("Enter the color: ");
                     char color = sc.next().charAt(0);
                     int result=change2(arr,visited,col,m-1,n-1,color);
			if(result==0)
			{
			System.out.println("-----Out of the Program----");
		           break;
			}
                       for(int i=0;i<m;i++) 
			 {
                          for(int j=0;j<n;j++)
			   {
                            System.out.print(arr[i][j] + " ");
                           }
                        System.out.println();
		        }
			System.out.println("Enter the 1 to continue: ");
		   System.out.println("Enter the 0 to exit: ");
                   int conti=sc.nextInt();
                    if(conti==1)
			{
                           size--;
			}
		    else
			{
				break;
			}
                    }
                    break;
                }



                default: 
		{
                    System.out.println("Invalid choice. Try again.");
                    break;
                }
            }
        }
    }
}
