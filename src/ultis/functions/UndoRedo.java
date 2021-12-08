package src.ultis.functions;

import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.modes.Syndicate;
import src.modes.History.Backup;
import src.modes.History.EmptyHistory;
import src.modes.History.History;
import src.modes.History.HistoryHandler;
import src.modes.History.HistoryInterface;

public class UndoRedo {

    Scanner scan = new Scanner(System.in);
    Payroll allPayroll = new Payroll();
    History history  = new History();
    HistoryInterface hisInterface = new EmptyHistory();

    public void selection(PaymentScheduel payScheduel, LinkedList<Employees>employee, LinkedList<Syndicate> syndicates, History auxHistory, int employeeCounter, int syndCounter){
        this.history = auxHistory;
        System.out.println("Would you like to:\n[1] Undo\n[2] Redo");
        int select = scan.nextInt();
        scan.nextLine();
        try{
            if(select == 1){
                undoCase(syndicates, employee, payScheduel, syndCounter, employeeCounter);
            }
            else if(select == 2){
                redoCase(syndicates, employee, payScheduel, syndCounter, employeeCounter);
            }
            else{
                System.out.println("Not a valid option!");
            }
        }catch (Exception e) { //Verificar por que ta dando nullo o vetor
            System.out.println(e);
        }
    }
    
    private void redoCase(LinkedList<Syndicate> syndicates, LinkedList<Employees>employee, PaymentScheduel payScheduel, int syndCounter, int employeeCounter){
        
        if(history.getHead() > history.getStates().size() - 1) {
            int head = history.getHead();
            
            hisInterface = new HistoryHandler(head, history.getStates());
            history.setHead(head+1);
        }
        
        Backup previusState = hisInterface.redo();
        
        employee = previusState.getEmployees();
        syndicates = previusState.getSyndicates();
        // payScheduel = previusState.getSchedueles();
        // arumar uma forma de atualizar isso aqui
        employeeCounter = previusState.getEmployeCounter();
        syndCounter = previusState.getSyndCounter();
    }
    
    
    private void undoCase(LinkedList<Syndicate> syndicates, LinkedList<Employees>employee,PaymentScheduel payScheduel,  int syndCounter, int employeeCounter){
        
        System.out.println(history.getHead());
        if(history.getHead() > 0) {
            int head = history.getHead();
            
            hisInterface = new HistoryHandler(head, history.getStates());
            history.setHead(head-1);
        }
    
        Backup nextState = hisInterface.undo();
    
        employee = nextState.getEmployees();
        syndicates = nextState.getSyndicates();
        // payScheduel = nextState.getSchedueles();
         //arumar uma forma de atualizar isso aqui
        employeeCounter = nextState.getEmployeCounter();
        syndCounter = nextState.getSyndCounter();
    }

}
