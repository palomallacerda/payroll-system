package src.ultis.functions;
import src.modes.*;
import src.ultis.FindEmployee;

import java.util.LinkedList;
import java.util.Scanner;

public class SethoursEmployee {    
 
    Scanner scan = new Scanner(System.in);
    FindEmployee findemp = new FindEmployee();
    Employees employeesHour = new Employees();
    Hourly hourlyEmploy = new Hourly();
    TimeCard timeCard = new TimeCard();
    int id;
    /*Criar uma lista para os empregados que são horístas 
    para que assim a lista do cartão seja com outro ID*/
    public void settingWorkedTime(LinkedList <Employees> employee){
        System.out.println("Enter the employee ID");
        id = scan.nextInt();
        scan.nextLine();
        hourlyEmploy = findemp.findHourly(employee, id);
        
        if(hourlyEmploy.getName() != null){ //validando se retornou vazio

            if(hourlyEmploy.getEmployeeType().equals("Hourly"))
            {

                System.out.print("Please enter the time of cheackIn[0h - 24h]: ");
                int checkin = scan.nextInt();
                if((checkin < 1 || checkin >24)){
                    System.out.println("Invalid Number, verify your checkin time!");
                    settingWorkedTime(employee);
                }
                
                System.out.print("Please enter the time of cheackOut [0h - 24h]: ");
                int checkout = scan.nextInt();
                if((checkout < 1 || checkout >24 || checkout < checkin )){
                    System.out.println("Invalid Number, verify your checkout time!");
                    settingWorkedTime(employee);
                }
                

                timeCard.setWorkedhours(checkin, checkout);
                timeCard.setToday();

                if((timeCard.getWorkedhours()-8)>0){ //Trabalhou mais que 8 horas rebece extra
                    timeCard.setExeededTime();
                } 
                
                System.out.println("--------------------------------------------");
                System.out.println(">>>>>>> Today "+ timeCard.getToday()+ " <<<<<<<<");
                System.out.println("\n"+hourlyEmploy.getName()+" Worked "+ timeCard.getWorkedhours()+" hours");
                if(timeCard.getExeededTime()>0){
                    System.out.println("Exeeded hours: "+timeCard.getExeededTime());
                }
                
                hourlyEmploy.setTimeCard(timeCard); //setando o array de timecard
                System.out.println("\nGreat! the timecard has been added");
                System.out.println("--------------------------------------------");
            }
            else{
                //assalariado, recebe por quantidade de vendas
                System.out.println("This employee does not has fixed hours!");
            }
        }
        else{
            System.out.println("\nThis employee's id doesn't exist\nTry Again!!\n");
        }

    }

}
