package predefined_functional_interfaces.function;

/*
 *  Example demonstrating use of UnaryOperator.
 *  identity() returns a UnaryOperator that always returns it's input arguments.
 */

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        String message = "Anshuman";

        UnaryOperator<String> addGreeting = text -> "Greetings! " + text;
        UnaryOperator<String> identity = UnaryOperator.identity();

        String modifiedMessage = addGreeting.apply(message);
        String modifiedMessage2 = addGreeting.andThen(identity).apply(message);

        System.out.println(modifiedMessage);
        System.out.println(modifiedMessage2);
    }
}

/*
 * Output:
 * Greetings! Anshuman
 * Greetings! Anshuman
 */
