package predefined_functional_interfaces.supplier;

/*
 *  Example program to generate 8 digit random password
 */

import java.util.function.Supplier;

public class SupplierExample2 {
    static Supplier<Integer> randomIntSupplier = () -> (int)(Math.random()*10);

    private static final String symbols="ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
    static Supplier<Character> randomCharSupplier = () -> symbols.charAt((int)(Math.random()*29));

    public static void main(String[] args) {
        StringBuilder password = new StringBuilder();
        for(int i = 1; i<=8; i++){
            if(i%2==0)
                password.append(randomIntSupplier.get());
            else
                password.append(randomCharSupplier.get());
        }

        System.out.println("Generated Password: "+ password);
    }
}

/*
 *  Output: (will change for each execution)
 *  Generated Password: U7X2G1B0
 */