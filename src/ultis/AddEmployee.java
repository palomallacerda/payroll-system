package src.ultis;
import java.util.Scanner;
import src.modes.Employees;

public class AddEmployee {
    Scanner scann = new Scanner(System.in);
    public Employees addNewEmployee(int id){
        
        
        Employees employee = new Employees();

        employee.setId(id);
        System.out.println("\nEnter the employee data");
        System.out.print("Name - ");
        employee.setName();
        System.out.print("Age - ");
        employee.setAge();
        System.out.print("Address - ");
        employee.setAddress();
        
        while(true){
            System.out.println("\nPayment way:\n[1] - Mail paycheck\n[2] - Paycheck\n[3] - Deposit in bank account");
            System.out.print("--> ");
            int way = scann.nextInt();
            if(way == 1) {  
                employee.setPaymentWay("Mail paycheck");
                break;
            }else if(way == 2){
                employee.setPaymentWay("Paycheck");
                break;
            }else if(way == 3){
                employee.setPaymentWay("Deposit in bank account");
                break;
            }else{
                System.out.println("Invalid input, Try again!"); ///retornar pro inicio do sistema
            }
        }
        
        //System.out.println("Payment type:");
        //to do
        return employee;
    }
}
