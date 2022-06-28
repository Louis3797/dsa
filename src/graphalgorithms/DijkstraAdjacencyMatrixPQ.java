package graphalgorithms;

import datastructures.graphs.AdjacencyMatrix;

import java.util.*;

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
        int numberOfVertices = graph.getGraph().length;


        int[] distance = new int[numberOfVertices];
        Integer[] prev = new Integer[numberOfVertices];
        Queue<Integer[]> pqueue = new PriorityQueue<>(graph.getGraph().length, (e1, e2) -> e1[1].compareTo(e2[1]));
        Set<Integer> settled = new HashSet<>();

        // initialize all distances with infinity = Integer.Max_Value
        Arrays.fill(distance, Integer.MAX_VALUE);

        // set start Vertex distance to 0, bc we start from this vertex so
        distance[startVertex] = 0;

        pqueue.add(new Integer[]{startVertex, 0});

        while (!pqueue.isEmpty()) {

            int vertex = pqueue.poll()[0];

            if (settled.contains(vertex))
                continue;

            settled.add(vertex);

            for (int v : graph.neighbours(vertex)) {

                if (settled.contains(v))
                    continue;

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

        AdjacencyMatrix graph = new AdjacencyMatrix(9);

        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 4, 3);

        graph.addEdge(1, 4, 5);
        graph.addEdge(1, 8, 15);

        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 6, 2);

        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 4);

        graph.addEdge(4, 5, 6);

        graph.addEdge(5, 7, 7);

        graph.addEdge(6, 7, 4);

        graph.addEdge(7, 8, 3);


        graph.print();

        System.out.println();

        dikstra.dijkstra(graph, 3);


    }
}