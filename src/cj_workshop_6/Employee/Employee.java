/*
 * File name: Employee.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 6 (cj_workshop_6)
 * Date     : Mar 27 2014
 */

package cj_workshop_6.Employee;

import java.util.Formatter;

public class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    private String name;
    private int salary;
//  Constructor
    public Employee(String id, String name, int salary) {
        this.id = id.toUpperCase();
        this.name = name.toUpperCase();
        this.salary = salary;
    }
//  toString() overriding
    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        return f.format(" %-8s | %-41s | %c%9d", getId(), getName(),'$', getSalary()).toString();
    }
    
}
