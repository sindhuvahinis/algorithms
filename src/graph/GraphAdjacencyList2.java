package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjacencyList2 {

  public static class Node {
    int id;
    LinkedList<Node> adjacent = new LinkedList<>();

    Node(int id) {
      this.id = id;
    }
  }

  private HashMap<Integer, Node> nodeLookUp;

  GraphAdjacencyList2() {
    nodeLookUp = new HashMap<>();
  }

  private Node getNode(int id) {
    return nodeLookUp.computeIfAbsent(id, x -> new Node(id));
  }

  public void addEdge(int source, int destination) {
    Node sourceNode = getNode(source);
    Node destinationNode = getNode(destination);

    sourceNode.adjacent.add(destinationNode);
  }

  public boolean hasPathDFS(int source, int destination) {
    Node sourceNode = getNode(source);
    Node destinationNode = getNode(destination);
    HashSet<Integer> isVisited = new HashSet<>();
    return hasPathDFS(sourceNode, destinationNode, isVisited);
  }

  private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
    if (visited.contains(source.id)) {
      return false;
    }

    visited.add(source.id);
    if (source.id == destination.id)
      return true;

    for (Node adjacentNode : source.adjacent) {
      if(hasPathDFS(adjacentNode, destination, visited)) {
        return true;
      }
    }

    return false;
  }

  public boolean hasPathBFS(int source, int destination) {
    Node sourceNode = getNode(source);
    Node destinationNode = getNode(destination);
    HashSet<Integer> visited = new HashSet<>();
    return hasPathBFS(sourceNode, destinationNode, visited);
  }

  private boolean hasPathBFS(Node source, Node destination, HashSet<Integer> visited) {

    Queue<Node> queue = new LinkedList<>();
    queue.add(source);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (visited.contains(node.id)) {
        continue;
      }

      visited.add(node.id);

      if (node.id == destination.id)
        return true;

      queue.addAll(node.adjacent);
    }

    return false;
  }





}
