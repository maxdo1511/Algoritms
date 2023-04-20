package ru.hbb.algoritms.UtilClasses;

public interface Tree {

    void add(int value);
    void delete(int item);
    boolean contains(int item);
    void print();
    boolean isEmpty();
    int getDeep();

}
