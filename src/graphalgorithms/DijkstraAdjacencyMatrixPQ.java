package graphalgorithms;

import datastructures.graphs.AdjacencyMatrix;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraAdjacencyMatrixPQ {

    private int getMinDistance(int[] distance, boolean[] shortestPathTree) {

        // to store smallest distance
        int minimum = Integer.MAX_VALUE;

        // index of the vertex
        int vertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!shortestPathTree[i] && distance[i] <= minimum) {
                minimum = distance[i];
                vertex = i;
            }
        }

        return vertex;
    }

    public void dijkstra(AdjacencyMatrix graph, int startVertex) {

        // store the number of vetices in Graph
        int numberOfVertices = graph.size();


        int[] distance = new int[numberOfVertices];
        Integer[] prev = new Integer[numberOfVertices];
        Queue<Integer[]> pqueue = new PriorityQueue<>(numberOfVertices, (e1, e2) -> e1[1].compareTo(e2[1]));

        // initialize all distances with infinity = Integer.Max_Value
        Arrays.fill(distance, Integer.MAX_VALUE);

        // set start Vertex distance to 0, bc we start from this vertex so
        distance[startVertex] = 0;

        pqueue.add(new Integer[]{startVertex, 0});

        while (!pqueue.isEmpty()) {

            int vertex = pqueue.poll()[0];

            for (int v : graph.neighbours(vertex)) {

                int newDistance = distance[vertex] + graph.getGraph()[vertex][v];

                if (newDistance < distance[v]) {
                    distance[v] = newDistance;
                    prev[v] = vertex;
                    pqueue.add(new Integer[]{v, distance[v]});
                }
            }
        }

        System.out.println(Arrays.toString(prev));
        printShortestPath(startVertex, distance);
    }

    private void printShortestPath(int startVertex, int[] distance) {
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Source Vertex: " + startVertex + " to vertex " + i +
                    " distance: " + distance[i]);
        }
    }

    public static void main(String[] args) {

        DijkstraAdjacencyMatrixPQ dikstra = new DijkstraAdjacencyMatrixPQ();

        AdjacencyMatrix graph = new AdjacencyMatrix(8);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 8);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 4, 16);
        graph.addEdge(1, 5, 6);
        graph.addEdge(1, 6, 15);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 7);
        graph.addEdge(2, 6, 12);
        graph.addEdge(3, 4, 10);
        graph.addEdge(5, 6, 20);
        graph.addEdge(5, 7, 4);
        graph.addEdge(6, 7, 8);

        graph.print();

        System.out.println();

        dikstra.dijkstra(graph, 0);
    }
}