package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjanBridgeConnection {

    List<List<Integer>> result;
    List<Integer>[] adjacencyList;
    int[] discoveredTime;
    int[] lowerPathTime;
    boolean[] visited;

    private void findBridgeConnection() {
        int n = adjacencyList.length;
        result = new ArrayList<>();
        discoveredTime = new int[n];
        lowerPathTime = new int[n];
        visited = new boolean[n];

        trajanAlgorithm(-1, 0, 0);
    }

    private void trajanAlgorithm(int parentVertex, int currentVertex, int timeStamp) {

        visited[currentVertex] = true;
        discoveredTime[currentVertex] = timeStamp;
        lowerPathTime[currentVertex] = timeStamp;

        for (Integer adjacentIndex : adjacencyList[currentVertex]) {

            if (!visited[adjacentIndex]) {
                trajanAlgorithm(currentVertex, adjacentIndex, timeStamp+1);

                lowerPathTime[currentVertex] = Math.min(lowerPathTime[currentVertex], lowerPathTime[adjacentIndex]);

                if (lowerPathTime[adjacentIndex] > discoveredTime[currentVertex]) {
                    result.add(Arrays.asList(adjacentIndex, currentVertex));
                }

            } else if (adjacentIndex != parentVertex) {
                lowerPathTime[currentVertex] = Math.min(lowerPathTime[currentVertex], lowerPathTime[adjacentIndex]);
            }
        }

    }

    private void constructAdjacencyList(List<List<Integer>> edges, int n) {
        adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList();
        }
        for (List<Integer> edge : edges) {
            int vertex1 = edge.get(0);
            int vertex2 = edge.get(1);

            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(2,3));
        edges.add(Arrays.asList(3,4));
        edges.add(Arrays.asList(4,5));
        edges.add(Arrays.asList(3,5));

        TarjanBridgeConnection connection = new TarjanBridgeConnection();
        connection.constructAdjacencyList(edges, 6);

        connection.findBridgeConnection();

        for (List<Integer> list : connection.result) {
            System.out.println(list);
        }

    }
}
