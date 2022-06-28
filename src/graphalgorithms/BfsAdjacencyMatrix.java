package graphalgorithms;

import datastructures.graphs.AdjacencyMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class BfsAdjacencyMatrix {

    public void bfs(AdjacencyMatrix graph, int startVertex) {

        int len = graph.size();

        boolean visited[] = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            System.out.println(vertex + " ");

            for (int v : graph.neighbours(vertex)) {

                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {

        BfsAdjacencyMatrix bfs = new BfsAdjacencyMatrix();
        AdjacencyMatrix graph = new AdjacencyMatrix(4);

        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 3, 1);

        graph.print();
        System.out.println();
        bfs.bfs(graph, 2);
    }
}
