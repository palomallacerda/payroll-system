package src.ultis.functions;

import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.modes.Syndicate;
import src.ultis.FindEmployee;
import src.ultis.ListAll;

public class ServiceTax {
    LinkedList <Syndicate> syndEmploy = new LinkedList<>();
    Employees aux = new Employees();
    Scanner scan = new Scanner(System.in);
    FindEmployee find = new FindEmployee();
    double tax;
    int syndId;
    
    public LinkedList<Syndicate> addServiceTax(LinkedList <Employees> employe, LinkedList<Syndicate> syndEmp){
        Syndicate syndicated = new Syndicate();
        System.out.println("Enter the >[Syndicate]< Id: ");
        syndId = scan.nextInt();

        syndicated = find.findSyndicate(syndEmp, syndId);
        if(!syndicated.getFlag()){
            System.out.println("Opps, Would you like to");
            System.out.println("[1] - List all syndicates members");
            System.out.println("[2] - exit");
            int key = scan.nextInt();
            if(key == 2){
                System.out.println("Leaving....");
                return syndEmp;
            }
            else if(key == 1){
                for(int i = 0; i<syndEmp.size();i++){
                    syndEmp.get(i).listSyndicate();
                }

                addServiceTax(employe, syndEmp);
            }
        }
        else{
            if(syndicated.getSyndicateId()>0){
                System.out.println("Enter the Tax Value: ");
                tax = scan.nextDouble();           
                syndicated.setServiceTax(tax);
                for(int i = 0; i<syndEmp.size(); i++){
                    if(syndicated.getSyndicateId() == syndEmp.get(i).getSyndicateId()){
                        syndEmp.get(i).setServiceTax(tax);
                        break;
                    }
                }
                System.out.println("-----------------------------------");
                System.out.println("          Tax Included!            ");
                System.out.println("-----------------------------------");
            }
        }
        
        return syndEmp;
    }
}
