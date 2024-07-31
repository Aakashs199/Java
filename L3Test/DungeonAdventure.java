import java.util.*;
public class DungeonAdventure
 {
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    public static int minStepsToGold(int numRows,int numCols,int startX,int startY,int goldX,int goldY,char[][] grid,List<int[]> path) 
    {
        boolean[][] visited = new boolean[numRows][numCols];
        int[] minSteps = {Integer.MAX_VALUE};
        List<int[]> currentPath = new ArrayList<>();
        dfs(startX,startY,goldX,goldY,0,visited,numRows,numCols,minSteps,grid,currentPath,path);
        return minSteps[0];
     }

    private static void dfs(int x, int y, int goldX, int goldY, int steps, boolean[][] visited, int numRows, int numCols, int[] minSteps, char[][] grid, List<int[]> currentPath, List<int[]> path) 
       {
          if(x<0 || x>=numRows || y<0 || y>=numCols || visited[x][y] || grid[x][y]=='P')
	   {
             return;
           }

        currentPath.add(new int[]{x, y});

        if(x == goldX && y == goldY)
	 {
            if(steps<minSteps[0]) 
	     {
                minSteps[0] = steps;
                path.clear();
                path.addAll(new ArrayList<>(currentPath));
             }

            currentPath.remove(currentPath.size() - 1);
            return;
        }

     visited[x][y]=true;
     for(int i=0;i<4;i++)
	 {
            int newX = x+rowDir[i];
            int newY = y+colDir[i];
            dfs(newX,newY,goldX,goldY,steps+1,visited,numRows,numCols,minSteps,grid,currentPath,path);
         }

     visited[x][y] = false;
     currentPath.remove(currentPath.size() - 1);

    }

 public static void main(String args[]) 
   {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the Number of cols: ");
        int col = sc.nextInt();
        char arr[][] = new char[row][col];
        for (int i = 0; i < row; i++)
	 {
            Arrays.fill(arr[i],'-');
         }

        System.out.println("Enter the Position of Adventurer: ");
        System.out.print("Enter the row: ");
        int arow = sc.nextInt();
        System.out.print("Enter the col: ");
        int acol = sc.nextInt();
        arr[arow][acol] = 'A';

        System.out.println("Enter the Position of Gold: ");
        System.out.print("Enter the row: ");
        int grow = sc.nextInt();
        System.out.print("Enter the col: ");
        int gcol = sc.nextInt();
        arr[grow][gcol] = 'G';

        System.out.println("Enter the Position of Monster: ");
        System.out.print("Enter the row: ");
        int mrow = sc.nextInt();
        System.out.print("Enter the col: ");
        int mcol = sc.nextInt();
        arr[mrow][mcol] = 'M';

        System.out.println("Enter the Position of Trigger: ");
        System.out.print("Enter the row: ");
        int trow = sc.nextInt();
        System.out.print("Enter the col: ");
        int tcol = sc.nextInt();
        arr[trow][tcol] = 'T';

        System.out.print("Enter the number of pits: ");
        int numPits = sc.nextInt();
        for(int i=0;i<numPits;i++)
	 {
            System.out.print("Position of pit " + (i + 1) + ": ");
            int pitRow = sc.nextInt();
            int pitCol = sc.nextInt();
            arr[pitRow][pitCol] = 'P';
         }

        for(int i=0;i<row;i++)
	 {
            for(int j=0;j<col;j++)
	    {
              System.out.print(arr[i][j] + " ");
            }
           System.out.println();
        }

        List<int[]> adventurePath = new ArrayList<>();

        int minStepsAdventure = minStepsToGold(row,col,arow,acol,grow,gcol,arr,adventurePath);
        int minStepsMonster = minStepsToGold(row,col,mrow,mcol,grow,gcol,arr,new ArrayList<>())+1;

        System.out.println("Adventure: "+minStepsAdventure);
        System.out.println("Monster: "+minStepsMonster);

        if(minStepsAdventure < minStepsMonster)
	 {
            System.out.println("Adventure Wins "+minStepsAdventure);
            System.out.println("Adventure Path: ");
            for(int[] step : adventurePath) 
	    {
                System.out.println(Arrays.toString(step));
            }
         } 

	else
	 {
            List<int[]> triggerPath = new ArrayList<>();
            int minStepsTrigger = minStepsToGold(row,col,arow,acol,trow,tcol,arr,triggerPath);
            System.out.println("Trigger: "+minStepsTrigger);

            if(minStepsTrigger < minStepsMonster) 
	      {
                List<int[]> triggerToGoldPath = new ArrayList<>();
                int triggerToGold = minStepsToGold(row,col,trow,tcol,grow,gcol,arr,triggerToGoldPath);

                System.out.println(minStepsTrigger+triggerToGold);
                System.out.println("Trigger Path: ");

                for(int[] step:triggerPath)
		 {
                    System.out.println(Arrays.toString(step));
                 }
                System.out.println("Trigger to Gold Path: ");
                for(int[] step : triggerToGoldPath)
		 {
                    System.out.println(Arrays.toString(step));
                 }
              } 
 	  else 
	     {
                System.out.print("No Solution");
             }
        }
    }
}
