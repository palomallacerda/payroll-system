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
    HistoryInterface hisInterface = new EmptyHistory();

    public void selection(PaymentScheduel payScheduel, LinkedList<Employees>employee, LinkedList<Syndicate> syndicates, History auxHistory, int[] employeeCounter, int[] syndCounter){
 
        System.out.println("Would you like to:\n[1] Undo\n[2] Redo");
        int select = scan.nextInt();
        scan.nextLine();
        try{
            if(select == 1){
                undoCase(syndicates, employee, payScheduel, syndCounter, employeeCounter,auxHistory);
            }
            else if(select == 2){
                redoCase(syndicates, employee, payScheduel, syndCounter, employeeCounter, auxHistory);
            }
            else{
                System.out.println("Not a valid option!");
            }
        }catch (Exception e) { //Verificar por que ta dando nullo o vetor
            System.out.println(e);
        }
    }
    
    private void redoCase(LinkedList<Syndicate> syndicates, LinkedList<Employees>employee, PaymentScheduel payScheduel, int[] syndCounter, int[] employeeCounter, History auxhistory){
        
        if(auxhistory.getHead() >= auxhistory.getStates().size()) {
            int head = auxhistory.getHead();
            
            hisInterface = new HistoryHandler(head, auxhistory.getStates());
            auxhistory.setHead(head+1);
        }
        
        Backup previusState = hisInterface.redo();
        
        employee = previusState.getEmployees();
        syndicates = previusState.getSyndicates();
        payScheduel = previusState.getSchedueles();
        employeeCounter = previusState.getEmployeCounter();
        syndCounter = previusState.getSyndCounter();
    }
    
    
    private void undoCase(LinkedList<Syndicate> syndicates, LinkedList<Employees>employee,PaymentScheduel payScheduel,  int[] syndCounter, int[] employeeCounter, History auxhistory){
        
        if(auxhistory.getHead() > 0) {
            int head = auxhistory.getHead();
            
            hisInterface = new HistoryHandler(head, auxhistory.getStates());
            auxhistory.setHead(head-1);
        }
    
        Backup nextState = hisInterface.undo();
    
        employee = nextState.getEmployees();
        syndicates = nextState.getSyndicates();
        payScheduel = nextState.getSchedueles();
        employeeCounter = nextState.getEmployeCounter();
        syndCounter = nextState.getSyndCounter();
    }

}
