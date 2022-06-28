package graphalgorithms;

import datastructures.graphs.Graph;

public class DfsAdjacencyList {

    public void dfs(Graph<Integer> graph, int startVertex) {

        if (graph.getNumberOfVertices() == 0) {
            throw new IllegalArgumentException("Graph has no vetices");
        }

        boolean[] visited = new boolean[graph.getNumberOfVertices()];

        dfs(graph, startVertex, visited);
    }

    private void dfs(Graph<Integer> graph, int startVertex, boolean[] visited) {

        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for (int vertex : graph.neighbours(startVertex)) {
            if (!visited[vertex])
                dfs(graph, vertex, visited);

        }
    }

    public static void main(String[] args) {

        DfsAdjacencyList dfs = new DfsAdjacencyList();
        Graph<Integer> graph = new Graph<>(true);

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 1);

        dfs.dfs(graph, 0);
    }
}
