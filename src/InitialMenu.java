package src;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
import src.ultis.*; //importando a outra classe
import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Syndicate;

public class InitialMenu{
    // Vamos inicializar o menu
    Scanner scan = new Scanner(System.in);
    Syndicate syndicate = new Syndicate();
    LinkedList<Employees> employee = new LinkedList<>();// reconhecer se ele vai colocar entradas válidas
    ArrayList<Integer> salesMade = new ArrayList<>();
    int id = 0;
    
    public void menu() {
       /*Verificar a viabilidade de talvez add mais uma opção 
       de salvar os dados em um arquivo separado*/
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
                    if(employee.isEmpty()){
                        System.out.println("\nThere isn't any employee registered!");
                    }
                    else{
                        System.out.println("########## List of all employees ##########"); 
                        for (Employees employe : employee) {
                            employe.printEmployee();
                        }

                    }
                    break;
                case 1:
                    AddEmployee add = new AddEmployee(); 
                    employee.add(add.addNewEmployee(id));
                    id += 1;
                    break;
                case 2:
                    RemoveEmployee remove = new RemoveEmployee();
                    remove.deleteEmployee(employee);
                    break;
                case 3:
                    SethoursEmployee hours = new SethoursEmployee();
                    hours.settingWorkedTime(employee);
                    break;
                case 4:
                    EmployeSale saleEmp = new EmployeSale();
                    saleEmp.setSale(employee);
                    break;
                case 5:
                 
                    break;
                case 6:
                    UpdateEmployee updateEmp = new UpdateEmployee();
                    updateEmp.Update();
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
                    System.out.println("\nWrong action, try again!!");
                    break;
            }   
            
            System.out.println("\nClick [Enter] to continue");
            scan.nextLine();
            scan.nextLine();
        }
        
    }
}