package graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * This graph representation is inspired from https://stackabuse.com/graphs-in-java-representing-graphs-in-code/
 * <p>
 * This graph implementation represents only undirected and unweighted graph.
 * <p>
 * Here, we represent graph in two ways: 1. Adjacency matrix 2. Adjacency list
 */
public class GraphAdjacencyMatrix {

  private int[][] adjacency_matrix;

  GraphAdjacencyMatrix(int numberOfNodes) {
    adjacency_matrix = new int[numberOfNodes][numberOfNodes];
  }


  public void addEdge(int source, int destination) {

    // adding edge in adjacency matrix

    adjacency_matrix[source][destination] = 1;
    adjacency_matrix[destination][source] = 1;
  }


  public void printMatrix() {

    for (int i = 0; i < adjacency_matrix.length; i++) {
      for (int j = 0; j < adjacency_matrix[0].length; j++) {
        System.out.print(adjacency_matrix[i][j] + " ");
      }
      System.out.println();
    }

  }

  public void printEdgesUsingMatrix() {
    System.out.print("\n\nPrinting graph using adjacency matrix: ");

    for (int i = 0; i < adjacency_matrix.length; i++) {
      System.out.print("\nNeighbor nodes of node " + i + " are: ");
      for (int j = 0; j < adjacency_matrix[0].length; j++) {
        if (adjacency_matrix[i][j] == 1) {
          System.out.print(j + ", ");
        }
      }
    }
  }

}
