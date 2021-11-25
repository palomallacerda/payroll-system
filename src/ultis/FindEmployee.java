package src.ultis;
import java.util.LinkedList;
import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;

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
                System.out.println("Opss ERRO!");
            }

        }
        return employee;
    }

    public Salaried findSalaried(LinkedList <Employees> employeeFind, int id){
        Salaried employee = new Salaried();
        for (int i = 0; i < employeeFind.size(); i++) {
            Employees aux = employeeFind.get(i);
            if(!aux.getEmployeeType().equals("Hourly")){
                if(aux.getId() == id){
                    employee = (Salaried)aux;
                }
            }
            else{
                System.out.println("Erro!");
            }
        }
        return employee;
    }

}
