package ru.hbb.algoritms.UtilClasses.Trees;

public enum TreeColor {

    RED,
    BLACK;

    public static TreeColor getNext(TreeColor color) {
        return color == RED ? BLACK : RED;
    }

}
