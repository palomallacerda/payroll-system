package src.ultis;
import src.modes.*;
import src.ultis.*;

import java.util.LinkedList;
import java.util.Scanner;

public class SethoursEmployee {    
 
    Scanner scan = new Scanner(System.in);
    FindEmployee findemp = new FindEmployee();
    Employees employeesHour = new Employees();
    TimeCard timeCard = new TimeCard();
    int ID;
    /*Criar uma lista para os empregados que são horístas 
    para que assim a lista do cartão seja com outro ID*/
    public void settingWorkedTime(LinkedList <Employees> employee){
        System.out.println("Enter the employee ID");
        ID = scan.nextInt();
        employeesHour = findemp.find(employee, ID);
        if(employeesHour.getEmployeeType().equals("Hourly"))
        {
            System.out.print("Please enter the time of cheackIn: ");
            timeCard.setCheckIn(scan.nextInt());  
    
            System.out.println("Please enter the time of cheackOut ");
            timeCard.setCheckOut(scan.nextInt());
    
            employeesHour.setWorkedhours(timeCard.getCheckOut()-timeCard.getCheckIn());
            timeCard.setExeededTime(employeesHour.getWorkedhours()-8);
        }
    }
}
