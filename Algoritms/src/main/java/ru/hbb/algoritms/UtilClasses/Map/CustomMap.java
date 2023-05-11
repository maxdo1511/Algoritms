package ru.hbb.algoritms.UtilClasses.Map;

import java.util.List;
import java.util.Set;

public interface CustomMap<K, V> {

    void put(K key, V value);
    void remove(K key);
    V get(K key);
    int size();
    List<V> values();
    Set<K> keySet();
    boolean contains(K key);

}
