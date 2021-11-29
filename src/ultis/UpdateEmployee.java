package src.ultis;
import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.modes.Syndicate;


public class UpdateEmployee {
    Scanner scan = new Scanner(System.in);
    FindEmployee find = new FindEmployee();
    Employees empAux;
    Syndicate syndAux;
    int key;
    String auxName;
    public LinkedList<Employees> Update(LinkedList<Employees> employee, LinkedList<Syndicate> syndEmp){
        
        while(true){
            System.out.println("What option would you like to update:");
            System.out.println("[1] - Name");
            System.out.println("[2] - Address");
            System.out.println("[3] - Employee type");
            System.out.println("[4] - Paymente way");
            System.out.println("[5] - Belong to Syndicate");
            System.out.println("[6] - Syndicate ID");
            System.out.println("[7] - Tax of Syndicate");
            key = scan.nextInt();                    
            switch(key){
                case 1:
                System.out.println("[Employee ID]");
                int id = scan.nextInt();
                empAux = find.find(employee, id);

                if(empAux.getName()!=null){
                    auxName = empAux.getName();
                    System.out.println("[Set a new Name]");
                    scan.nextLine();
                    String name = scan.nextLine();
                    for(int i = 0; i<employee.size();i++){
                        if(empAux.getId() == employee.get(i).getId()){
                            employee.get(i).setName(name);
                            System.out.println( auxName +" Changed to "+ employee.get(i).getName());
                            return employee;
                        }
                    }
                }
                break;
                case 2:
                    System.out.println("Change Adress");
                    break;
                case 3:
                    System.out.println("Change Employee type");
                    break;
                case 4: 
                    System.out.println("Change paymente way");
                    break;
                case 5:
                    System.out.println("Change Syndicate status");
                    break;
                case 6:
                    System.out.println("Syndicate ID");
                    break;
                case 7:
                    System.out.println("Syndicate's Tax");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }  
    }
}
