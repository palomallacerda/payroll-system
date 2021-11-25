package src.ultis.functions;
import src.modes.*;
import java.util.Scanner;

public class AddHourly {

    Hourly hourlyEmploy = new Hourly();
    Scanner scann = new Scanner(System.in);
    
    public Hourly AddHourly(){
        System.out.print("Name - ");
        String name = scann.next();
        hourlyEmploy.setName(name);
        System.out.print("Age - ");
        int age = scann.nextInt();
        hourlyEmploy.setAge(age);
        System.out.print("Address - ");
        String address = scann.next();
        hourlyEmploy.setAddress(address);
        
        
        while(true){
            System.out.println("\nPayment way:\n[1] - Mail paycheck\n[2] - Paycheck\n[3] - Deposit in bank account");
            System.out.print("--> ");
            int way = scann.nextInt();
            if(way == 1) {  
                hourlyEmploy.setPaymentWay("Mail paycheck");
                break;
            }else if(way == 2){
                hourlyEmploy.setPaymentWay("Paycheck");
                break;
            }else if(way == 3){
                hourlyEmploy.setPaymentWay("Deposit in bank account");
                break;
            }else{
                System.out.println("Invalid input, Try again!"); ///retornar pro inicio do sistema
            }
        }
        while(true){
            System.out.println("\nEmployee is part of syndicate:\n[Y] - Yes\n[N] - No"); //Metodo de pagamento
            System.out.print("--> ");
            String key = scann.next();
       
            if(key.equals("Y") || key.equals("N")){
                hourlyEmploy.setSyndicate(key);
                break;
            }
            else{
                System.out.println("Invalid input, Try again using upper case!");
            }
        }

        return hourlyEmploy;
    
    }

}
