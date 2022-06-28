package graphalgorithms;

import datastructures.graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BfsAdjacencyList {

    public void bfs(Graph<Integer> graph, int startVertex) {

        int len = graph.getNumberOfVertices();

        boolean visited[] = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            System.out.println(vertex + " ");

            for (Graph<Integer>.Edge e : graph.getGraph().get(vertex)) {

                int destination = e.getDestination();

                if (!visited[destination]) {
                    visited[destination] = true;
                    queue.add(destination);
                }
            }
        }
    }

    public static void main(String[] args) {

        BfsAdjacencyList bfs = new BfsAdjacencyList();
        Graph<Integer> graph = new Graph<>(false);

        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 0, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 3, 1);

        graph.print();
        System.out.println();
        bfs.bfs(graph, 2);
    }

}
