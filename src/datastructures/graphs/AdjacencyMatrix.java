package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Undirected weighted graph implementation by using adjacency matrix representation
 */
public class AdjacencyMatrix {

    /**
     * no edge constant
     */
    private static final int NO_EDGE = 0;
    /**
     * Stores the number of vertices
     */
    private final int numberOfVertices;

    /**
     * Stores the number of edges
     */
    private int numOfEdges = 0;

    /**
     * Represents the graph
     */
    private int[][] graph;

    public AdjacencyMatrix(int v) {

        this.numberOfVertices = v;
        this.graph = new int[v][v];

        for (int i = 0; i < this.numberOfVertices; i++) {
            for (int j = 0; j < this.numberOfVertices; j++) {
                this.graph[i][j] = 0;
            }
        }
    }

    /**
     * Adds new weighted Edge between two given Vertices
     *
     * @param source      Source Vertex
     * @param destination Destination Vertex
     * @param weight      weight of the Edge
     * @return true if the edge was added successfully
     */
    public boolean addEdge(int source, int destination, int weight) {

        if (!checkVertex(source) || !checkVertex(destination))
            throw new IndexOutOfBoundsException();

        if (adjancent(source, destination)) {
            throw new IllegalArgumentException("Edge already exists");
        }

        this.graph[source][destination] = weight;
        this.graph[destination][source] = weight;
        this.numOfEdges++;

        return true;
    }

    /**
     * Updated Weight of existing Edge
     *
     * @param source      Source Vertex
     * @param destination Destination Vertex
     * @param weight      new Weight
     * @return Returns true if weight was updated successfully
     */
    public boolean updateWeightOfEdge(int source, int destination, int weight) {

        if (!adjancent(source, destination)) {
            throw new IllegalArgumentException("Edge does not exist");
        }

        this.graph[source][destination] = weight;
        this.graph[destination][source] = weight;

        return true;
    }

    public boolean removeEdge(int source, int destination) {

        if (!adjancent(source, destination)) {
            throw new IllegalArgumentException("Edge does not exist");
        }

        this.graph[source][destination] = NO_EDGE;
        this.graph[destination][source] = NO_EDGE;
        this.numOfEdges--;

        return true;
    }

    /**
     * Checks if Edge between two given vertices exists already
     *
     * @param source      Source vertex
     * @param destination Destination Vertex
     * @return Returns true if Vertex already exists
     */
    public boolean adjancent(int source, int destination) {
        return checkVertex(source) && checkVertex(destination) && this.graph[source][destination] != NO_EDGE;
    }

    /**
     * Lists all vertices where there is an edge from the vertex to the given vertex
     *
     * @param vertex Given Vertex
     * @return Returns a List with all vertices
     */
    public List<Integer> neighbours(int vertex) {

        List<Integer> neighbours = new ArrayList<>();

        if (!checkVertex(vertex)) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < this.numberOfVertices; i++) {

            if (this.graph[vertex][i] != NO_EDGE)
                neighbours.add(i);
        }

        return neighbours;
    }

    /**
     * Check if given Vertex is in graph
     *
     * @param v given Vertex
     * @return return true if Vertex exists, otherwise false
     */
    public boolean checkVertex(int v) {
        return v >= 0 && v < this.numberOfVertices;
    }

    public void print() {

        for (int i = 0; i < this.numberOfVertices; i++) {
            for (int j = 0; j < this.numberOfVertices; j++) {

                System.out.print(this.graph[i][j] + "\t");

            }
            System.out.println();
        }
    }

    /* Getter and Setter Methods */

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void setNumOfEdges(int numOfEdges) {
        this.numOfEdges = numOfEdges;
    }

    public int[][] getGraph() {
        return graph;
    }

    public static void main(String[] args) {
        AdjacencyMatrix m = new AdjacencyMatrix(8);

        m.addEdge(1, 4, 5);
        m.addEdge(3, 4, 10);
        m.addEdge(0, 1, 2);
        m.addEdge(2, 1, 6);
        m.addEdge(0, 2, 20);
        m.print();

        System.out.println();

        System.out.println(m.neighbours(1).toString());

        System.out.println();

        m.removeEdge(0, 1);

        m.print();
    }
}
