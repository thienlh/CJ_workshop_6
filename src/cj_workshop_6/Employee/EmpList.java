/*
 * File name: EmpList.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 6 (cj_workshop_6)
 * Date     : Mar 27 2014
 */
package cj_workshop_6.Employee;

import java.util.Scanner;
import java.util.Vector;

public class EmpList extends Vector<Employee> {

    Scanner sc = new Scanner(System.in);
    //  Constructor

    public EmpList() {
        super();
    }
    //  Find an employee using their id

    public int find(String ID) {
        ID = ID.toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(ID)) {
                return i;
            }
        }
        return -1;
    }
    //  Add new Employee to the list

    public void add() {
        String newID;
        String newName;
        int newSalary;
        boolean duplicated = false;

        do {
            System.out.print("-----> Enter ID of the employee       : ");
            newID = sc.nextLine().toUpperCase();
            duplicated = find(newID) >= 0;
            if (duplicated) {
                System.out.println("\n#      Employee [" + newID + "] is existed!\n");
            }
        } while (find(newID) >= 0);
        //  Enter new id, name and salary;
        System.out.print("-----> Enter name of employee [" + newID + "]  : ");
        newName = sc.nextLine().toUpperCase();
        System.out.print("-----> Enter salary of employee [" + newID + "]: $");
        newSalary = Integer.parseInt(sc.nextLine());

        this.add(new Employee(newID, newName, newSalary));
        System.out.println("\n#      Employee [" + newName + "] has been added!\n");
    }
    //  Print the Employee list

    public void print() {
        int L = this.size();
        if (L == 0) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
        } else {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("                          EMPLOYEE LIST");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("    ID    |                  NAME                     |   SALARY");
            System.out.println("-------------------------------------------------------------------");
            for (Employee emp : this) {
                System.out.println(emp);
            }
            System.out.println();
        }
    }
    //  Remove employee using their id

    public void remove() {
        int L = this.size();
        if (L == 0) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
            return;
        }
        String removingID;  //  ID of removing employee
        System.out.print("-----> Enter ID of removing employee: ");
        removingID = sc.nextLine().toUpperCase();
        int pos = find(removingID);
        if (pos < 0) {
            System.out.println("\n#      This employee doesn't existed!\n");
        } else {
            System.out.println("\n#      Found: [" + this.get(pos).getId() + "]    " + this.get(pos).getName() + "\t$" + this.get(pos).getSalary()+'\n');
            String choice = null;
            do {
                System.out.print("-----> Are you sure to remove employee [" + removingID + "]? (y/N): ");
                choice = sc.nextLine();
            } while (choice.equals(""));
            if (choice.substring(0, 1).equalsIgnoreCase("y")) {
                String savedPos = this.get(pos).getName();
                this.remove(pos);
                System.out.println("\n#      Employee [" + savedPos + "] has been removed!\n");
            } else {
                System.out.println("\n#      Nothing happened!\n");
            }
        }
    }
    //  Promote salary for an employee

    public void promote() {
        String promotingID;
        int L = this.size();
        if (L == 0) {
            System.out.println("\n                      THE LIST IS EMPTY!\n");
            return;
        }
        System.out.print("-----> Enter ID of promoting employee: ");
        promotingID = sc.nextLine().toUpperCase();
        int pos = find(promotingID);

        if (pos < 0) {
            System.out.println("\n#      This employee doesn't existed!\n");
        } else {
            System.out.println("\n#      Found: [" + this.get(pos).getId() + "]    " + this.get(pos).getName() + "\t$" + this.get(pos).getSalary()+'\n');
            String choice = null;
            do {
                System.out.print("-----> Are you sure to promote employee [" + promotingID + "]? (y/N): ");
                choice = sc.nextLine();
            } while (choice.equals(""));
            if (choice.substring(0, 1).equalsIgnoreCase("y")) {
                System.out.print("-----> Enter [" + this.get(pos).getName() + "]'s new salary: $");
                int newSalary = Integer.parseInt(sc.nextLine());
                this.get(pos).setSalary(newSalary);
                System.out.println("\n#      Employee [" + this.get(pos).getName() + "] has been promoted!\n");
            } else {
                System.out.println("\n#      Nothing happened!\n");
            }
        }
    }
}
