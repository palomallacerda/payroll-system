package src.ultis;
import java.util.Scanner;
import src.modes.Employees;

public class AddEmployee {
    Scanner scann = new Scanner(System.in);
    public Employees addNewEmployee(){

        Employees employee = new Employees();
        System.out.println("\n Enter the employee data");

        System.out.print("Id - ");
        employee.setId();
        System.out.print("Name - ");
        employee.setName();
        System.out.println("Age - ");
        employee.setAge();

        System.out.print("Address - ");
        employee.setAddress();
        
        System.out.println("Payment way:\n[1] - Mail paycheck\n[2] - Paycheck\n[3] - Deposit in bank account");
        int way = scann.nextInt();
        switch(way){
            case 1:
                employee.setPaymentWay("Mail paycheck");
                break;
            case 2:
                employee.setPaymentWay("Paycheck");
                break;
            case 3:
                employee.setPaymentWay("Deposit in bank account");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        System.out.println("Payment type:");
        //to do
        return employee;
    }
}
