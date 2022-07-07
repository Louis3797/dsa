package graphalgorithms;

import datastructures.graphs.Graph;

import java.util.Arrays;

public class BellmanFordAdjacencyList {

    public void bellmanFord(Graph<Integer> graph, int startVertex) throws Exception {

        // store the number of vetices in Graph
        int numberOfVertices = graph.getNumberOfVertices();

        int[] distance = new int[numberOfVertices];

        // initialize all distances with infinity = Integer.Max_Value
        Arrays.fill(distance, Integer.MAX_VALUE);

        // set start Vertex distance to 0, bc we start from this vertex so
        distance[startVertex] = 0;

        // find distance to each vertex from the start vertex
        for (int v : graph.getGraph().keySet()) {

            for (Graph<Integer>.Edge e : graph.getGraph().get(v)) {

                int source = e.getSource();
                int destination = e.getDestination();
                int weight = e.getWeight();

                if (distance[source] != Integer.MAX_VALUE && weight + distance[source] < distance[destination]) {
                    distance[destination] = distance[source] + weight;
                }
            }
        }

        // check for negative weights cycles

        for (int v : graph.getGraph().keySet()) {

            for (Graph<Integer>.Edge e : graph.getGraph().get(v)) {

                int source = e.getSource();
                int destination = e.getDestination();
                int weight = e.getWeight();

                if (distance[source] != Integer.MAX_VALUE && weight + distance[source] < distance[destination]) {
                    throw new Exception("Graph contains negative weight cycle");
                }
            }
        }

        printShortestPath(startVertex, distance);
    }

    private void printShortestPath(int startVertex, int[] distance) {

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Source Vertex: " + startVertex + " to vertex " + i +
                    " distance: " + distance[i]);
        }
    }

    public static void main(String[] args) throws Exception {

        Graph<Integer> graph = new Graph<>(false);
        BellmanFordAdjacencyList bf = new BellmanFordAdjacencyList();

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 7);
        graph.addEdge(2, 0, -2);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 0, 4);
        graph.addEdge(3, 2, 1);

        bf.bellmanFord(graph, 0);

        System.out.println();
        for (int v : graph.getGraph().keySet()) {

            System.out.print(v + ": ");
            for (Graph<Integer>.Edge e : graph.getGraph().get(v)) {
                System.out.print(e.getDestination() + " ");
            }
            System.out.println();
        }


    }
}
