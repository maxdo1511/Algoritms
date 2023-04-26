package ru.hbb.algoritms.Tests;

import ru.hbb.algoritms.UtilClasses.Map.CustomHashMap;
import ru.hbb.algoritms.UtilClasses.Map.CustomMap;
import ru.hbb.algoritms.UtilClasses.Trees.Node;

import java.util.HashMap;

public class TreesTest {

    public static void main(String[] args) {
        CustomMap<String, Integer> map = new CustomHashMap<>(10);
        map.put("max", 1234);
        map.put("alesya", 11223344);
        map.put("kirill", 110011);
        map.put("katya", 10101010);
        map.put("igor" , 1554962);
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.remove("max");
        //System.out.println(map.get(2));
        map.remove("kirill");
        System.out.println(map.keySet());
        System.out.println(map.values());
        //System.out.println(map.get(2));
        //System.out.println(map.get(444));
    }

    private boolean RedAndBlack_1(Node node) {
        /*
        if (node.left != null) RedAndBlack_1(node.left);
        if (node.right != null) RedAndBlack_1(node.right);

         */
        return true;
    }

    private boolean RedAndBlack_2(Node node) {
        return true;
    }

    private boolean RedAndBlack_3(Node node) {
        return true;
    }

    private boolean RedAndBlack_4(Node node) {
        return true;
    }

    private boolean RedAndBlack_5(Node node) {
        return true;
    }

}
