package src.ultis.functions;
import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;
import src.modes.Syndicate;
import src.ultis.FindEmployee;
import src.ultis.Adding.AddEmployee;
import src.ultis.Adding.AddSyndicate;

public class UpdateEmployee {
    Scanner scan = new Scanner(System.in);
    FindEmployee find = new FindEmployee();
    AddEmployee addEmp = new AddEmployee();
    RemoveEmployee remove = new RemoveEmployee();
    AddSyndicate addSyndi = new AddSyndicate();
    Employees empAux;
    Hourly empHourly;
    Salaried empSalaried;
    Syndicate syndAux;
    int key;
    int id;
    String aux;
    
    public void Update(LinkedList<Employees> employee, LinkedList<Syndicate> syndEmp){
        
        System.out.println("[Employee ID]");
        id = scan.nextInt();
        
        empAux = find.find(employee, id);
        
        while(true){
            System.out.println("\nWhat option would you like to update:");
            System.out.println("[1] - Name");
            System.out.println("[2] - Address");
            System.out.println("[3] - Employee type");
            System.out.println("[4] - Paymente way");
            System.out.println("[5] - Belong to Syndicate");
            System.out.println("[6] - Syndicate ID");
            System.out.println("[7] - Tax of Syndicate");
            System.out.println("[8] - Exit");
            key = scan.nextInt();                    
            switch(key){
                case 1:
                if(empAux.getName()!=null){
                    aux = empAux.getName();
                    System.out.println("[Set a new Name]");
                    scan.nextLine();
                    String name = scan.nextLine();
                    for(int i = 0; i<employee.size();i++){
                        if(empAux.getId() == employee.get(i).getId()){
                            employee.get(i).setName(name);
                            System.out.println(aux +" updated to "+ employee.get(i).getName());
                        }
                    }
                }
                break;
                case 2:
                    if(empAux.getName()!=null){
                        aux = empAux.getAddress();
                        System.out.println("[Set a new Address]");
                        scan.nextLine();
                        String address = scan.nextLine();
                        for(int i = 0; i<employee.size();i++){
                            if(empAux.getId() == employee.get(i).getId()){
                                employee.get(i).setAddress(address);
                                System.out.println(aux +" Changed to "+ employee.get(i).getAddress());
                            }
                        }
                    }
                    break;
                case 3:
                    if(empAux.getName()!= null){
                        remove.removeUpdating(employee, empAux);
                        addEmp.updateNewEmployee(empAux, employee);
                    }
                    break;
                case 4: 
                    if(empAux.getName()!=null){
                        aux = empAux.getPaymentWay();
                        System.out.println("[Set a new payment way]");
                        System.out.println("\n[1] - Mail paycheck\n[2] - Paycheck\n[3] - Deposit in bank account");
                        System.out.print("--> ");
                        scan.nextLine();
                        int newPayment = scan.nextInt();
                       
                        for(int i = 0; i<employee.size();i++){
                            if(empAux.getId() == employee.get(i).getId()){
                                if(newPayment == 1) {  
                                    employee.get(i).setPaymentWay("Mail paycheck");
                                }else if(newPayment == 2){
                                    employee.get(i).setPaymentWay("Paycheck");
                                }else if(newPayment == 3){
                                    employee.get(i).setPaymentWay("Deposit in bank account");
                                }
                                else{
                                    System.out.println("Invalid Input");
                                    break;
                                }
                                System.out.println( aux +" changed to "+ employee.get(i).getPaymentWay());
                            }
                        }
                    }
                    break;
                case 5: 
                    if(empAux.getName()!=null){
                        if(empAux.getSyndicate() == true){ //retirar dos sindicatos
                            System.out.println("Current Syndicate Id: ");
                            int syndId = scan.nextInt();
                            remove.deleteSyndicate(syndEmp, syndId);
                         
                            employee.get(id).setSyndicate(false);
            
                            System.out.println("Successfully updated to False");
                        }
                        else if(empAux.getSyndicate() == false){ //Adiciona ao sindicato
                            employee.get(id).setSyndicate(true);
                            addSyndi.updateSyndicate(syndEmp, employee,empAux);                                    
                            System.out.println("Successfully updated to True");
                        }
                       
                    }else{
                        System.out.println("Employee not found");
                    }

                    break;
                case 6:
                    System.out.println("Current Syndicate Id:");
                    System.out.print("-->");
                    int syndId = scan.nextInt();
                    System.out.println("[Set the new Id]");
                    System.out.print("-->");
                    int newId = scan.nextInt();
                    for (Syndicate aux : syndEmp) {
                        if(aux.getSyndicateId() == newId){
                            System.out.println("Sorry this Id already exist");
                            return;
                        }                        
                    }
                    Syndicate found = find.findSyndicate(syndEmp, syndId);
                    if(found.getName()!= null){
                        for(int i = 0; i< syndEmp.size(); i++){
                            syndAux = syndEmp.get(i);
                            if(syndAux.getSyndicateId()== found.getSyndicateId()){
                                syndEmp.get(i).setSyndicateId(newId);
                                System.out.println("Updated to "+syndEmp.get(i).getSyndicateId());
                            }
                        }
                    }
                    else{
                        System.out.println("This syndicate does not exist");
                    }
                    break;
                case 7:
                    System.out.println("Syndicate Id:");
                    System.out.print("-->");
                    id = scan.nextInt();
                    System.out.println("[Set the new syndicate tax]");
                    double tax = scan.nextDouble();
                    Syndicate foundSyn = find.findSyndicate(syndEmp, id);
                    Double lastTax = foundSyn.getServiceTax();
                    if(foundSyn.getName()!= null){
                        for(int i = 0; i< syndEmp.size(); i++){
                            syndAux = syndEmp.get(i);
                            if(syndAux.getSyndicateId()== foundSyn.getSyndicateId()){
                                syndEmp.get(i).setSyndicateTax(tax);
                                System.out.println(lastTax+ " updated to "+syndEmp.get(i).getSyndicateTax());
                            }
                        }
                    }
                    else{
                        System.out.println("This syndicate does not exist");
                    }
                    break;
                case 8: 
                    System.out.println("Leaving.....");
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }  
    }
}
