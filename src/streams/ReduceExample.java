package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

    private static int performMultiplicationWithInitialValue(List<Integer> list){
        return list.stream()
                .reduce(1,(a,b) -> a*b);
    }

    private static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> list){
        return list.stream()
                .reduce((a,b)->a*b);
    }

    private static int performSumWithInitialValue(List<Integer> list){
        return list.stream()
                //.reduce(0,(a,b)->a+b);
                .reduce(0,Integer::sum);
    }

    private static Optional<Integer> performSumWithNoInitialValue(List<Integer> list){
        return list.stream()
                //.reduce((a,b)->a+b);
                .reduce(Integer::sum);
    }

    private static Optional<Integer> findMax(List<Integer> list){
        return list.stream()
                //.reduce((a,b)->a>b?a:b);
                .reduce(Integer::max);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,3,5,7);
        System.out.println("Multiplication with identity: "+performMultiplicationWithInitialValue(integerList));

        Optional<Integer> multiplicationWithoutIdentity = performMultiplicationWithNoInitialValue(integerList);
        if(multiplicationWithoutIdentity.isPresent()){
            System.out.println("Multiplication without identity: "+multiplicationWithoutIdentity.get());
        }

        System.out.println("Sum with identity: "+performSumWithInitialValue(integerList));

        Optional<Integer> sumWithoutIdentity = performSumWithNoInitialValue(integerList);
        if(sumWithoutIdentity.isPresent()){
            System.out.println("Sum without identity: "+sumWithoutIdentity.get());
        }

        Optional<Integer> maxNo = findMax(integerList);
        if(maxNo.isPresent())
            System.out.println("Max No.: "+maxNo.get());
    }
}
