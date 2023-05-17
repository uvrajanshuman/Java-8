package method_reference_and_constructor_reference;

/*
 * Example demonstrating that "For the methods mapped to SAM of a functional interface
 * the number of arguments and their type must match with the abstract method of functional interface,
 * but, the return type can be a subtype of specified return type (SAM return type), or a type that can be implicitly
 * converted to the expected return type (SAM return type)"
 *
 * Here the return types of abstract method of functional interface and the method mapped to it is different but compatible.
 */

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDifferentReturnTypeExample {
    public static Integer getNumber() {
        return 42;
    }

    public static void main(String[] args) {
        Supplier<Number> supplier = MethodReferenceDifferentReturnTypeExample::getNumber;

        Number result = supplier.get();
        System.out.println("Result: " + result); // Output: Result: 42
    }
}
/*
 * The functional interface `Supplier<Number>` has the abstract method `Number get()`, that returns a value of type Number.
 * We use a method reference MethodReferenceDifferentReturnTypeExample::getNumber to implement this functional interface.
 * The `getNumber()` method returns an Integer, which is a subtype of Number.
 * Thus, the return type of the method reference is compatible with the return type specified by the Supplier functional interface.
 *
 * When we invoke the get method on the supplier instance, it internally calls the getNumber method through the method reference.
 * The getNumber method returns an Integer, which is automatically upcasted to a Number and stored in the result variable.
 * Finally, we print the value of result, which is 42.
 */
