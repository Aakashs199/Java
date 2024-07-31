import java.util.*;
public class Vertexcolor
{
 static boolean formsgraph(int graph[][],int color,int visited[],int index)
  {
     if(index==vertex)
      {
         return true;
      }
      for(int c=0;
  }

  static boolean graphcolor(int graph[][],int vertex,int color)
 {
   int visited[]=new int[vertex];
   int i;
   for(i=0;i<vertex;i++)
   {
     visited[i]=0;
   } 
   if(!formsgraph(graph,color,visited,0)
     {
       System.out.println("Solution is Not Possible");
       return false;
     } 
    print(visited,vertex);
    return true;
 }

static void print(int visited[],int vertex)
 {
    for(int i=0;i<vertex;i++)
     {
        System.out.print(visited[i]+" ");
      }
 }

{
 public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the number of Vertices: ");
    int n=sc.nextInt();
    int graph[][]=new int[vertex][vertex];
    int i,j;
    for(i=0;i<vertex;i++)
     {
       for(j=0;j<vertex;j++)
        {
          graph[i][j]=sc.nextInt();
        }
     }
     System.out.print("Enter the number of Color: ");
     int color=sc.nextInt();
     graphcolor(graph,vertex,color);
   }
}