import java.util.*;
class Edge
 {
    int source, dest;
    public Edge(int source, int dest) 
     {
        this.source = source;
        this.dest = dest;
    }
}

class Graph 
{
    List<List<Integer>> adjList = null;
    Graph(int n) 
   {
     adjList = new ArrayList<>();
     for (int i = 0; i < n; i++)
      {
         adjList.add(new ArrayList<>());
      }
    }
    public void addEdge(int src, int dest)
    {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
}

class Bfs
 {
  public static void BFS(Graph graph, int v, boolean[] discovered)
   {
     Queue<Integer> q = new ArrayDeque<>();
     discovered[v] = true;
     q.add(v);
     while(!q.isEmpty())
       {
            v = q.poll();
            System.out.print(v + " ");
            for (int u:graph.adjList.get(v))
              {
                if (!discovered[u])
                 {
                    discovered[u] = true;
                    q.add(u);
                }
              }
        }
    }

 public static void main(String[] args)
 {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter the number of vertices in the graph: ");
     int n = scanner.nextInt();
     Graph graph = new Graph(n);
     System.out.print("Enter the number of edges in the graph: ");
     int m = scanner.nextInt();
     System.out.println("Enter the edges with source and destination:");
     for (int i = 0; i < m; i++)
       {
         int source = scanner.nextInt();
         int dest = scanner.nextInt();
         graph.addEdge(source, dest);
        }
     boolean[] discovered = new boolean[n];
     for(int i=0;i<n;i++) 
      {
        if (!discovered[i])
         {
           BFS(graph, i, discovered);
         }
      }
        scanner.close();
    }
}
