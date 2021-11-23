package src.ultis;
import java.util.LinkedList;
import java.util.Scanner;


import src.modes.*;

public class EmployeSale {
    Employees employeesale = new Employees();
    Salaried salariedEmploy = new Salaried();
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
            if(employeesale.getName() != null || !employeesale.getEmployeeType().equals("Hourly")){
                System.out.print("Enter how many sale "+ employeesale.getName()+" did today:\n--> ");
                todaySale = scan.nextInt();
                if(todaySale < 0){
                    System.out.println("Invalid input!");
                    setSale(employee);
                }
                else{

                    salariedEmploy.setSale(todaySale); //quantidade de vendas mais as antigas
                    salariedEmploy.setAddress(employeesale.getAddress());
                    salariedEmploy.setAge(employeesale.getAge());
                    salariedEmploy.setId(employeesale.getId());
                    salariedEmploy.setName(employeesale.getName());
                    salariedEmploy.setPaymentWay(employeesale.getPaymentWay());
                    salariedEmploy.setSyndicate(employeesale.getSyndicate());
                   
                    System.out.println("------------------------------");
                    System.out.println("\nSale "+ todaySale +" added!");
                    System.out.println("------------------------------");
                }
            }
            else{
                System.out.println("\nInvalid!\n --- Try Again");
                setSale(employee);
            }
        }
    }
    
}
