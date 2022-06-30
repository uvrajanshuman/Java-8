package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitAndSkipExample {

    private static Optional<Integer> sumLimitThree(List<Integer> integerList){
        return integerList.stream()
                .limit(3)
                .reduce(Integer::sum);
    }

    private static Optional<Integer> sumSkipThree(List<Integer>integerList){
        return integerList.stream()
                .skip(3)
                .reduce(Integer::sum);
    }
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> limitSum = sumLimitThree(integerList);
        if(limitSum.isPresent())
            System.out.println("Sum of first 3 numbers: "+limitSum.get());

        Optional<Integer> skipSum = sumSkipThree(integerList);
        if(skipSum.isPresent())
            System.out.println("Sum of last 3 numbers: "+skipSum.get());
    }
}
