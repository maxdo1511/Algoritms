package ru.hbb.algoritms.UtilClasses.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedAlgoritm {

    private final int[][] graph;
    private final GraphType type;

    public LinkedAlgoritm(int[][] graph, GraphType type) {
        this.graph = graph;
        this.type = type;
    }

    public int getLinkedValue() {
        if (type == GraphType.adjacency) {
            return getAdjacencyGraphLinkedValue();
        }
        if (type == GraphType.incidents) {
            return getIncidentsGraphLinkedValue();
        }
        throw new RuntimeException("no method for this type");
    }

    private int getAdjacencyGraphLinkedValue() {
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            points.add(i);
        }
        //
        int res = 0;
        while (points.size() > 0) {
            int point = points.get(0);
            removePointsRecursive(points, point);
            res++;
        }
        return res;
    }

    private int getIncidentsGraphLinkedValue() {
        return 0;
    }

    private void removePointsRecursive(ArrayList<Integer> points, int line) {
        if (!points.contains(line)) {
            return;
        }
        points.remove((Integer) line);
        for (int i = 0; i < graph[line].length; i++) {
            if (graph[line][i] == 1) {
                removePointsRecursive(points, i);
            }
        }
    }

}
