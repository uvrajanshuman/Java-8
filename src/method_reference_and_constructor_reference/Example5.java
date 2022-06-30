package method_reference_and_constructor_reference;

class Sample{
    private String s;
    Sample(String s){
        System.out.println("In Constructor");
        this.s = s;
    }
    public String toString(){
        return this.s;
    }
}

@FunctionalInterface
interface Interf{
    public Sample get(String s);
}

public class Example5 {
    public static void main(String[] args) {
        //using lambda expression
        Interf i = s -> new Sample(s);
        System.out.println(i.get("From Lambda Expression"));
        //using constructor reference
        Interf i2 = Sample::new;
        System.out.println(i2.get("From Constructor ref."));
    }
}
