package predefined_functional_interfaces.bi_functional_interfaces.biconsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*
 *  Example demonstrating use of BiConsumer
 */
public class BiConsumerExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("John", 25);
        map.put("Jane", 30);
        map.put("Jim", 35);

        BiConsumer<String, Integer> printer = (key, value) -> System.out.println(key + " is " + value + " years old.");
        map.forEach(printer);
    }
}

/*
 * Output:
 * John is 25 years old.
 * Jane is 30 years old.
 * Jim is 35 years old.
 */