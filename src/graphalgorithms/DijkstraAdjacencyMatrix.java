package graphalgorithms;

import datastructures.graphs.AdjacencyMatrix;

public class Dijkstra {

    private int minDistance(int dist[], boolean[] shortestpath){

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        AdjacencyMatrix graph = new AdjacencyMatrix(8);

        graph.addEdge(0,1, 2);
        graph.addEdge(0,2, 10);
        graph.addEdge(0,3, 5);
        graph.addEdge(0,4, 8);
        graph.addEdge(1,2, 8);
        graph.addEdge(1,4, 16);
        graph.addEdge(1,5, 6);
        graph.addEdge(1,6, 15);
        graph.addEdge(2,3, 4);
        graph.addEdge(2,4, 7);
        graph.addEdge(2,6, 12);
        graph.addEdge(3,4, 10);
        graph.addEdge(5,6, 20);
        graph.addEdge(5,7, 4);
        graph.addEdge(6,7, 8);

        graph.print();



    }
}
