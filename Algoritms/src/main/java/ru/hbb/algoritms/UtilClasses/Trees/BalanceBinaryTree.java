package ru.hbb.algoritms.UtilClasses.Trees;

public class BalanceBinaryTree extends BinaryTree implements Tree{

    @Override
    public void add(int value) {
        super.add(value);
        reBalance(super.root);
    }

    @Override
    public void delete(int value) {
        super.delete(value);
        reBalance(super.root);
    }

    /*
    Перестройка
     */

    private void updateBalance(Node node) {
        node.balance = 1 + Math.max(balance(node.right), balance(node.left));
    }

    private int balance(Node node) {
        return node == null ? -1 : node.balance;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : balance(node.right) - balance(node.left);
    }

    private Node rotateRight(Node root) {
        Node left = root.left;
        Node right = left.right;
        left.right = root;
        root.left = right;
        updateBalance(root);
        updateBalance(left);
        return left;
    }

    private Node rotateLeft(Node root) {
        Node right = root.right;
        Node left = right.left;
        right.left = root;
        root.right = left;
        updateBalance(root);
        updateBalance(right);
        return right;
    }

    private Node reBalance(Node root) {
        updateBalance(root);
        int balance = getBalance(root);
        if (balance > 1) {
            if (balance(root.right.right) <= balance(root.right.left)) {
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);
        } else if (balance < -1) {
            if (balance(root.left.left) <= balance(root.left.right)) {
                root.left = rotateLeft(root.left);
            }
            root = rotateRight(root);
        }
        return root;
    }

    //
}
