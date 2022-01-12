package src.ultis.functions;

import java.util.LinkedList;
import java.util.Scanner;
import src.modes.Employees;
import src.modes.Syndicate;
import src.ultis.FindEmployee;

public class RemoveEmployee {

    
    int employeeId;
    FindEmployee findEmp = new FindEmployee();
    Employees employ = new Employees();
    Scanner scan = new Scanner(System.in);
    Syndicate employSynd = new Syndicate();

    public Employees deleteEmployee(LinkedList<Employees> employeeOff){

        if(employeeOff.isEmpty()){
            System.out.println("\nSorry you can not remove!\nThere isn't any employee register");
        }
        else{
            while(true){
                System.out.print("Enter the employee ID that you wish to remove\n-> ");
                employeeId = scan.nextInt();
                employ = findEmp.find(employeeOff, employeeId);
                
                if(employ.getName() != null){
                    System.out.println(employ.getName()+" Will be deleted!");
                    employeeOff.remove(employ);
                    System.out.println("\nGreat, the employee was removed!");
                    break;
                }
                else{
                    System.out.println("\nSorry, Id not found!");
                    System.out.println("\nWould you like to: \n[1] - List all employee Id\n[2] - Enter another ID");
                    int key = scan.nextInt();
                    switch(key){
                        case 1:
                            for(int i = 0; i < employeeOff.size();i++){  
                                Employees aux = employeeOff.get(i);
                                System.out.println("[ID]- "+ aux.getId()+" --- [Name]- "+ aux.getName());
                                System.out.println("---------------------------------------"); 
                            }
                            break;
                        case 2:
                            continue;
                        default:
                            System.out.println("Invalid Input!");
                    }
                }
            }
    
        }
        return employ;
    }

    public void removeUpdating(LinkedList<Employees> employeeOff, Employees auxEmp){
        if(employeeOff.isEmpty()){
            System.out.println("\nSorry you can not remove!\nThere isn't any employee register");
        }
        else{
            employeeOff.remove(auxEmp);
            System.out.println("\nGreat, the employee was removed!");
        }                    
            
    }

    public void deleteSyndicate(LinkedList<Syndicate> employeeOff, int syndicateId){
        
        if(employeeOff.isEmpty()){
            System.out.println("\nSorry, there isn't any employee register");
        }
        else{
            while(true){
                
                employSynd = findEmp.findSyndicate(employeeOff, syndicateId);
                
                if(employSynd.getName() != null){
                    employeeOff.remove(employSynd);
                    break;
                }
                else{
                    System.out.println("\nSorry, Id not found!");
                    return;
                }
            }
    
        }
    }
}
