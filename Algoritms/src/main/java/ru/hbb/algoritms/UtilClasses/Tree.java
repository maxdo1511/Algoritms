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
                    return;
                }
                node = node.left;
            }else {
                if (node.root.id < item) {
                    if (node.right == null) {
                        node.right = new Node(item, obj, null, null);
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
                        node.left = null;
                        return;
                    }
                    node = node.left;
                } else {
                    if (node.right.root.id == item) {
                        node.right = null;
                        return;
                    }
                    node = node.right;
                }
            }
        }catch (NullPointerException ignored){

        }
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

}
