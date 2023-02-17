package ru.hbb.algoritms.UtilClasses;

public class Tree {

    private Node root;


    private class Node {
        Item root;
        Node left;
        Node right;

        private class Item {
            int id;
            Object item;
            Node brunch;

            public Item(int id, Object item){
                this.id = id;
                this.item = item;
            }
        }

        public Node(int id, Object obj, Node left, Node right) {
            this.root = new Item(id, obj);
            this.left = left;
            this.right = right;
        }
    }

    public void add(int item, Object obj) {
        if (root == null) {
            root = new Node(item, obj, null, null);
            return;
        }
        Node node = root;
        while (true) {
            if (node.root.id > item) {
                // налево
                if (node.left == null) {
                    node.left = new Node(item, obj, null, null);
                    node.left.root.brunch = node;
                    return;
                }
                node = node.left;
            }else {
                if (node.root.id < item) {
                    if (node.right == null) {
                        node.right = new Node(item, obj, null, null);
                        node.right.root.brunch = node;
                        return;
                    }
                    node = node.right;
                }else {
                    return;
                }
            }
        }
    }

    public void remove(int item) {
        Node node = root;
        try {
            while (node != null) {
                if (node.root.id > item) {
                    if (node.left.root.id == item) {
                        Node mode = deleteTreeItem(node.left);
                        if (mode == null) {
                            node.left = null;
                            return;
                        }
                        node.left = mode;
                        return;
                    }
                    node = node.left;
                } else {
                    if (node.right.root.id == item) {
                        Node mode = deleteTreeItem(node.right);
                        if (mode == null) {
                            node.right = null;
                            return;
                        }
                        node.right = mode;
                        return;
                    }
                    node = node.right;
                }
            }
        }catch (NullPointerException ignored){

        }
    }

    public int getDeep() {
        return 0;
    }

    public void print() {
        int i = 0;
        Node node = root;
        System.out.println(root.root.item);
        printItemsOfTree(node);
    }

    public Object get(int item) {
        Node node = root;
        try {
            while (node != null) {
                if (node.root.id > item) {
                    node = node.left;
                } else {
                    if (node.root.id < item) {
                        node = node.right;
                    }else {
                        return node.root.item;
                    }
                }
            }
        }catch (NullPointerException ignored){
            return null;
        }
        return null;
    }

    private Node deleteTreeItem(Node item) {
        Node node = getMaxItemInRoot(item);
        if (node.equals(item)) {
            return null;
        }
        return node;
    }

    private Node getMaxItemInRoot(Node root) {
        while (root != null) {
            if (root.right == null) {
                return root;
            }
            root = root.right;
        }
        return null;
    }

    private void printItemsOfTree(Node root) {
        if (root.left != null) {
            System.out.print(root.left.root.item + " ");
            printItemsOfTree(root.left);
        }
        if (root.right != null) {
            System.out.print(root.right.root.item + " ");
            printItemsOfTree(root.right);
        }
        System.out.println(" ");
    }

}
