package ru.hbb.algoritms;

import ru.hbb.algoritms.UtilClasses.Tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10, "10");
        tree.add(5, "5");
        tree.add(3, "3");
        tree.add(7, "7");
        tree.add(11, "11");
        tree.add(12, "12");
        tree.add(10, "10");
        tree.print();
        tree.remove(5);
        tree.print();
    }
}