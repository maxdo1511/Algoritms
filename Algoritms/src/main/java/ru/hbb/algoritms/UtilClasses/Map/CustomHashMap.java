package ru.hbb.algoritms.UtilClasses.Map;

import java.util.*;

public class CustomHashMap<K, V> implements CustomMap<K, V> {

    private int HASH_SIZE = 0;
    private int size = 0;
    private ArrayList<Node> table = new ArrayList<>();

    public CustomHashMap(int hash_size) {
        HASH_SIZE = hash_size;
        for (int i = 0; i < HASH_SIZE; i++) {
            table.add(null);
        }
    }

    private class Node {

        V value;
        K real_key;
        Node next = null;
        int hash;

        public Node(K real_key, V value, int hash) {
            this.value = value;
            this.real_key = real_key;
            this.hash = hash;
        }
    }

    @Override
    public void put(K key, V value) {
        int key_place = getKeyInHash(key);
        if (table.get(key_place) == null) {
            table.set(key_place, new Node(key, value, key_place));
        } else {
            if (table.get(key_place).real_key.equals(key)) {
                table.set(key_place, new Node(key, value, key_place));
                return;
            }
            Node source = table.get(key_place);
            while (source.next != null) {
                source = source.next;
            }
            Node node = new Node(key, value, key_place);
            source.next = node;
            table.add(node);
        }
        size++;
    }

    @Override
    public void remove(K key) {
        int key_place = getKeyInHash(key);
        Node node = table.get(key_place);
        if (node == null) {
            return;
        }
        if (node.next == null) {
            table.set(node.hash, null);
            size--;
            return;
        }
        if (node.real_key.equals(key)) {
            table.remove(node.next);
            table.set(node.hash, node.next);
            size--;
            return;
        }
        while (!node.next.real_key.equals(key)) {
            node = node.next;
            if (node.next == null) {
                return;
            }
        }
        if (node.next.next != null) {
            table.remove(node.next);
            node.next = node.next.next;
            size--;
        }
    }

    @Override
    public V get(K key) {
        int key_place = getKeyInHash(key);
        Node node = table.get(key_place);
        while (node != null) {
            if (node.real_key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<V> values() {
        List<V> list = new ArrayList<>();
        for (Node node : table) {
            if (node != null) {
                list.add(node.value);
            }
        }
        return list;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Node node : table) {
            if (node != null) {
                set.add(node.real_key);
            }
        }
        return set;
    }

    private int getKeyInHash(K key) {
        return Math.abs(hash(key) % HASH_SIZE);
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
