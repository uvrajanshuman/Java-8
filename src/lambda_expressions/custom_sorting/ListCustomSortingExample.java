package lambda_expressions.custom_sorting;

/*
 * Program to sort List in custom order.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *   Comparator is a Functional interface with SAM compare()
 *   interface<T> Comparator{
 *       public int compare(T obj1, T obj2);
 *   }
 *   return -ve if obj1 has to come before obj2
 *   return +ve if obj1 has to come after obj2
 *   return 0 if obj1 and obj2 are equal.
 *
 */
public class ListCustomSortingExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,0,1,5,20);
        System.out.println("Before sorting: "+list);
        //sorting in default natural order (ascending order)
        //Collections.sort(list);

        //sorting in custom order (descending order)
        Comparator<Integer> comparator = (value1, value2) -> value2 - value1;
        Collections.sort(list,comparator);
        System.out.println("After sorting: "+list);
    }
}

/*
 *  Output:
 *  Before Sorting: [10, 0, 15, 5, 20]
 *  After Sorting: [20, 15, 10, 5, 0]
 */
