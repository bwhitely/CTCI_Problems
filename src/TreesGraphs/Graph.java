package TreesGraphs;

import java.util.*;

public class Graph {
    static class gNode{
        int value, weight;
        gNode(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }

    List<List<gNode>> adjList = new ArrayList<>();

    public Graph(List<Edge> edges){

    }
}
