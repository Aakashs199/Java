import java.util.*;
// Class to represent a node of adjacency list
class AdjNode 
{
    int dest;
    AdjNode next;
    public AdjNode(int dest)
    {
        this.dest = dest;
        this.next = null;
    }
}

// Class to represent an adjacency list
class AdjList 
 {
    AdjNode head;
 }

// Class to represent the graph
class Graph
 {
    int V; // number of vertices in the graph
    AdjList[] array;
    public Graph(int V)
   {
        this.V = V;
        array = new AdjList[V];
        for (int i = 0; i < V; i++)
            array[i] = new AdjList();
    }
}

public class Main 
{
    // Function to add an edge to an undirected graph

    static void addEdge(Graph graph, int src, int dest)
 {
        // Add an edge from src to dest
        AdjNode newNode = new AdjNode(dest);
        newNode.next = graph.array[src].head;
        graph.array[src].head = newNode;

        // Since the graph is undirected, add an edge from dest to src as well
        newNode = new AdjNode(src);
        newNode.next = graph.array[dest].head;
        graph.array[dest].head = newNode;
    }


    // Function to print the adjacency list representation of the graph
    static void printGraph(Graph graph) 
{
        for (int v = 0; v < graph.V; ++v)
 {
            AdjNode pCrawl = graph.array[v].head;
            System.out.println("\nAdjacency list of vertex " + v);
            while (pCrawl != null) {
                System.out.print(" -> " + pCrawl.dest);
                pCrawl = pCrawl.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
   {
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        printGraph(graph);
    }
}
