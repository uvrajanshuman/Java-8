package lambda.expressions.basic_examples;

@FunctionalInterface
interface ClosureEx{
    void m1();
}

public class Example4{
    // instance variable
    int x = 10;
    public void m2(){
        // local variable
        final int y = 20;
        ClosureEx cx = () -> {
            System.out.println(x); //10
            System.out.println(y); //20
            x = 30;
            //y = 40; //Compilation error
        };
        cx.m1();
    }

    public static void main(String[] args) {
        Example4 obj = new Example4();
        obj.m2();
    }
}
