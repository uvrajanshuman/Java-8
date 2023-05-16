package lambda_expressions.custom_sorting;

/*
 *  Program to demonstrate Customized Sorting Order(Descending order) for TreeSet.
 */

import java.util.Comparator;
import java.util.TreeSet;

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
public class SetCustomSortingExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (value1, value2) -> -value1.compareTo(value2);
        TreeSet<Integer> ts = new TreeSet<>(comparator); //sorted based on passed comparator
        ts.add(10);
        ts.add(0);
        ts.add(15);
        ts.add(25);
        ts.add(5);
        ts.add(20);
        System.out.println(ts);
    }
}

/*
 *  Output:
 *  [25, 20, 15, 10, 5, 0]
 */