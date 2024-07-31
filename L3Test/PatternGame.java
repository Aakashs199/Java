import java.util.*;
public class PatternGame 
  {

    static boolean dfs(char arr[][],String str, int startrow, int startcol, int row, int col, int ind)
	 {
        if(ind==str.length())
	 {
            return true;
         }
        if(startrow<0 ||startrow>=row||startcol<0||startcol>=col||str.charAt(ind)!=arr[startrow][startcol]) 
	{
            return false;
        }
        return  dfs(arr, str, startrow - 1, startcol, row, col, ind + 1) || 
                dfs(arr, str, startrow + 1, startcol, row, col, ind + 1) || 
                dfs(arr, str, startrow, startcol - 1, row, col, ind + 1) ||
                dfs(arr, str, startrow, startcol + 1, row, col, ind + 1) ||
                dfs(arr, str, startrow - 1, startcol - 1, row, col, ind + 1) ||
                dfs(arr, str, startrow - 1, startcol + 1, row, col, ind + 1) ||
                dfs(arr, str, startrow + 1, startcol - 1, row, col, ind + 1) ||
                dfs(arr, str, startrow + 1, startcol + 1, row, col, ind + 1);
    }

 public static void main(String args[])
 {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of Rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of Columns: ");
        int col = sc.nextInt();
        char[][] arr=new char[row][col];
        for (int i=0;i<row;i++) 
	{
          for(int j=0;j<col;j++)
	   {
              arr[i][j]=sc.next().charAt(0);
            }
        }
      System.out.println("----The Pattern Matrix----");
       for(int i=0;i<row;i++) 
	{
          for(int j=0;j<col;j++)
	    {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Enter the Number of input dictionary: ");
        int n = sc.nextInt();
        String words[] = new String[n];
        sc.nextLine();
        for(int i=0;i<n;i++)
	 {
            words[i] = sc.nextLine();
         }

        for(int k=0;k<n;k++)
	 {
            boolean found = false;
            for(int i=0;i<row&&!found;i++)
	      {
                for(int j=0;j<col&&!found;j++)
		 {
                    if(arr[i][j] == words[k].charAt(0))
			 {
                           if(dfs(arr,words[k],i,j,row,col,0))
			    {
                            System.out.println("VALID");
                            found = true;
                            }
                         }
                  }
               }
            if(!found)
		 {
                    System.out.println("NOT VALID");
                 }
          }

    }
}
