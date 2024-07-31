import java.util.*;
public class MaxGold 
{
    private List<int[]> bestPath = new ArrayList<>();
    public int dfs(int[][] grid,int row,int col,int i,int j,List<int[]>currentPath)
     {
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]==0 || grid[i][j]==-1) 
	{
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = -1;   
        currentPath.add(new int[]{i,j});
        int up = dfs(grid,row,col,i-1,j,currentPath);
        int down = dfs(grid,row,col,i+1,j,currentPath);
        int left = dfs(grid,row,col,i,j-1,currentPath);
        int right = dfs(grid,row,col,i,j+1,currentPath);

        int maxGold = Math.max(Math.max(up,down),Math.max(left,right));
        int totalGold = temp+maxGold;

        grid[i][j] = temp;  

            if(totalGold>maxGold)
	     {
                bestPath = new ArrayList<>(currentPath);
             }
        

        currentPath.remove(currentPath.size() - 1);  
        return totalGold;
    }

 public int maxGold(int[][] grid, int row, int col) 
   {
          int maxGold=0;
          for(int i=0;i<row;i++)
	   {
             for(int j=0;j<col;j++)
	       {
                 if(grid[i][j] != 0) 
		  {
                     List<int[]> currentPath=new ArrayList<>();
                     int gold = dfs(grid,row,col,i,j,currentPath);
                     if(gold>maxGold) 
			{
                          maxGold = gold;
                          bestPath = new ArrayList<>(currentPath);
                        }
                   }
                }
            }
        return maxGold;
      }

 public List<int[]> getPath() 
   {
     return bestPath;
   }

 public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        MaxGold ob=new MaxGold();

        System.out.print("Enter the Number of Rows: ");
        int row=sc.nextInt();
        System.out.print("Enter the Number of Columns: ");
        int col=sc.nextInt();
        int[][] grid=new int[row][col];

        System.out.println("Enter the grid values:");
        for(int i=0;i<row;i++)
	 {
            for(int j=0;j<col;j++)
	      {
                grid[i][j]=sc.nextInt();
              }
          }

        int ans=ob.maxGold(grid, row, col);
        System.out.println("Maximum Gold: " + ans);

        List<int[]> path=ob.getPath();
        System.out.println("Path:");
        for(int[] p : path) 
	{
            System.out.println(Arrays.toString(p));
        }
    }
}
