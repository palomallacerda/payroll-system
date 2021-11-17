package src.ultis;
import src.modes.*;

import java.util.LinkedList;
import java.util.Scanner;

public class SethoursEmployee {    
 
    Scanner scan = new Scanner(System.in);
    FindEmployee findemp = new FindEmployee();
    Employees employeesHour = new Employees();
    TimeCard timeCard = new TimeCard();
    int id;
    /*Criar uma lista para os empregados que são horístas 
    para que assim a lista do cartão seja com outro ID*/
    public void settingWorkedTime(LinkedList <Employees> employee){
        System.out.println("Enter the employee ID");
        id = scan.nextInt();
        employeesHour = findemp.find(employee, id);
        if(employeesHour.getName() != null){

            if(employeesHour.getEmployeeType().equals("Hourly"))
            {
                System.out.print("Please enter the time of cheackIn[0h - 24h]: ");
                int checkin = scan.nextInt();
                if((checkin < 1 || checkin >24)){
                    System.out.println("Invalid Number, verify your checkin time!");
                    settingWorkedTime(employee);
                }
                else{
                    timeCard.setCheckIn(checkin);  
                }
                
                System.out.print("Please enter the time of cheackOut [0h - 24h]: ");
                int checkout = scan.nextInt();
                if((checkout < 1 || checkout >24 || checkout < checkin )){
                    System.out.println("Invalid Number, verify your checkout time!");
                    settingWorkedTime(employee);
                }
                else{
                    timeCard.setCheckOut(checkout);  
                }
                
                
                employeesHour.setWorkedhours(timeCard.getCheckOut()-timeCard.getCheckIn());
                if((employeesHour.getWorkedhours()-8)>0){
                    timeCard.setExeededTime(employeesHour.getWorkedhours()-8);
                } 
                System.out.println(employeesHour.getName()+" Worked "+(timeCard.getCheckOut()-timeCard.getCheckIn())+" hours");
                System.out.println("\nGreat! the timecard has been added");
            }
            else if(employeesHour.getEmployeeType().equals("Monthly Fixed")){
                   /*8 horas por dia 5 dias por semana*/
                    System.out.println("\nThis employee is monthly fixed\nso works 8hours per day");
                    employeesHour.setWorkedhours(8*20);
            }
            else{
                //assalariado, recebe por quantidade de vendas
                System.out.println("This employee is commmissioned, it hasn't fixed hours!");
            }
        }
        else{
            System.out.println("\nThis employee's id doesn't exist\nTry Again!!\n");
            settingWorkedTime(employee);
        }

    }
}
