package lambda_expressions.custom_sorting;

/*
 *  Program to demonstrate Customized Sorting for TreeMap.
 */

import java.util.Comparator;
import java.util.TreeMap;

/*
 *   Comparator is a Functional interface with SAM compare()
 *   interface<T> Comparator{
 *       public int compare(T obj1, T obj2);
 *   }
 *   return -ve if obj1 has to come before obj2
 *   return +e if obj1 has to come after obj2
 *   return 0 if obj1 and obj2 are equal.
 *
 */
public class MapCustomSortingExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (value1, value2) -> value2 - value1;
        TreeMap<Integer, String> map = new TreeMap<>(comparator); //sorted based on passed comparator
        map.put(3, "Apple");
        map.put(1, "Orange");
        map.put(2, "Banana");
        System.out.println(map);
    }
}

/*
 * Output:
 * {3=Apple, 2=Banana, 1=Orange}
 */