package lambda_expressions.custom_sorting;

/*
 *  Program to demonstrate customized sorting of Custom class objects.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *   Comparator is a Functional interface with SAM compare()
 *   interface<T> Comparator{
 *       public int compare(T obj1, T obj2);
 *   }
 *   return -ve if obj1 has to come before obj2
 *   return +e if obj1 has to come after obj2
 *   return 0 if obj1 and obj2 are equal.
 *
 */
class Employee{
    private int eNo;
    private String eName;

    Employee(int eNo, String eName){
        this.eNo = eNo;
        this.eName = eName;
    }

    public int geteNo() {
        return eNo;
    }

    public void seteNo(int eNo) {
        this.eNo = eNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String toString(){
        return eNo+":"+eName;
    }
}
public class CustomObjectCustomizedSortingExample {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee(100,"Anshuman"),
                new Employee(600,"Yuvraj"),
                new Employee(300,"Sunny"),
                new Employee(200,"Chintu"),
                new Employee(700,"Amay"),
                new Employee(400,"Pintu")
        );

        Comparator<Employee> comparator = (e1, e2) -> e2.geteNo() - e1.geteNo();
        Collections.sort(list,comparator);
        System.out.println(list);
    }
}

/*
 *  Output:
 *  [700:Amay, 600:Yuvraj, 400:Pintu, 300:Sunny, 200:Chintu, 100:Anshuman]
 */