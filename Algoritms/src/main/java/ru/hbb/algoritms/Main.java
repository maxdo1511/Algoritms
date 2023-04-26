package ru.hbb.algoritms;

import ru.hbb.algoritms.UtilClasses.Trees.BinaryTree;
import ru.hbb.algoritms.UtilClasses.Trees.Tree;

public class Main {
    public static void main(String[] args) {
        Tree binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(12);
        binaryTree.add(9);
        binaryTree.add(8);
        binaryTree.add(15);
        System.out.println(binaryTree.isEmpty());
        binaryTree.print();
        binaryTree.delete(9);
        binaryTree.print();
        System.out.println(binaryTree.contains(15));
        System.out.println(binaryTree.getDeep());
    }
}