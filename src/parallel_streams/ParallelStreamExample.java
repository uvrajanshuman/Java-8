package parallel_streams;

import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    private static long checkPerformance(Supplier<Integer> sumMethod, int noOfIterations){
        long startTime = System.currentTimeMillis();
        for(int i=0; i<noOfIterations; i++){
            sumMethod.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static int sumSequentialStream(){
        return IntStream.rangeClosed(1,10000)
                .sum();
    }

    private static int sumParallelStream(){
        return IntStream.rangeClosed(1,10000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(checkPerformance(ParallelStreamExample::sumSequentialStream,10));
        System.out.println(checkPerformance(ParallelStreamExample::sumParallelStream,10));
        System.out.println("Total Availaible Processors in the Machine: "+Runtime.getRuntime().availableProcessors());
    }
}

