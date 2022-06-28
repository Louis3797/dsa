package graphalgorithms;

import datastructures.graphs.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implementation only works with Integer Vertexes
 */
public class DijkstraAdjacencyListPQ {

    public void dijkstra(Graph<Integer> graph, int startVertex) {

        // store the number of vetices in Graph
        int numberOfVertices = graph.getNumberOfVertices();


        int[] distance = new int[numberOfVertices];
        Integer[] prev = new Integer[numberOfVertices];
        Queue<Integer[]> queue = new PriorityQueue<>(numberOfVertices, Comparator.comparing(e -> e[1]));

        // initialize all distances with infinity = Integer.Max_Value
        Arrays.fill(distance, Integer.MAX_VALUE);

        // set start Vertex distance to 0, bc we start from this vertex so
        distance[startVertex] = 0;

        queue.add(new Integer[]{startVertex, 0});

        while (!queue.isEmpty()) {

            int vertex = queue.poll()[0];

            for (Graph<Integer>.Edge e : graph.getGraph().get(vertex)) {

                int v = e.getDestination();

                int newDistance = distance[vertex] + e.getWeight();

                // compare distances
                if (newDistance < distance[v]) {
                    distance[v] = newDistance;
                    prev[v] = vertex;
                    // Add the current vertex to the PriorityQueue
                    queue.add(new Integer[]{v, distance[v]});
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

        DijkstraAdjacencyListPQ dikstra = new DijkstraAdjacencyListPQ();

        Graph<Integer> graph = new Graph<>(true);

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);

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
