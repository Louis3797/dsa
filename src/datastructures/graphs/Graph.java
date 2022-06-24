package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Generic Graph implementation by using adjacency list representation
 *
 * @param <T> Generic Type
 */
public class Graph<T extends Comparable<T>> {

    public class Edge {

        /**
         * Source Vertex of the Edge
         */
        T source;

        /**
         * Destination Vertex of the Edge
         */
        T destination;

        /**
         * Weight of the Edge
         */
        int weight;

        /**
         * Basic Constructor
         *
         * @param source      Source Vertex
         * @param destination Destination Vertex
         * @param weight      Weight of the Edge
         */
        public Edge(T source, T destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

    }

    /**
     * Stores Vertices and Edges
     */
    private final HashMap<T, List<Edge>> graph;
    private final boolean undirected;

    private int numberOfVertices;

    private int numberOfEdges;

    /**
     * Basic Constructor
     */
    public Graph(boolean undirected) {

        graph = new HashMap<>();

        this.undirected = undirected;

        this.numberOfVertices = 0;

        this.numberOfEdges = 0;
    }

    public void addVertex(T vertex) {

        // check if vertex is already present in graph
        if (this.graph.containsKey(vertex))
            throw new IllegalArgumentException("Vertex already exists");

        // add vertex
        this.graph.put(vertex, new LinkedList<>());
        this.numberOfVertices++;
    }

    /**
     * Removes Vertex and all edges to it from graph
     *
     * @param vertex Value of vertex we want to remove
     */
    public void removeVertex(T vertex) {

        // If vertex is not present
        if (!this.graph.containsKey(vertex))
            throw new IllegalArgumentException("Vertex does not exists");

        this.numberOfEdges -= (this.graph.get(vertex).size() * (this.undirected ? 2 : 1));

        // remove all connection to the vertex
        for (T v : this.graph.keySet()) {
            // remove all connections to removed vertex
            this.graph.get(v).removeIf((e) -> e.destination.equals(vertex));
        }

        this.graph.remove(vertex);
        this.numberOfVertices--;
    }

    /**
     * Adds Edge from one Vertex to another
     *
     * @param source      Start Vertex
     * @param destination Vertex we want to connect
     */
    public void addEdge(T source, T destination, int weight) {

        // If graph does not contain vertices, throw an error
        if (!this.graph.containsKey(source) || !this.graph.containsKey(destination))
            throw new IllegalArgumentException("Either one or both of the specified nodes are not present in the graph");


        if (adjacency(source, destination))
            throw new IllegalArgumentException("Edge exists already");

        Edge edge1 = new Edge(source, destination, weight);
        this.graph.get(source).add(edge1);

        if (this.undirected) {
            Edge edge2 = new Edge(destination, source, weight);
            this.graph.get(destination).add(edge2);
        }

        numberOfEdges += this.undirected ? 2 : 1;
    }

    /**
     * Removes edge from one Vertex to another
     *
     * @param source      Source Vertex
     * @param destination Destination Vertex
     */
    public void removeEdge(T source, T destination) {
        // If graph does not contain Vertex, throw an error
        if (!this.graph.containsKey(source) || !this.graph.containsKey(destination))
            throw new IllegalArgumentException("Either one or both of the specified nodes are not present in the graph");

        this.graph.get(source).removeIf((e) -> e.destination.equals(destination));

        if (this.undirected) {
            this.graph.get(destination).removeIf((e) -> e.destination.equals(source));
        }

        numberOfEdges -= this.undirected ? 2 : 1;
    }

    public boolean adjacency(T source, T destination) {

        if (!this.graph.containsKey(source) || !this.graph.containsKey(destination))
            throw new IllegalArgumentException("Vertex does not exist in graph");

        // check if edge between vertices exists
        for (Edge edge : this.graph.get(source)) {
            if (edge.destination.equals(destination))
                return true;
        }

        return false;
    }

    public List<T> neighbours(T vertex) {

        List<T> neighbours = new ArrayList<>();

        if (!this.graph.containsKey(vertex))
            throw new IllegalArgumentException("Vertex does not exist");

        for (Edge edge : this.graph.get(vertex)) {
            neighbours.add(edge.destination);
        }

        return neighbours;
    }

    /**
     * Prints Graph
     */
    public void print() {

        for (T v : this.graph.keySet()) {
            System.out.print(v + ": ");


            for (Edge e : this.graph.get(v)) {
                System.out.print("[" + e.source + ", " + e.destination + ", " + e.weight + "] ");
            }

            System.out.println();
        }

        System.out.println();
    }

    /* Getter Methods */

    public boolean isUndirected() {
        return undirected;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        System.out.println(graph.isUndirected());

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 3);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 4, 10);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);

        graph.print();


        System.out.println(graph.getNumberOfVertices() + ", " + graph.getNumberOfEdges());
        graph.removeEdge(1, 2);

        graph.print();


        System.out.println(graph.getNumberOfVertices() + ", " + graph.getNumberOfEdges());

        graph.removeVertex(4);

        graph.print();

        System.out.println(graph.getNumberOfVertices() + ", " + graph.getNumberOfEdges());

        System.out.println(graph.adjacency(2, 3));

        System.out.println(graph.neighbours(3).toString());
    }


}
