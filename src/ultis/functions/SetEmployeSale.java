package src.ultis.functions;

import java.text.ParseException;
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
    String date;
    int id;

    public void setSale(LinkedList<Employees> employee) throws ParseException { // Lista e id
        if (employee.isEmpty()) {
            System.out.println("There isn't any employee to set a sale!");
        } else {
            System.out.print("Enter the employee ID: ");
            id = scan.nextInt();
            salariedEmploy = find.findSalaried(employee, id);
            if (salariedEmploy.getName() != null || !salariedEmploy.getEmployeeType().equals("Hourly")) {
                System.out.println("Enter the date [dd/MM/yyy]");
                date = scan.next();

                try {
                    salariedEmploy.setDate(date);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    setSale(employee);
                }

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
        }
    }

}
