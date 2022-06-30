package method_reference_and_constructor_reference;

public class Example1 {

    static void staticMethod(){
        for(int i=1;i<=10;i++){
            System.out.println("static method ref: "+i);
        }
    }

    void instanceMethod(){
        for(int i= 1; i<=10; i++){
            System.out.println("instance method ref: "+i);
        }
    }

    public static void main(String[] args) {

        // Thread Creation using lambda expression
        Thread t1 = new Thread(()->{
            for (int i=1; i<=10; i++){
                System.out.println("Lambda Expression: "+i);
            }
        });

        // Thread creation using static method ref.
        Thread t2 = new Thread(Example1::staticMethod);

        Example1 ob = new Example1();
        // Thread creation using instance method ref.
        Thread t3 = new Thread(ob::instanceMethod);

        t1.start();
        t2.start();
        t3.start();


    }
}
