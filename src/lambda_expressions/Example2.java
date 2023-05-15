package lambda_expressions;

/*
 *  Example demonstrating concrete class implementation, anonymous class implementation and
 *  lambda expression implementation of Runnable interface for Thread creation.
 */

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("Thread 1: "+i);
        }
    }
}

public class Example2 {
    public static void main(String[] args) {
        // using implementation class of Runnable
        Thread t1 = new Thread ( new RunnableImpl() );

        // using anonymous inner class
        Thread t2 = new Thread( new Runnable (){
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    System.out.println("Thread 2: " + i);
                }
            }
        });

        //using lambda expression
        Thread t3 = new Thread( () -> {
            for (int i=0; i<10; i++){
                System.out.println("Thread 3: "+i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}