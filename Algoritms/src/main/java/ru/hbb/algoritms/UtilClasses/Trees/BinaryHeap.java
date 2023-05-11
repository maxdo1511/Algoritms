package ru.hbb.algoritms.UtilClasses.Trees;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryHeap implements Tree {

    private ArrayList<Integer> heap = new ArrayList<>();
    private int deep = 0;

    public BinaryHeap(int ... vales) {
        for (int i : vales) {
            add(i);
        }
    }

    @Override
    public void add(int item) {
        ArrayList<Integer> clone = (ArrayList<Integer>) heap.clone();
        clone.add(item);
        rebuild(clone);
    }

    @Override
    public void delete(int item) {
        ArrayList<Integer> clone = (ArrayList<Integer>) heap.clone();
        clone.remove(item);
        rebuild(clone);
    }

    @Override
    public boolean contains(int item) {
        return heap.contains(item);
    }

    @Override
    public void print() {
        System.out.println("min: " + heap.toString());
        ArrayList<Integer> max_list = (ArrayList<Integer>) heap.clone();
        Collections.reverse(max_list);
        System.out.println("max: " + max_list.toString());
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int getDeep() {
        return deep;
    }

    private void rebuild(ArrayList<Integer> new_heap) {
        heap.clear();
        for (int j = 0; j < new_heap.size(); j++) {
            heap.add(-1);
        }
        Collections.sort(new_heap);
        int i = 0;
        heap.set(0, new_heap.get(i));
        // может возникать ошибка из-за удаления не по индексу
        int removed = new_heap.remove(i);
        int root = 0;
        int branch = 1;
        while (new_heap.size() > 0) {
            heap.set(root * 2 + branch, new_heap.get(i));
            removed = new_heap.remove(i);
            root = branch == 2 ? root + 1 : root;
            branch = addBranch(branch);
        }
    }

    private int addBranch(int cur) {
        return cur == 2 ? 1 : 2;
    }
}
