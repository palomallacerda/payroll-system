package src.ultis.functions;
import java.util.Scanner;
import src.modes.Salaried;

public class AddSalaried {
    Salaried salariedEmploy = new Salaried();
    Scanner scann = new Scanner(System.in);
    
    public Salaried addSalaried(){
        System.out.print("Name - ");
        String name = scann.next();
        salariedEmploy.setName(name);
        System.out.print("Age - ");
        int age = scann.nextInt();
        salariedEmploy.setAge(age);
        System.out.print("Address - ");
        String address = scann.next();
        salariedEmploy.setAddress(address);
        
        while(true){
            System.out.println("\nPayment way:\n[1] - Mail paycheck\n[2] - Paycheck\n[3] - Deposit in bank account");
            System.out.print("--> ");
            int way = scann.nextInt();
            if(way == 1) {  
                salariedEmploy.setPaymentWay("Mail paycheck");
                break;
            }else if(way == 2){
                salariedEmploy.setPaymentWay("Paycheck");
                break;
            }else if(way == 3){
                salariedEmploy.setPaymentWay("Deposit in bank account");
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
                salariedEmploy.setSyndicate(key);
                break;
            }
            else{
                System.out.println("Invalid input, Try again using upper case!");
            }
        }

        return salariedEmploy;
    
    }
}
