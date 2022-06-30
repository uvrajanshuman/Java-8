# Parallel Streams

- Splits the data into multiple parts.
- Process them in parallel.
- Combine the result.

## Sequential Stream:
```java
IntStream.rangeClosed(1,100)
        .sum();
```

## Parallel Stream
```java
IntStream.rangeClosed(1,100)
        .parallel()
        .stream();
```

## Working of Parallel Streams:

- Parallel Streams uses the Fork/Join Framework that got introduced in Java7.
- No. of Threads created == No. of processors available in the machine.
- `System.out.println(Runtime.getRuntime().availaibleProcessors()`//to print no. of availaible processor in a machine