package lambda.expressions.basic_examples;

/*
 *  Example demonstrating usage of this in Lambda Expressions.
 *  "this" keyword in lambda expression refers to enclosing class object reference.
 */
@FunctionalInterface
interface Interf2{
    public void m1();
}

public class Example3 {
    int x = 777;
    public void m2() {
        //Functional interface
        Interf2 i1 = () -> {
            //local variable
            int x = 888;
            System.out.println(x); // 888
            System.out.println(this.x); // 777
        };
        System.out.println("Functional interface: ");
        i1.m1();

        System.out.println("-------------------------");
        //Anonymous inner class
        Interf2 i2 = new Interf2() {
            @Override
            public void m1() {
                //local variable
                int x = 888;
                System.out.println(x); // 888
                System.out.println(x); // 777
            }
        };
        System.out.println("Anonymous inner class");
        i2.m1();
    }

    public static void main(String[] args) {
        Example3 obj = new Example3();
        obj.m2();
    }
}
