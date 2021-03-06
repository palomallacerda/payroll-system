package src;
import java.util.LinkedList;
import java.util.Scanner;

import src.ultis.*; //importando a outra classe
import src.ultis.Adding.AddEmployee;
import src.ultis.Adding.AddSyndicate;
import src.ultis.functions.PaymentScheduel;
import src.ultis.functions.Payroll;
import src.ultis.functions.SetEmployeSale;
import src.ultis.functions.RemoveEmployee;
import src.ultis.functions.ServiceTax;
import src.ultis.functions.SethoursEmployee;
import src.ultis.functions.UpdateEmployee;
import src.modes.Employees;

import src.modes.Syndicate;
import src.modes.History.Backup;
import src.modes.History.EmptyHistory;
import src.modes.History.History;
import src.modes.History.HistoryHandler;
import src.modes.History.HistoryInterface;


public class InitialMenu{
    // Vamos inicializar o menu
    Scanner scan = new Scanner(System.in);
 
    LinkedList<Employees> employee = new LinkedList<>();
    LinkedList<Syndicate> syndicates = new LinkedList<>();
    LinkedList<String> schedueles = new LinkedList<>();
    PaymentScheduel payScheduel = new PaymentScheduel();
    Payroll allPayroll = new Payroll();
    History history  = new History();
    HistoryInterface hisInterface = new EmptyHistory();
    int id = 0;
    Backup newState;
    boolean flag = true;
    int[] employeeCounter= {0};
    int[] syndCounter = {-1};

// Extrair alguns metodos para facilitar o entendimento
    public void menu()  {
 
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
            System.out.print("--> ");
            int action = scan.nextInt();
            
            switch (action) {
                case 0:
                    if(employee.isEmpty()){
                        System.out.println("\nThere isn't any employee registered!");
                    }
                    else{
                        System.out.println("########## List of all employees ##########"); 
                        ListAll list = new ListAll();
                        list.listEmploy(employee, syndicates, schedueles);
                    }
                    flag = false;
                break;
                case 1:
                    AddEmployee add = new AddEmployee(); 
                    employee.add(add.addNewEmployee(id, schedueles));
                    id += 1;
                    AddSyndicate addSyndi = new AddSyndicate();
                    syndicates = addSyndi.AddNewEmploy(employee, syndicates);
                    
                    employeeCounter = add.getEmployeesCounter();
                    syndCounter = add.getSyndicatesCounter();
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
                    SetEmployeSale saleEmp = new SetEmployeSale();
                    saleEmp.setSale(employee);
                    break;
                case 5:
                    if(syndicates.isEmpty()){
                        System.out.println("There isn't any syndicate member");    
                    }
                    else{
                        ServiceTax tax = new ServiceTax();
                        syndicates = tax.addServiceTax(employee,syndicates);
                    }
                    break;
                case 6:
                    if(!employee.isEmpty()){
                        UpdateEmployee updateEmp = new UpdateEmployee();
                        updateEmp.Update(employee, syndicates);
                    }
                    else{
                        System.out.println("There is not any employee to update!");
                    }
                    break;
                case 7:
                    allPayroll.runningTodayPayrool(employee, syndicates, schedueles);
                    break;
                case 8:
                    System.out.println("Would you like to:\n[1] Undo\n[2] Redo");
                    int select = scan.nextInt();
                    scan.nextLine();
                    try{
                        if(select == 1){
                            undoCase();
                        }
                        else if(select == 2){
                            redoCase();
                        }
                        else{
                            System.out.println("Not a valid option!");
                        }
                    }catch (Exception e) { //Verificar por que ta dando nullo o vetor
                        System.out.println(e);
                    }
                    flag = false;
                    break;
                case 9:
                    payScheduel.changePaymentSchedules(schedueles, employee);
                    break;
                case 10:
                    payScheduel.newScheduel(schedueles);
                    break;
                case 11:
                    scan.close();//close input
                    System.out.println("Closing System....");
                    System.exit(0); //finalizando sem erros
                    break;
                default:
                    System.out.println("\nWrong action, try again!!");
                    flag = false;
                    break;
            }   
           
            if(flag) {
                newState = new Backup(payScheduel, employee, syndicates, employeeCounter, syndCounter);
                history.setStates(newState);
            }
            flag = true;
            System.out.println("\nClick [Enter] to continue");
            scan.nextLine();
            scan.nextLine();
        }
        
    }

    private void redoCase(){
        
        if(history.getHead() <= history.getStates().size()) {
            int head = history.getHead();
            
            hisInterface = new HistoryHandler(head, history.getStates());
            history.setHead(head+1);
        }
        
        Backup previusState = hisInterface.redo();
        
        employee = previusState.getEmployees();
        syndicates = previusState.getSyndicates();
        payScheduel = previusState.getSchedueles();
        employeeCounter = previusState.getEmployeCounter();
        syndCounter = previusState.getSyndCounter();
    }
    
    private void undoCase(){
        
        if(history.getHead() >= 0) {
            int head = history.getHead();
            
            hisInterface = new HistoryHandler(head, history.getStates());
            history.setHead(head-1);
        }
    
        Backup nextState = hisInterface.undo();
    
        employee = nextState.getEmployees();
        syndicates = nextState.getSyndicates();
        payScheduel = nextState.getSchedueles();
        employeeCounter = nextState.getEmployeCounter();
        syndCounter = nextState.getSyndCounter();
    }


}


