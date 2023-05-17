package ru.hbb.algoritms.UtilClasses.Graphs;

import java.util.ArrayList;

public class NearestNeighbor {

    private final int[][] graph;

    public NearestNeighbor(int[][] graph) {
        this.graph = graph;
    }

    public ArrayList<Integer> getPath() {
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            points.add(i);
        }
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> path = new ArrayList<>();
            int line = i;
            path.add(line);
            while (!path.containsAll(points)) {
                for (int j = 0; j < graph[line].length; j++) {
                    int min_index = getMinNotContains(j, graph[line], path);
                    // нет кольца
                    if (min_index == j) {
                        break;
                    }
                    //
                    path.add(min_index);
                    line = min_index;
                }
            }
            if (path.containsAll(points)) {
                return path;
            }
        }
        throw new RuntimeException("error!");
    }

    private void addPointRecursive(ArrayList<Integer> path, int point) {
        if (path.contains(point)) {
            return;
        }
    }

    private int getMinNotContains(int from, int[] graph, ArrayList<Integer> attends) {
        int min = Integer.MAX_VALUE;
        int res = from;
        for (int i = 0; i < graph.length; i++) {
            if (i != from && !attends.contains(i) && graph[i] != 0) {
                if (graph[i] < min) {
                    res = i;
                    min = graph[i];
                }
            }
        }
        return res;
    }

}
