import java.util.*;
public class MatricDiamond
{
static int dfs(int arr[][],int i,int j,int n,boolean valid[][],int s)
{
  if(i<0||j<0||i>=n||j>=n||arr[i][j]==-1)
   {
     return;
   }
  if(arr[i][j]==1 && valid[i][j]==false)
   {
     sum+=1;
     valid[i][j]=true;
   }
  if(i==n-1 && j==n-1)
   {
     return sum;
   }
  dfs(arr,i,j+1,n,valid,sum);
  dfs(arr,i+1,j,n,valid,sum);
  
}

public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the N value");
  int n=sc.nextInt();
  int arr[][]=new int[n][n];
  for(int i=0;i<n;i++)
   {
     for(j=0;j<n;j++)
      {
        arr[i][j]=sc.nextInt();
      }
   }
  boolean[][] valid=new boolean[n][n];
   int value=dfs(arr,0,0,n,valid);
  System.out.print(value);
}
}