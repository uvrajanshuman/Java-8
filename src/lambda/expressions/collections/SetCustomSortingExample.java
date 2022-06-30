package lambda.expressions.collections;

import java.util.Comparator;
import java.util.TreeSet;
/*
 *  Program to demonstrate Customized Sorting Order(Descending order) for TreeSet.
 */

public class SetCustomSortingExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (value1, value2) -> -value1.compareTo(value2);
        TreeSet<Integer> ts = new TreeSet<>(comparator);
        ts.add(10);
        ts.add(0);
        ts.add(15);
        ts.add(25);
        ts.add(5);
        ts.add(20);
        System.out.println(ts);
    }
}
