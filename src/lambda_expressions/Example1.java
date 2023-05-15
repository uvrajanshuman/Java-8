package lambda_expressions;

/*
 *  Example demonstrating concrete class implementation, anonymous class implementation and
 *  lambda expression implementation of a Functional interface.
 */
@FunctionalInterface
interface Interf{
    int sum(int a, int b);
}

class InterfImpl implements Interf{
    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}

public class Example1 {
    public static void main(String[] args) {

        //using implementation class
        Interf i1 = new InterfImpl();
        System.out.println(i1.sum(10,20));

        //using anonymous inner class
        Interf i2 = new Interf() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        System.out.println(i2.sum(30,40));

        //using lambda expression
        Interf i3 = (a, b) -> a+b;
        System.out.println(i3.sum(50,60));

    }
}

/*
 * Output:
 * 30
 * 70
 * 110
 */