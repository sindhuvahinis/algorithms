package graph;

public class GraphMain {

  public static void main(String[] args) {
    GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);

    graph.addEdge(0, 3);
    graph.addEdge(1, 3);
    graph.addEdge(1, 2);
    graph.addEdge(2, 4);

    graph.printMatrix();
    graph.printEdgesUsingMatrix();

    // Graph using adj list

    GraphAdjacencyList1 adjListGraph = new GraphAdjacencyList1();

    Node a = new Node(0, "A");
    Node b = new Node(1, "B");
    Node c = new Node(2, "C");
    Node d = new Node(3, "D");
    Node e = new Node(4, "E");

    adjListGraph.addEdge(a, d);
    adjListGraph.addEdge(b, d);
    adjListGraph.addEdge(b, c);
    adjListGraph.addEdge(c, e);

    adjListGraph.printEdgesUsingAdjList();
  }

}
