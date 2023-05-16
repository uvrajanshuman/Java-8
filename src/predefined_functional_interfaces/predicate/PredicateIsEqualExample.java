package predefined_functional_interfaces.predicate;

/*
 *  Example demonstrating isEqual() method of Predicate
 *  It return a predicate that checks whether two arguments are equal based on Object.equal(Object,Object)
 */

import java.util.function.Predicate;

public class PredicateIsEqualExample {
    public static void main(String[] args) {
        Predicate<String> stringEquality = Predicate.isEqual("Anshuman");
        System.out.println(stringEquality.test("Anshuman")); //true
        System.out.println(stringEquality.test("Yuvraj")); //false

        // equality check for non-primitive objects (equals methods needs to be overriden)
        Predicate<Person> personEquality = Predicate.isEqual(new Person("Anshuman"));
        System.out.println(personEquality.test(new Person("Anshuman"))); //ture
        System.out.println(personEquality.test(new Person("Yuvraj"))); //false
    }
}

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    //overriden equals method for custom equality check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

}

/*
 * Output:
 * true
 * false
 * true
 * false
 */