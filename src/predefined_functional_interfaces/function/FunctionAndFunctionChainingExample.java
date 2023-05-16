package predefined_functional_interfaces.function;

/*
 *  Example demonstrating use of Function and Function Chaining.
 */

import java.util.function.Function;

public class FunctionAndFunctionChainingExample {
    //Function to find square of a number
    static Function<Integer, Integer> squareFn = i -> i*i;
    //Function to divide a number into half
    static Function<Integer, Integer> divFn = i -> i/2;

    public static void main(String[] args) {
        System.out.printf("Squaring 2: %d\n", squareFn.apply(2)); //4
        System.out.printf("Halving 2: %d\n", divFn.apply(2)); //1

        //andThen()
        System.out.printf("Squaring 2 then Halving the result: %d\n",squareFn.andThen(divFn).apply(2)); //2
        //compose()
        System.out.printf("Halving 2 then Squaring the result: %d\n", squareFn.compose(divFn).apply(2)); //1
    }
}

/*
 * Output:
 * Squaring 2: 4
 * Halving 2: 1
 * Squaring 2 then Halving the result: 2
 * Halving 2 then Squaring the result: 1
 */
