import java.util.*;
class Graph
{
  int v;
  LinkedList<Integer>[] adjList;
  @SuppressWarnings("unchecked") Graph (int v)
  {
    this.v=v;
    adjList=new LinkedList[v];
     for(int i=0;i<v;i++)
      {
         adjList[i]=new LinkedList<>();
      }
  }
 void addEdge(int source,int dest)
   {
      adjList[source].add(dest);
   }
  void bfs(int start)
   {
     Queue<Integer>queue=new LinkedList<>();
     boolean visited[]=new boolean[v];
     visited[start]=true;
     queue.add(start);
     while(!queue.isEmpty())
       {
          int current=queue.poll();
          System.out.print(current+" ");
          for(int neighbor:adjList[current])
            {
               if(!visited[neighbor])
                {
                   visited[neighbor]=true;
                   queue.add(neighbor);
                 }
            }
       }
    }
}

public class Bfsgraph
{
  public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the number of vertices");
      int v=sc.nextInt();
      Graph graph=new Graph(v);
      System.out.println("Enter the number of Edges");
      int n=sc.nextInt();
      for(int i=0;i<n;i++)
       {
          int source=sc.nextInt();
          int dest=sc.nextInt();
          graph.addEdge(source,dest);
       }
      System.out.println("Enter the Root :");
      int root=sc.nextInt();
      graph.bfs(root);
   }
}