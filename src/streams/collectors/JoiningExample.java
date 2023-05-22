package streams.collectors;
/*
 * Example demonstrating Collectors method: joining and its overloaded versions
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {

    // joining
    private static String joining(List<String> list) {
        return list.stream()
                .collect(Collectors.joining());
    }

    //joining(delimiter)
    private static String joiningWithDelimiter(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(","));
    }

    //joining(delimiter, prefix, suffix)
    private static String joiningWithDelimiterAndPrefixSuffix(List<String> list) {
        return list.stream()
                .collect(Collectors.joining("_", "[", "]"));
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Mango", "Apple", "Watermelon");
        System.out.println("Joining1: " + joining(fruits));
        System.out.println("Joining2: " + joiningWithDelimiter(fruits));
        System.out.println("Joining3: " + joiningWithDelimiterAndPrefixSuffix(fruits));
    }
}
/*
 * Output:
 * Joining1: MangoAppleWatermelon
 * Joining2: Mango,Apple,Watermelon
 * Joining3: [Mango_Apple_Watermelon]
 */