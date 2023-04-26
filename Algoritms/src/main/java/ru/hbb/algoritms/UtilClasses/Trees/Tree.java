package ru.hbb.algoritms.UtilClasses.Trees;

public interface Tree {

    void add(int value);
    void delete(int item);
    boolean contains(int item);
    void print();
    boolean isEmpty();
    int getDeep();

}
