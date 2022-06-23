package datastructures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Undirected weighted graph implementation by using adjacency list representation
 *
 * @param <T> Generic Type
 */
public class UndirectedWeightedGraph<T extends Comparable<T>> {

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
    private HashMap<T, Set<Edge>> graph;

    /**
     * Basic Constructor
     */
    public UndirectedWeightedGraph() {
        graph = new HashMap<>();
    }

    public boolean addVertex(T vertex) {

        // check if vertex is already present in graph
        if (this.graph.containsKey(vertex))
            throw new IllegalArgumentException("Vertex already exists");

        // add vertex
        this.graph.put(vertex, new HashSet<>());

        return true;
    }

    /**
     * Removes Vertex and all edges to it from graph
     *
     * @param vertex Value of vertex we want to remove
     * @return return true if successfully
     */
    public boolean removeVertex(T vertex) {

        // If vertex is not present
        if (!this.graph.containsKey(vertex))
            throw new IllegalArgumentException("Vertex does not exists");

        // remove all connection to the vertex
        for (T v : this.graph.keySet()) {
            // remove all connections to removed vertex

            this.graph.get(v).stream().filter((e) -> e.destination.equals(vertex));
        }

        this.graph.remove(vertex);

        return true;
    }

    /**
     * Adds Edge from one Vertex to another
     *
     * @param source      Start Vertex
     * @param destination Vertex we want to connect
     * @return Return true if edge was not already present
     */
    public boolean addEdge(T source, T destination, int weight) {

        // If graph does not contain vertices, throw an error
        if (!this.graph.containsKey(source) || !this.graph.containsKey(destination))
            throw new IllegalArgumentException("Either one or both of the specified nodes are not present in the graph");

        // returns true if edge was not already present
        Edge edge1 = new Edge(source, destination, weight);
        Edge edge2 = new Edge(destination, source, weight);

        return this.graph.get(source).add(edge1) && this.graph.get(destination).add(edge2);

    }

    /**
     * Removes edge from one Vertex to another
     *
     * @param source      Source Vertex
     * @param destination Destination Vertex
     * @return Returns true if edge is present
     */
    public boolean removeEdge(T source, T destination) {
        // If graph does not contain Vertex, throw an error
        if (!this.graph.containsKey(source) || !this.graph.containsKey(destination))
            throw new IllegalArgumentException("Either one or both of the specified nodes are not present in the graph");

        // returns true if edge was present

        this.graph.get(destination).stream().filter((edge -> edge.destination.equals(source)));

        return true;
    }

    /**
     * Prints Graph
     */
    public void print() {

        for (T v : this.graph.keySet()) {
            System.out.print(v + ": ");

            Set<Edge> set = this.graph.get(v);
            for (Edge e : set) {
                System.out.print("[" + e.source + ", " + e.destination + ", " + e.weight + "] ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();

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

        graph.removeEdge(1, 2);

        graph.print();

        graph.removeVertex(4);

        graph.print();
    }


}
