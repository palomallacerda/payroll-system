package src.ultis.functions;

import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.modes.Syndicate;
import src.ultis.FindEmployee;

public class ServiceTax {
    LinkedList <Syndicate> syndEmploy = new LinkedList<>();
    Employees aux = new Employees();
    Scanner scan = new Scanner(System.in);
    FindEmployee find = new FindEmployee();
    double tax;
    int syndId;
    public LinkedList<Syndicate> addServiceTax(LinkedList <Employees> employe, LinkedList<Syndicate> syndEmp){
        Syndicate syndicated = new Syndicate();
        System.out.println("Enter the Syndicate Id: ");
        syndId = scan.nextInt();

        syndicated = find.findSyndicate(syndEmp, syndId);
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

            System.out.println("Tax added!");
        }
        return syndEmp;
    }
}
