package sorting;

import datastructures.graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSortDfs {

    public void topologicalSortDfs(Graph<Integer> graph) {
        int len = graph.getNumberOfVertices();

        List<Integer> list = new ArrayList<>(len);
        boolean[] visited = new boolean[len];

        // visit all vertexes in graph
        for (int u : graph.getGraph().keySet()) {
            if (!visited[u])
                topologigalSort(graph, u, visited, list);

        }

        // print result
        for (int i : list)
            System.out.print(i + " ");

    }

    public void topologigalSort(Graph<Integer> graph, int vertex, boolean[] visited, List<Integer> list) {

        // mark vertex as visited
        visited[vertex] = true;

        for (int v : graph.neighbours(vertex)) {

            // visit all unvisited neighbours
            if (!visited[v])
                topologigalSort(graph, v, visited, list);

        }

        // add vertex to the front
        list.add(0, vertex);
    }

    public static void main(String[] args) {

        TopologicalSortDfs sort = new TopologicalSortDfs();
        Graph<Integer> graph = new Graph<>(false);

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 4, 1);

        graph.print();

        sort.topologicalSortDfs(graph);
    }
}
