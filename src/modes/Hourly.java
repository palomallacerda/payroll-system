package src.modes;

import java.util.LinkedList;

public class Hourly extends Employees{    
    LinkedList <TimeCard> timeCard = new LinkedList<>();
    int i = 0;

    public void setTimeCard(TimeCard card) {
        timeCard.add(card);
    }
        
    public void listHourlyEmployee(){
        System.out.println("[ID]- "+ super.getId()+"\n[Name] - "+super.getName()+
        "\n[Address] - "+ super.getAddress()+
        "\n[Is in syndicate] - "+ super.getSyndicate()+
        "\n[Employee Type] - "+ super.getEmployeeType()+
        "\n[Payment way] - "+ super.getPaymentWay());
        System.out.println("--------------------");
        System.out.println("\n   [Time Card] ");
        if(!timeCard.isEmpty()){
            for (TimeCard carde : timeCard) {
                carde.printTimecard();
                System.out.println("--------------------");
            }
        }
        else System.out.println("Empty....");

    }
}
