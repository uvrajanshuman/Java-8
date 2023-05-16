package predefined_functional_interfaces.bi_functional_interfaces.bifunction;

/*
 *  Example demonstrating use of BiFunction and BiFunction chaining
 */

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
        Function<Integer, Integer> addTen = x -> x + 10;

        BiFunction<Integer, Integer, Integer> combinedFunction = multiply.andThen(addTen);

        int x = 5;
        int y = 10;
        System.out.printf("Multiplication of %d and %d : %d\n",x,y,multiply.apply(x,y));
        System.out.printf("Increment %d by 10 : %d\n",x,addTen.apply(x));

        System.out.printf("Multiplication of %d and %d and then increment the result by 10: %d\n", x,y, combinedFunction.apply(x, y));
    }
}

/*
 * Output:
 * Multiplication of 5 and 10 : 50
 * Increment 5 by 10 : 15
 * Multiplication of 5 and 10 and then increment the result by 10: 60
 */