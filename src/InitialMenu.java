package src;
import java.util.LinkedList;
import java.util.Scanner;
import src.ultis.*; //importando a outra classe

import src.modes.Employees;

public class InitialMenu{
    // Vamos inicializar o menu
    Scanner scan = new Scanner(System.in);
    LinkedList<Employees> employee = new LinkedList<>();// reconhecer se ele vai colocar entradas válidas

    public void menu() {
       
        while(true){ 
            System.out.println("\n-------------------------------------------");
            System.out.println("----- Welcome to your payrool system ------");
            System.out.println("-------------------------------------------");
            System.out.println("Enter your operation bellow:");
            System.out.println("[0] - List all employees");
            System.out.println("[1] - Add an employee");
            System.out.println("[2] - Remove an employee");
            System.out.println("[3] - Post a timecard");
            System.out.println("[4] - Post sales result");
            System.out.println("[5] - Post a service tax");
            System.out.println("[6] - Update employee details");
            System.out.println("[7] - Run today's payroll");
            System.out.println("[8] - Undo/Redo");
            System.out.println("[9] - Scheduel payment");
            System.out.println("[10] - Create a new Scheduel payment");
            System.out.println("[11] - Leave\n");
            System.err.print("--> ");
            int action = scan.nextInt();
     
            switch (action) {
                case 0:
                    Employees list = new Employees();  
                    System.out.println("List all employess"); 
                    list.printEmployee(); 
                    break;
                case 1:
                    AddEmployee add = new AddEmployee(); 
                    employee.add(add.addNewEmployee());
                    // Verificando apenas a saida
                    System.out.println(employee.getLast().getName()+ " added "+ 
                    "and " +employee.getLast().getAddress()+ " is the adress "+
                    employee.getLast().getPaymentWay()+" is the payment way");
                    break;
                case 2:
                    System.out.println("Enter the employee name");
                    //employee = scan.nextLine();
                    System.out.println(employee+"Is removed");
                    break;
                case 3:
                    System.out.println("Post  time card");
                    break;
                case 4:
                    System.out.println("Post sales result");
                    break;
                case 5:
                    System.out.println("Post a service tax");
                    break;
                case 6:
                    System.out.println("Update employee details");
                    break;
                case 7:
                    System.out.println("Run today's payroll");
                    break;
                case 8:
                    System.out.println("Undo/Redo");
                    break;
                case 9:
                    System.out.println("Scheduel payment");
                    break;
                case 10:
                    System.out.println("Create a new scheduel payment");
                    break;
                case 11:
                    scan.close();//close input
                    System.out.println("Closing System....");
                    System.exit(0); //finalizando sem erros
                    break;
                default:
                    System.out.println("Wrond action try again");
                    break;
            }     
        }
        
    }
}