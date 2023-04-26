package ru.hbb.algoritms.UtilClasses.Trees;


public class BinaryTree implements Tree {

    Node root;

    public BinaryTree() {

    }

    public void add(int value) {
        root = addRecursive(root, value, root == null ? TreeColor.RED : root.color);
    }

    private Node addRecursive(Node current, int value, TreeColor color) {

        if (current == null) {
            return new Node(value, TreeColor.getNext(color));
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value, current.color);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value, current.color);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getDeep() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean contains(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            //
            int largestValue = findLargestValue(current.left);
            current.value = largestValue;
            current.left = deleteRecursive(current.left, largestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findLargestValue(Node root) {
        return root.right == null ? root.value : findLargestValue(root.right);
    }

    public void print() {
        traverseInOrder(root);
        System.out.println();
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.value);
            traverseInOrder(node.right);
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }
}
