package graph;

public class GraphSearch {

  public static void main(String[] args) {

    GraphAdjacencyList2 graph = new GraphAdjacencyList2();
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(1, 6);

    graph.addEdge(2, 3);
    graph.addEdge(2, 1);

    graph.addEdge(3, 1);
    graph.addEdge(3, 6);
    graph.addEdge(3, 2);

    graph.addEdge(4, 1);
    graph.addEdge(4, 6);

    graph.addEdge(6, 1);
    graph.addEdge(6, 5);
    graph.addEdge(6, 8);

    graph.addEdge(8, 6);
    graph.addEdge(8, 7);

    System.out.println("Has path between 1 and 8 through DFS: " + graph.hasPathDFS(1, 8));
    System.out.println("Has path between 1 and 7 through BFS: " + graph.hasPathBFS(1, 7));

    graph = new GraphAdjacencyList2();
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);

    graph.addEdge(2, 1);

    graph.addEdge(3, 0);
    graph.addEdge(3, 1);

    graph.addEdge(4, 4);

    System.out.println("Has path between 1 and 8 through DFS: " + graph.hasPathDFS(1, 4));
    System.out.println("Has path between 1 and 7 through BFS: " + graph.hasPathBFS(1, 4));



  }

}
