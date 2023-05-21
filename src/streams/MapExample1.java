package streams;

/*
 * Example demonstrating Stream method: map
 */

import java.util.Arrays;
import java.util.List;

public class MapExample1 {
    public static void main(String[] args) {
        List<String> transportationModes = Arrays.asList("bus","car","bi-cycle","train","flights");
        transportationModes.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
/*
 * Output:
 * BUS
 * CAR
 * BI-CYCLE
 * TRAIN
 * FLIGHTS
 */