package src.ultis;
import java.util.LinkedList;
import src.modes.Employees;

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
}
