package ru.hbb.algoritms.UtilClasses.Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class Prima {
    /*

    private final ArrayList<ArrayList<GraphPoint>> graph;

    public Prima(ArrayList<ArrayList<GraphPoint>> graph) {
        this.graph = graph;
    }

    public int getMinPath() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph.size(); i++) {
            int loc_res = 0;
            ArrayList<Integer> attends = new ArrayList<>();
            while ()
        }
    }

     */

    private final int[][] graph;

    public Prima(int[][] graph) {
        this.graph = graph;
    }

    public int getMinPath() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            int loc_res = 0;
            int cur = i;
            ArrayList<Integer> attends = new ArrayList<>();
            while (attends.size() < graph.length) {
                int next_index = getMinNotContains(cur, graph[cur], attends);
                attends.add(next_index);
                loc_res += graph[cur][next_index];
                cur = next_index;
            }
            min = Math.min(loc_res, min);
        }
        return min;
    }

    public int getMinPath(int pos) {
        int min = 0;
        int cur = pos;
        ArrayList<Integer> attends = new ArrayList<>();
        while (attends.size() < graph.length) {
            int next_index = getMinNotContains(cur, graph[cur], attends);
            attends.add(next_index);
            min += graph[cur][next_index];
            cur = next_index;
        }
        return min;
    }

    private int getMinNotContains(int from, int[] graph, ArrayList<Integer> attends) {
        int min = Integer.MAX_VALUE;
        int res = from;
        for (int i = 0; i < graph.length; i++) {
            if (i != from && !attends.contains(i)) {
                if (graph[i] < min) {
                    res = i;
                    min = graph[i];
                }
            }
        }
        return res;
    }

}
