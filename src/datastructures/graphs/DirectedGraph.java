package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a directed unweighted graph using the adjacency list representation
 * We use an ArrayList to store the vertices of the Graph and the adjacent vertices of each Vertex
 *
 * @param <T> Generic Type
 */
public class DirectedGraph<T extends Comparable<T>> {

    /**
     * Stores vertices in Graph
     */
    List<Vertex> vertices;

    public DirectedGraph() {
        vertices = new ArrayList<>();
    }

    /**
     * Inner class for Vertex
     */
    class Vertex {

        T value;
        List<Vertex> adjacentVertices;

        public Vertex(T value) {
            adjacentVertices = new ArrayList<>();
            this.value = value;
        }

        public boolean addAjacentVertex(Vertex to) {

            // check if edge already exists
            for (Vertex v : adjacentVertices) {
                if (v.value.equals(to.value)) {
                    return false;
                }
            }

            // if edge doesn't exist, then we can add it
            return adjacentVertices.add(to);
        }

        public boolean removeAdjacentVertex(T to) {

            // check if edge is present, if yes then remove it
            for (int i = 0; i < adjacentVertices.size(); i++) {
                if (adjacentVertices.get(i).value.equals(to)) {
                    adjacentVertices.remove(i);
                    return true;
                }
            }

            // return false if edge doesnt exist
            return false;
        }

    }

    public boolean addEdge(T from, T to) {

        Vertex fromVertex = null, toVertex = null;

        for (Vertex v : this.vertices) {

            // check if from Vertex already exists
            if (v.value.equals(from))
                fromVertex = v;

            // check if to Vertex already exists
            if (v.value.equals(to)) {
                toVertex = v;
            }

            // if both are found break out of the loop
            if (fromVertex != null && toVertex != null)
                break;
        }

        if (fromVertex == null) {
            fromVertex = new Vertex(from);
            this.vertices.add(fromVertex);
        }

        if (toVertex == null) {
            toVertex = new Vertex(to);
            this.vertices.add(toVertex);
        }

        return fromVertex.addAjacentVertex(toVertex);
    }

    public boolean removeEdge(T from, T to) {
        Vertex fromVertex = null;

        // check if from Vertex exists
        for (Vertex v : vertices) {
            if (v.value.equals(from))
                fromVertex = v;

            // if both are found break out of the loop
            if (fromVertex != null)
                break;
        }

        // return false if from Vertex or to Vertex does not exist, then return true
        if (fromVertex == null)
            return false;

        return fromVertex.removeAdjacentVertex(to);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for (Vertex vertex : vertices) {
            builder.append("Vertex: ");
            builder.append(vertex.value);
            builder.append("\n");
            builder.append("Adjacent vertices: ");
            for (Vertex vertex2 : vertex.adjacentVertices) {
                builder.append(vertex2.value);
                builder.append(" ");
            }
            builder.append("\n\n");
        }

        System.out.println(builder);
    }

    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>();

        graph.addEdge("Köln", "Bielefeld");
        graph.addEdge("Köln", "Herford");
        graph.addEdge("Köln", "Hannover");
        graph.addEdge("Köln", "Berlin");
        graph.addEdge("Berlin", "Mannheim");
        graph.addEdge("Herford", "Mannheim");
        graph.addEdge("Berlin", "Buxtehude");
        graph.addEdge("Hannover", "Buxtehude");
        graph.addEdge("Hamburg", "Buxtehude");

        graph.print();
    }
}
