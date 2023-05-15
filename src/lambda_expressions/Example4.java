package lambda_expressions;

/*
 *  Example demonstrating closure concept.
 *  The referenced local variable of the enclosing method of lambda expression/anonymous function are implicitly final (not allowed to change).
 *  There is no need to explicitly specify them as final, but they are implicitly final in nature.
 */
@FunctionalInterface
interface ClosureEx{
    void m1();
}

public class Example4{
    // instance variable
    int x = 10;

    public ClosureEx getLambdaImpl(){
        // local variable : implicitly final
        int y = 20;
        // Lambda Expression
        ClosureEx cx = () -> {
            System.out.println("Lambda Expression implementation");
            System.out.println(x); //10
            System.out.println(y); //20
            x = 30;
            //y = 40; //compilation error
        };
        //y=50; //compilation error
        return cx;
    }

    public ClosureEx getAnonymousClassImpl(){
        // local variable : implicitly final
        int y = 20;
        //Anonymous Function
        ClosureEx cx = new ClosureEx() {
            @Override
            public void m1() {
                System.out.println("Anonymous class implementation");
                System.out.println(x); //30
                System.out.println(y); //20
                x = 50;
                //y = 40; //compilation error
            }
        };
        //y=50; //compilation error
        return cx;
    }

    public static void main(String[] args) {
        Example4 obj = new Example4();
        ClosureEx lambdaImpl = obj.getLambdaImpl();
        ClosureEx anonymousImpl = obj.getAnonymousClassImpl();
        lambdaImpl.m1();
        anonymousImpl.m1();
    }
}

/*
 *  Output:
 *  Lambda Expression implementation
 *  10
 *  20
 *  Anonymous class implementation
 *  30
 *  20
 */
