package predefined_functional_interfaces.bi_functional_interfaces.bifunction;

/*
 *  Example demonstrating use of BinaryOperator
 */

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        int num1 = 5;
        int num2 = 10;
        System.out.printf(" %d + %d = %d\n",num1,num2,add.apply(num1,num2));
        System.out.printf(" %d * %d = %d",num1,num2,multiply.apply(num1,num2));

    }
}

/*
 * Output:
 * 5 + 10 = 15
 * 5 * 10 = 50
 */