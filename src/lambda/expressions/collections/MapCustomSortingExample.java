package lambda.expressions.collections;
/*
 *  Program to demonstrate customized sorting in TreeMap.
 */

import java.util.Comparator;
import java.util.TreeMap;

public class MapCustomSortingExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (value1, value2) -> -value1.compareTo(value2);
        TreeMap<Integer, String> tm = new TreeMap<>(comparator);
        tm.put(100,"Anshuman");
        tm.put(600,"Yuvraj");
        tm.put(300,"Sunny");
        tm.put(200,"Chintu");
        tm.put(700,"Amay");
        tm.put(400,"Shrivastava");
        System.out.println(tm);
    }
}
