package graph;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphAdjacencyList1 {

  private HashMap<Node, LinkedList<Node>> adjacency_list;

  GraphAdjacencyList1() {
    adjacency_list = new HashMap<>();
  }

  public void addEdge(Node source, Node destination) {
    // adding edge in adjacency list

    if (adjacency_list.get(source) != null) {
      for (Node node : adjacency_list.get(source)) {
        if (node == destination)
          return;
      }
    }

    if (adjacency_list.get(destination) != null) {
      for (Node node : adjacency_list.get(destination)) {
        if (node == source)
          return;
      }
    }

    adjacency_list.computeIfAbsent(source, x -> new LinkedList<>()).add(destination);
    adjacency_list.computeIfAbsent(destination, x -> new LinkedList<>()).add(source);

  }

  public void printEdgesUsingAdjList() {

    System.out.print("\n\nPrinting graph using adjacency list: ");
    for (Node node : adjacency_list.keySet()) {
      System.out.print("\nNeighbor nodes of " + node.name + " are: ");
      for (Node neighborNode : adjacency_list.get(node)) {
        System.out.print(neighborNode.name + " ,");
      }
    }
  }


}
