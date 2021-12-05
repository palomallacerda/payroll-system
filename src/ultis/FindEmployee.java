package src.ultis;
import java.util.LinkedList;
import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;
import src.modes.Syndicate;

public class FindEmployee {
    public Employees find(LinkedList <Employees> employeeFind, int id){
        Employees employ = new Employees(); //Começando uma lista vazia
        for(int i = 0; i < employeeFind.size(); i++){  
            
            Employees aux = employeeFind.get(i); //percorrendo a lista
            if(aux.getId() == id){
                employ = aux; //atribuindo o id encontrado
            }
            
        }
        return employ;
    }

    public Hourly findHourly(LinkedList <Employees> employeeFind, int id){
        Hourly employee = new Hourly();
        for (int i = 0; i < employeeFind.size(); i++) {
            Employees aux = employeeFind.get(i);
            if(aux.getEmployeeType().equals("Hourly")){
                if(aux.getId() == id){
                    employee = (Hourly)aux; //atribuindo o id encontrado
                }
            }
            else{
                employee.setName(null);
            }

        }
        return employee;
    }

    public Salaried findSalaried(LinkedList <Employees> employeeFind, int id){
        Salaried employee = new Salaried();
        for (int i = 0; i < employeeFind.size(); i++) {
            Employees aux = employeeFind.get(i);
            if(aux.getEmployeeType().equals("Commmission")){
                if(aux.getId() == id){
                    employee = (Salaried)aux;
                }
            }
            else if(aux.getEmployeeType().equalsIgnoreCase("Monthly Fixed")){
                if(aux.getId() == id){
                    employee = (Salaried)aux;
                }
            }
            else{
                System.out.println("THis employee was not found!");
                
                employee.setName(null);
            }
        }
        return employee;
    }

    public Syndicate findSyndicate(LinkedList <Syndicate> syndEmp, int id){
        Syndicate employee = new Syndicate();
        int flag = 0;
        for (int i = 0; i < syndEmp.size(); i++) {
            Syndicate aux = syndEmp.get(i);
            if(aux.getSyndicateId() == id){
                employee = aux;
                flag+=1;
            }
        }
        if(flag == 0){
            System.out.println("Employee not found");
            
            employee.setSyndicateId(-500, -5000);
        } 
        return employee;
    }
}
