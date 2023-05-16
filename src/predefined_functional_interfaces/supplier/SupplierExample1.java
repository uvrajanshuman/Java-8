package predefined_functional_interfaces.supplier;

/*
 *  Example demonstrating use of Supplier
 */

import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample1 {
    static Supplier<Date> dateSupplier = () -> new Date();
    public static void main(String[] args) {
        System.out.println("Current date time: "+ dateSupplier.get());
    }
}

/*
 * Output: (will change for each execution)
 * Current date time: Wed May 17 00:26:09 IST 2023
 */