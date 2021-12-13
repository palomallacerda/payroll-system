package src.ultis.functions;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import src.modes.*;
import src.ultis.FindEmployee;

public class SetEmployeSale {
    Employees employeesale = new Employees();
    Salaried salariedEmploy = new Salaried();
    FindEmployee find = new FindEmployee();
    Scanner scan = new Scanner(System.in);
    int todaySale;
    LocalDate date;
    int id;

    public void setSale(LinkedList<Employees> employee)  { // Lista e id
        if (employee.isEmpty()) {
            System.out.println("There isn't any employee to set a sale!");
        } else {
            System.out.print("Enter the employee ID: ");
            id = scan.nextInt();
            salariedEmploy = find.findSalaried(employee, id);
            try {
                if (salariedEmploy.getName() != null || !salariedEmploy.getEmployeeType().equals("Hourly")) {
                
                    System.out.println("Today is "+ LocalDate.now()); 
                    salariedEmploy.setDate(LocalDate.now());
                    
                    System.out.print("Enter how many sale " + salariedEmploy.getName() + " did today:\n--> ");
                    todaySale = scan.nextInt();
                    if (todaySale < 0) {
                        System.out.println("Invalid input!");
                        setSale(employee);
                    } else {
                        salariedEmploy.setSale(todaySale);
                        salariedEmploy.listSalaried();
                        System.out.println("------------------------------");
                        System.out.println("\nSale " + todaySale + " added!");
                        System.out.println("------------------------------");
                    }
                } else {
                    System.out.println("\nInvalid!\n --- Try Again");
                    setSale(employee);
                }
            } catch (Exception e) {
                System.out.println("Sorry!");
            }
        }
    }

}
