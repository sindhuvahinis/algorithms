package graph;

import java.util.*;

/**
 * To find the articulation points in a graph
 * using tarjan algorithm.
 */
public class ArticulationPoint {

    HashSet<Integer> result;
    List<List<Integer>> edgesResult;
    int[] low;
    int[] disc;
    boolean[] visited;

    private HashSet<Integer> findArticulationPoint(List<Integer>[] adjacencyList) {
        result = new HashSet<>();
        edgesResult = new ArrayList<>();

        low = new int[adjacencyList.length];
        disc = new int[adjacencyList.length];
        visited = new boolean[adjacencyList.length];

        tarjanAlgorithm(adjacencyList, -1, 0, 0);
        return result;
    }

    private void tarjanAlgorithm(List<Integer>[] adjacencyList, int parentIndex, int currentIndex, int timeStamp) {

        visited[currentIndex] = true;
        disc[currentIndex] = timeStamp;
        low[currentIndex] = timeStamp;

        int numberOfChildren = 0;

        for (Integer adjacentIndex : adjacencyList[currentIndex]) {
            if (parentIndex == adjacentIndex)
                continue;

            if (!visited[adjacentIndex]) {
                numberOfChildren++;

                tarjanAlgorithm(adjacencyList, currentIndex, adjacentIndex, timeStamp + 1);

                if (numberOfChildren >= 2 && parentIndex == -1) {
                    result.add(adjacentIndex);
                }

                if (parentIndex != -1 && low[adjacentIndex] >= disc[currentIndex]) {
                    edgesResult.add(Arrays.asList(currentIndex, adjacentIndex));
                }


            }

            low[currentIndex] = Math.min(low[currentIndex], low[adjacentIndex]);
        }
    }

    private List<Integer>[] getAdjacencyList(List<List<Integer>> edges, int n) {
        List<Integer>[] adjacencyList = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (List<Integer> edge : edges) {
            int vertex1 = edge.get(0);
            int vertex2 = edge.get(1);

            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1);
        }

        return adjacencyList;
    }

    public static void main(String[] args) {

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1,0));
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(1,3));
        edges.add(Arrays.asList(0,2));

        ArticulationPoint articulationPoint = new ArticulationPoint();
        List<Integer>[] adjacencyList = articulationPoint.getAdjacencyList(edges, 4);
        articulationPoint.findArticulationPoint(adjacencyList);

        System.out.println(articulationPoint.result);
    }

}
