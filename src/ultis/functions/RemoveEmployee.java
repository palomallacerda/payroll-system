package src.ultis.functions;

import java.util.LinkedList;
import java.util.Scanner;
import src.modes.Employees;
import src.ultis.FindEmployee;

public class RemoveEmployee {

    Scanner scan = new Scanner(System.in);
    
    public Employees deleteEmployee(LinkedList<Employees> employeeOff){
        
        int employeeId;
        FindEmployee findEmp = new FindEmployee();
        Employees employ = new Employees();

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

}
