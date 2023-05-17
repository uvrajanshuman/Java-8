package method_reference_and_constructor_reference;
/*
 * Example demonstrating lambda expression and equivalent instance method reference
 * and static method reference
 */
public class MethodReferenceExample {

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
        Thread t2 = new Thread(MethodReferenceExample::staticMethod);

        MethodReferenceExample ob = new MethodReferenceExample();
        // Thread creation using instance method ref.
        Thread t3 = new Thread(ob::instanceMethod);

        t1.start();
        t2.start();
        t3.start();

    }
}
