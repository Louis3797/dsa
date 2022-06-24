package graphalgorithms;

import datastructures.graphs.AdjacencyMatrix;

public class DfsAdjacencyMatrix {

    public void dfs(AdjacencyMatrix graph, int startVertex) {

        if (graph.getGraph().length == 0) {
            throw new IllegalArgumentException("Graph has no vetices");
        }

        boolean[] visited = new boolean[graph.getGraph().length];

        dfs(graph, startVertex, visited);
    }

    private void dfs(AdjacencyMatrix graph, int startVertex, boolean[] visited) {

        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for (int vertex : graph.neighbours(startVertex)) {
            if (!visited[vertex])
                dfs(graph, vertex, visited);

        }
    }

    public static void main(String[] args) {

        DfsAdjacencyMatrix dfs = new DfsAdjacencyMatrix();
        AdjacencyMatrix graph = new AdjacencyMatrix(10);

        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(0,9,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.addEdge(1,5,1);
        graph.addEdge(3,4,1);
        graph.addEdge(3,5,1);
        graph.addEdge(3,6,1);
        graph.addEdge(4,2,1);
        graph.addEdge(4,5,1);
        graph.addEdge(4,7,1);
        graph.addEdge(4,8,1);
        graph.addEdge(4,9,1);
        graph.addEdge(7,1,1);
        graph.addEdge(8,9,1);
        graph.addEdge(8,1,1);
        graph.addEdge(9,1,1);
        graph.addEdge(9,3,1);

        graph.print();
        System.out.println();
        dfs.dfs(graph, 0);
    }
}
