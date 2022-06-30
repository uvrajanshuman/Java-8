package lambda.expressions.collections;
/*
 *  Program to demonstrate customized sorting of Custom class objects..
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
            new Employee(400,"Shrivastava")
        );

        Comparator<Employee> comparator = (e1, e2)->e1.geteNo()- e2.geteNo();
        Collections.sort(list,comparator);
        System.out.println(list);
    }
}
