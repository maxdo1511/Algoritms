package ru.hbb.algoritms.UtilClasses.Trees;

public class Node {
    public int value, key, balance;
    public Node left;
    public Node right;
    public TreeColor color;

    Node(int value, TreeColor color) {
        this.value = value;
        right = null;
        left = null;
        this.color = color;
    }

}
