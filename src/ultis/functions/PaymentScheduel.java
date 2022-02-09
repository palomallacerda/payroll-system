package src.ultis.functions;

import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.ultis.FindEmployee;

public class PaymentScheduel {
    String scheduelAux;
    FindEmployee find = new FindEmployee();
    Employees auxEmp;
    Scanner scan = new Scanner(System.in);
    String houry;
    String salaried; 
    String comission;
    String changeScheduel;
    int option;

    public void defaultScheduel(LinkedList<String> scheduel, Employees employee){
        if(employee.getEmployeeType().equals("Hourly")){
            houry = "weekly 1 friday";  //toda semanan das sextas
            scheduel.add(houry);
        }
        if(employee.getEmployeeType().equals("Commmission")){
            salaried = "weekly 2 friday"; //a cada 2 semanas as sextas
            scheduel.add(salaried);

        }
        if(employee.getEmployeeType().equals("Monthly Fixed")){
            comission = "monthly $"; //Ultimo dia do mês
            scheduel.add(comission);
        }
    }

    public void newScheduel(LinkedList<String> schedueles){
        System.out.println("--------- You can creat some new schedueles ----------");
        System.out.println("How many schedueles do you want to create?");
        int n = scan.nextInt();
        while(n != 0){
            System.out.println("\nEnter what new schedule you'd like to create");
            System.out.println("[1] Montly 1"); // dia 1 de todo mês
            System.out.println("[2] Montly 7"); // dia 7 de todo mês
            System.out.println("[3] Weekly 1 monday"); //toda segunda
            System.out.println("[4] Weekly 2 monday"); //a cada 2 semanas na segunda
            System.out.println("[5] Other");
            System.out.println("----------------------------------------------");
            int key = scan.nextInt();
            if(key == 1){
                schedueles.add("montly 1");
                System.out.println("\n ---- Montly 1 added -----");
            }
            else if(key == 2){
                schedueles.add("montly 7");

                System.out.println("\n ---- Montly 7 added -----");
            }
            else if(key == 3){
                schedueles.add("weekly 1 monday");

                System.out.println("\n ---- Weekly 1 monday added -----");
            }
            else if(key == 4){
                schedueles.add("weekly 2 monday");

                System.out.println("\n ---- Weekly 2 monday added -----");
            }
            else if(key == 5){
                scan.nextLine();
                String option = scan.nextLine();
                schedueles.add(option);
               
                System.out.println("\n"+ option+ " added");
            }
            else{
                System.out.println("Invalid input\n Try again");
                newScheduel(schedueles);
            }
            n-=1;

        }        

        System.out.println("----------------------------------");
        System.out.println("New schedueles sucessfully added!");
    }

    public void changePaymentSchedules(LinkedList<String> schedueles, LinkedList<Employees> employee){
        // Foi necessario criar outro método para diminuir a complexidade do código
        while(true){
            System.out.println("\n--------- Here is all the Avalible Scheduel options -----------");
            listAvalibleSchedules(schedueles);
            System.out.println("\n\nRemember by default all:\n----------------------\n\nHourly [weekly 1 friday]\nComissioned [monthly $]\nSalaried [weekly 2 friday]");
            System.out.println("----------------------");
            System.out.println("\nWould you like to:");
            System.out.println("[1] - Change a scheduel");
            System.out.println("[2] - Keep as default (Exit)");
            
            option = scan.nextInt();
           
            switch(option){
                case 1:
                    System.out.println("\nEnter the employee ID");
                    int id = scan.nextInt();
                    auxEmp = find.find(employee, id);
                    if(auxEmp.getName() == null){
                        System.out.println("Not a valid Id - Try again");
                        changePaymentSchedules(schedueles, employee);
                    }   
                    else{
                        scheduelRuning(schedueles);
                    }
                    break;
                case 2:
                    System.out.println("######### Okay, say bye! #######");
                    return;
                default:
                    System.out.println("Invalid option\nTry Again!");
                    changePaymentSchedules(schedueles, employee);
                    break;
            }
        
        }
    }
    // Método estava muito longo logo foi divido para melhor entendimento
    private void scheduelRuning(LinkedList<String> schedueles){
        System.out.println(auxEmp.getName()+"Is now a "+auxEmp.getPaymentScheduel());
        System.out.println("\nWhat new scheduel would you like to put:");
        listAvalibleSchedules(schedueles);
        int index = scan.nextInt();
        for(int i = 0; i < schedueles.size(); i++){
            if(index == i){
                changeScheduel = schedueles.get(i);
            }
        }
        if(changeScheduel == null){
            System.out.println("Option invalid");
        }
        else{
            if(auxEmp.getPaymentScheduel().equals(changeScheduel)){
                System.out.println("\n---- There is nothing to change ----");
                System.out.println(" ---- You already has this scheduel ----");
            }
            else{
                auxEmp.setPaymentScheduel(changeScheduel);
                System.out.println("Sucessfully changed to "+changeScheduel);
                System.out.println("\nClick [Enter] to continue");
                scan.nextLine();
                scan.nextLine();
            }
        }
    }
    public void listAvalibleSchedules(LinkedList<String> scheduel){
        for(int i = 0;i<scheduel.size(); i++){
            System.out.println("["+i+"] - "+scheduel.get(i));
        }
    }
}
