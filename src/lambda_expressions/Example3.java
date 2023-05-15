package lambda_expressions;

/*
 *  Example demonstrating usage of this in Lambda Expressions.
 *  "this" keyword in lambda expression refers to enclosing class object reference.
 */

/*
 * For anonymous class ‘this’ keyword resolves to anonymous class object,
 * whereas for Lambda expressions ‘this’ keyword resolves to enclosing class object where lambda is written.
 */

interface Process{
    public void process();
}

public class Example3 {
    // enclosing class instance variable
    int x = 666;

    public Process getLambdaImpl() {
        return () -> {
            // lambda local variable
            int x = 777;
            System.out.println(x); // 777
            System.out.println(this.x); // 666
        };
    }

    public Process getAnonymousClassImpl(){
        return new Process() {
            // anonymous class instance variable
            int x = 888;
            @Override
            public void process() {
                // anonymous clas local variable
                int x = 999;
                System.out.println(x); // 999
                System.out.println(this.x); // 888
            }
        };
    }

    public static void main(String[] args) {
        Example3 example3 = new Example3();
        System.out.println("Lambda Implementation");
        example3.getLambdaImpl().process();
        System.out.println("=======================");
        System.out.println("Anonymous class Implementation");
        example3.getAnonymousClassImpl().process();
    }
}

/* Output:
 * Lambda Implementation
 * 777
 * 666
 * =======================
 * Anonymous class Implementation
 * 999
 * 888
 */