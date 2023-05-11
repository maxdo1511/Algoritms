package ru.hbb.algoritms.Tests;

import ru.hbb.algoritms.UtilClasses.Trees.BinaryHeap;
import ru.hbb.algoritms.UtilClasses.Trees.Tree;

public class HeapTest {

    public static void main(String[] args) {
        Tree heap = new BinaryHeap();
        heap.add(10);
        heap.add(16);
        heap.add(14);
        heap.add(8);
        heap.add(7);
        heap.add(9);
        heap.add(3);
        heap.add(2);
        heap.add(4);
        heap.add(1);
        heap.print();
    }

}
