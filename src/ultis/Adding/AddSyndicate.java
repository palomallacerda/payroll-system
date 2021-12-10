package src.ultis.Adding;
import java.util.LinkedList;

import src.modes.Employees;
import src.modes.Syndicate;
import src.ultis.FindEmployee;

public class AddSyndicate {
    Syndicate syndAux = new Syndicate();
    Employees employesAux = new Employees();
    FindEmployee findSynd = new FindEmployee();
    public LinkedList<Syndicate> AddNewEmploy(LinkedList<Employees> employees, LinkedList<Syndicate> empSynd){
        int i  = employees.size()-1;
        do{
            employesAux = employees.get(i);
            if(employesAux.getSyndicate() && !employesAux.getFlag()){
                syndAux.setFlag(true);
                syndAux.setName(employesAux.getName());
                syndAux.setSyndicateId(employesAux.getAge(), employesAux.getId());
                empSynd.add(syndAux);
                employesAux.setFlag(true);
            }
            i-=1;
        }
        while(i>0);       
        return empSynd;
    }

    public void updateSyndicate(LinkedList<Syndicate> empSynd, LinkedList<Employees> employeeList, Employees aux){
        employesAux = findSynd.find(employeeList, aux.getId());
        int index= 0;

        for(int i = 0; i<employeeList.size(); i++){
            if(aux.getId() == employeeList.get(i).getId()){
                employeeList.get(i).setSyndicate(true);
                empSynd =  AddNewEmploy(employeeList, empSynd);
            }
            else{ 
                index+=1;
            }
        } 
        if(index == employeeList.size()){
            System.out.println("Not Found or maybe invalid update");
        }
    }
}
