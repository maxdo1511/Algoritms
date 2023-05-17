package ru.hbb.algoritms.Tests;

import ru.hbb.algoritms.UtilClasses.Graphs.GraphType;
import ru.hbb.algoritms.UtilClasses.Graphs.LinkedAlgoritm;
import ru.hbb.algoritms.UtilClasses.Graphs.NearestNeighbor;
import ru.hbb.algoritms.UtilClasses.Graphs.Prima;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphsTest {

    public static void main(String[] args) {
        // Задание 1
        int [][] data = {
                {99999, 197, 2160, 1070, 2230, 1040},
                {197, 99999, 2230, 1140, 2300, 1110},
                {2160, 2230, 99999, 1150, 520, 1200},
                {1070, 140, 1150, 99999, 1340, 68},
                {2230, 2300, 520, 1340, 99999, 1380},
                {1040, 1110, 1200, 68, 1380, 99999}
        };
        Prima prima = new Prima(data);
        System.out.println(prima.getMinPath(3));
        /*for (int i = 0; i < 6; i++) {
            System.out.println(prima.getMinPath(i));
        }

         */
        // Задание 2
        data = new int[][]{
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0}
        };
        LinkedAlgoritm linkedAlgoritm = new LinkedAlgoritm(data, GraphType.adjacency);
        System.out.println(linkedAlgoritm.getLinkedValue());

        //Задание 3
        data = new int[][]{
                {0, 2, 0, 0, 0, 0, 0, 10},
                {2, 0, 4, 0, 0, 0, 0, 0},
                {0, 4, 0, 7, 0, 0, 0, 0},
                {0, 0, 7, 0, 8, 0, 0, 0},
                {0, 0, 0, 8, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 3, 0},
                {0, 0, 0, 0, 0, 3, 0, 6},
                {10, 0, 0, 0, 0, 0, 6, 0},
        };
        NearestNeighbor nearestNeighbor = new NearestNeighbor(data);
        System.out.println(nearestNeighbor.getPath());
    }

}
