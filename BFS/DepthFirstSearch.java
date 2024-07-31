import java.util.*;
class Graph
{
   int vertices;
   LinkedList<Integer>[] adjList;
   @SuppressWarnings("unchecked") Graph(int vertices)
    {
       this.vertices=vertices;
       adjList=new LinkedList[vertices];
       for(int i=0;i<vertices;i++)
        {
          adjList[i]=new LinkedList<>();
         }
    }

    void addedge(int source,int dest)
    {
        adjList[source].add(dest);
    }

   void Dfs(int start,boolean visited[])
   {      
       visited[start]=true;
       System.out.print(start+" ");
       Iterator<Integer> i=adjList[start].listIterator();
       while(i.hasNext())
       {
          int current=i.next();
           if(!visited[current])
           {
              Dfs(current,visited);
           }
        }     
     }

}

public class DepthFirstSearch
{
  public static void main(String arsgs[])
  {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the number of vertices:");
   int vertices=sc.nextInt();
   Graph graph=new Graph(vertices);
   System.out.println("Enter the number of Edges: ");
   int edges=sc.nextInt();
   System.out.println("Enter the Sources and Destinations: ");
   for(int i=0;i<edges;i++)
    {
      int source=sc.nextInt();
      int dest=sc.nextInt();
      graph.addedge(source,dest);
   }
  System.out.println("Enter the Start node");
  int start=sc.nextInt();
  boolean visited[]=new boolean[vertices];
  graph.Dfs(start,visited);
        
  }
}