/*
 * File name: Main.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 6 (cj_workshop_6)
 * Date     : Mar 27 2014
 */
package cj_workshop_6;

import cj_workshop_6.Employee.EmpList;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String contine = "y"; //  Prompt user for continue or quit program
        do {
            Menu menu = new Menu();
            menu.add("Add new employee.                                         *");
            menu.add("Remove an employee.                                       *");
            menu.add("Promote an employee.                                      *");
            menu.add("Employee list.                                            *");
            menu.add("Quit.                                                     *");
            int userChoice = 0;
            EmpList list = new EmpList();
            do {
                System.out.println("*******************************************************************");
                System.out.println("*                       EMPLOYEE MAGAGER                          *");
                System.out.println("*******************************************************************");
                try {
                    userChoice = menu.getUserChoice();
                } catch (Exception ex) {
                    System.out.println("\n---------------------------WRONG INPUT!----------------------------\n\t+ Option must be an integer number!\n");
                    userChoice = 5;
                }
                switch (userChoice) {
                    case 1:
                        try {
                            list.add();
                        } catch (Exception ex) {
                            System.out.println("\n---------------------------WRONG INPUT!----------------------------\n\t+ Salary must be integer value!\n\t+ Adding failed!\n");
                        }
                        break;
                    case 2:
                        list.remove();
                        break;
                    case 3:
                        try {
                            list.promote();
                        } catch (Exception ex) {
                            System.out.println("\n---------------------------WRONG INPUT-----------------------------\n\t+ Salary must be integer value!\n\t+ Promote failed!\n");
                        }
                        break;
                    case 4:
                        list.print();
                        break;
                }
            } while (userChoice >= 1 && userChoice < 5);
            do {
                System.out.print("-----> Do you want to QUIT? (Y/n): ");
                Scanner sc = new Scanner(System.in);
                contine = sc.nextLine();
            } while (contine.equals(""));
        } while (contine.substring(0, 1).equalsIgnoreCase("n"));
        System.out.println("\n--------------------HAVE A NICE DAY. GOODBYE!----------------------");
    }
}
