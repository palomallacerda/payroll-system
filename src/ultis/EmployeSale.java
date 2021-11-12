package src.ultis;
import java.util.LinkedList;
import java.util.Scanner;
import src.modes.*;

public class EmployeSale {
    Employees employeesale = new Employees();
    FindEmployee find = new FindEmployee();
    Scanner scan = new Scanner(System.in);
    int todaySale;
    int id;
    public void setSale(LinkedList <Employees> employee){ //Lista e id
        if(employee.isEmpty()){
            System.out.println("There isn't any employee to set a sale!");
        }
        else{
            System.out.print("Enter the employee ID: ");
            id = scan.nextInt();
    
            employeesale = find.find(employee, id);
            if(employeesale.getName() != null){
                System.out.print("Enter how many sale the employee did:\n--> ");
                todaySale = scan.nextInt();
                employeesale.setSale(todaySale);
                System.out.println("\nSale added!");
            }
        }
        
    }
    
}
