import java.util.*;
public class GoldGame 
{

    static int dfs(int arr[][], int startrow, int startcol, int row, int col, int sum, boolean[][] visited) 
   {
        if(startrow<0||startrow>=row||startcol<0||startcol>=col||arr[startrow][startcol]==0||visited[startrow][startcol])
   	 {
            return sum;
         }
        visited[startrow][startcol] = true;
        sum += arr[startrow][startcol];
        int maxsum = sum;
        maxsum=Math.max(maxsum,dfs(arr,startrow-1,startcol,row,col,sum,visited));
        maxsum=Math.max(maxsum,dfs(arr,startrow+1,startcol,row,col,sum,visited));
        maxsum=Math.max(maxsum,dfs(arr,startrow,startcol-1,row,col,sum,visited));
        maxsum=Math.max(maxsum,dfs(arr,startrow,startcol+1,row,col,sum,visited));
        visited[startrow][startcol] = false;
        return maxsum;
    }

    public static void main(String args[])
     {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of Rows: ");
        int row=sc.nextInt();
        System.out.print("Enter the number of Columns: ");
        int col=sc.nextInt();
        int[][] arr=new int[row][col];
        for (int i=0;i<row;i++)
	 {
           for(int j=0;j<col;j++)
	    {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("----The Pattern Matrix----");
        for (int i=0;i<row;i++)
	 {
            for(int j=0;j<col;j++)
	    {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int max=Integer.MIN_VALUE;
        int value=0;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++) 
	{
          for(int j=0;j<col;j++) 
	   {
                if(arr[i][j]!=0) 
		{
                  value=dfs(arr,i,j,row,col,0,visited);
                  max=Math.max(max,value);
                }
            }
        }
        System.out.print("Maximum Sum is: " + max);
    }
}
