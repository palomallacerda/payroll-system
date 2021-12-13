package src.ultis.functions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;
import src.modes.Syndicate;
import src.modes.TimeCard;
import src.ultis.FindEmployee;

import java.time.LocalDate;


public class Payroll {
    Scanner scan = new Scanner(System.in);
    int todaySale;
    String date;
    double paymentValue;
    String today = LocalDate.now().toString();
    boolean todayFlag = false;

    public void runningTodayPayrool(LinkedList<Employees> employ, LinkedList<Syndicate> syndicate, LinkedList<String> scheduel){
        LinkedList<TimeCard> card = new LinkedList<>();
        ArrayList<LocalDate> todaySales = new ArrayList<>();
        ArrayList<Integer> sales = new ArrayList<>();

        System.out.println("############# Today's payroll is Loading #############");
        System.out.println("\n >>>>>>>>>>>> Today is "+ LocalDate.now()+" <<<<<<<<<<<<");
        for (String auxScheduel : scheduel) {
            String[] scheduelDiv = auxScheduel.split(" "); //divide a string em partes
            
            if(scheduelDiv[0].equals("weekly")){ //Pagamento semanal 

                for(int i = 0; i < employ.size();i++){
                    Employees aux = employ.get(i);
                    if(aux.getEmployeeType().equals("Hourly")){//Recebe de acordo com as horas
                        Hourly horista = (Hourly)employ.get(i);
                        card = horista.getTimeCard();
                        
                        for(int j = 0; j<card.size(); j++){
                            TimeCard auxCard = card.get(j);
                            if(auxCard.getToday().equals(today)){ //Verificando se as horas foram hoje
                                hourlyPayment(horista, syndicate);
                                todayFlag  = true;
                            }
                        }
                    }
                    else if(aux.getEmployeeType().equals("Commmission")){ //Recebe de acordo com as vendas
                        Salaried comissioned = (Salaried)employ.get(i);
                        sales = comissioned.getSale();
                        todaySales = comissioned.getSaleDate();
                        for(int j = 0; j<todaySales.size(); j++){
                            if(todaySales.get(j).toString().equals(today)){
                                comissionedPayment(comissioned, syndicate);
                                todayFlag  = true;
                            }
                        }

                    }
                    else if(aux.getEmployeeType().equals("Monthly Fixed")){
                        montlyPayment((Salaried)employ.get(i), syndicate);
                        todayFlag  = true;
                    }
                }
            }
            else if(scheduelDiv[0].equals("monthly")){//Pagamento mensal
                for(int i = 0; i < employ.size();i++){
                    Employees aux = employ.get(i);
                    if(aux.getEmployeeType().equals("Monthly Fixed")){ //Recebe fixo
                         montlyPayment((Salaried)employ.get(i), syndicate);
                         todayFlag  = true;
                    }
                    else if(aux.getEmployeeType().equals("Hourly")){//Recebe de acordo com as horas
                        Hourly horista = (Hourly)employ.get(i);
                        card = horista.getTimeCard();
                        
                        for(int j = 0; j<card.size(); j++){
                            TimeCard auxCard = card.get(j);
                            if(auxCard.getToday().equals(today)){ //Verificando se as horas foram hoje
                                hourlyPayment(horista, syndicate);
                                todayFlag  = true;
                            }
                        }
                    }
                    else if(aux.getEmployeeType().equals("Commmission")){ //Recebe de acordo com as vendas
                        Salaried comissioned = (Salaried)employ.get(i);
                        sales = comissioned.getSale();
                        todaySales = comissioned.getSaleDate();
                        for(int j = 0; j<todaySales.size(); j++){
                            if(todaySales.get(j).toString().equals(today)){
                                comissionedPayment(comissioned, syndicate);
                                todayFlag  = true;
                            }
                        }

                    }
                }
            } 
            else{
                System.out.println("Not a valid Scheduel\n");
            }
        }
        
        if(!todayFlag){
            System.out.println("-- [Any employee will receve payment today!] --");
        }
    }

    public void hourlyPayment(Hourly employe, LinkedList<Syndicate> syndicate){
        double hour = 20; //ganha a cada hora
    
        FindEmployee findSynd = new FindEmployee();
        String laspayment = LocalDate.now().toString();
        LinkedList<TimeCard> listaCard = new LinkedList<>();
        Syndicate hourlySynd;    
    
        listaCard = employe.getTimeCard();
        if(listaCard.isEmpty()){
            System.out.println("There isn't any hours registered");
            return;
        }
        
        employe.setLastPayDay(laspayment);
        int totalhours = 0;
        for(TimeCard auxtimeCard : listaCard){
            if(auxtimeCard.getExeededTime() != 0){
                paymentValue += (auxtimeCard.getWorkedhours()*hour)+(auxtimeCard.getWorkedhours()*(hour*1.5));
                totalhours += auxtimeCard.getWorkedhours();
                totalhours += auxtimeCard.getExeededTime();
            }
            else{
                paymentValue += (auxtimeCard.getWorkedhours()*hour);
                totalhours += auxtimeCard.getWorkedhours();

            }
        }
        System.out.println("\n**********************************************************");
        System.out.println("\n|[Id] "+employe.getId()+" >[Name] "+employe.getName()+"\nThe payment value is $"+ paymentValue);
        System.out.println("\n>> Worked "+totalhours+" hours");
        
        if(employe.getSyndicate()){
            hourlySynd = findSynd.findSyndicate(syndicate, (employe.getAge()*employe.getId())+1);
            paymentValue -= hourlySynd.getServiceTax();
            paymentValue -= hourlySynd.getSyndicateTax();
            System.out.println("\nSyndicate fee applyed");
            System.out.println("Now total payment is $"+paymentValue);
        }
        System.out.println("\n>> The method of payment is "+ employe.getPaymentWay());
        System.out.println("\n**********************************************************\n");
    
    }

    public void comissionedPayment(Salaried comissioned, LinkedList<Syndicate> syndicate){
        FindEmployee findSynd = new FindEmployee();
        paymentValue = 500; //2 semanas 
        double sale = 50;
        ArrayList<Integer> allSales = new ArrayList<>();
        Syndicate syndComisioned;

        allSales = comissioned.getSale();
        int amount = 0;
        for(int i = 0; i< allSales.size(); i++){
            double auxsale = allSales.get(i);
            paymentValue += sale*auxsale;
            amount += allSales.get(i);
        }
        System.out.println("\n*********************************************************");
        System.out.println("\n[Id] "+comissioned.getId()+" |[Name] "+comissioned.getName()+"\nPayment value is $"+ paymentValue);
        System.out.println("\n>> Has done "+amount+" sales");
        if(comissioned.getSyndicate()){
            syndComisioned = findSynd.findSyndicate(syndicate, (comissioned.getAge()*comissioned.getId())+1);
            paymentValue -= syndComisioned.getServiceTax();
            paymentValue -= syndComisioned.getSyndicateTax();
            System.out.println("\n~~ Syndicate fee applyed");
            System.out.println("~~ Now total payment is $"+paymentValue);
        }
        System.out.println("\n>> The method of payment is "+ comissioned.getPaymentWay());
        System.out.println("\n*********************************************************\n");
    }

    public void montlyPayment(Salaried montly, LinkedList<Syndicate> syndicates){
        paymentValue = 1000; //valor fixo mensal
        FindEmployee findSynd = new FindEmployee();
        Syndicate syndMontly;

        System.out.println("\n*********************************************************");
        System.out.println("\n[Id] "+montly.getId()+" |[Name] "+montly.getName()+"\nPayment value is $"+ paymentValue);
        if(montly.getSyndicate()){
            syndMontly = findSynd.findSyndicate(syndicates, (montly.getAge()*montly.getId())+1);
            paymentValue -= syndMontly.getServiceTax();
            paymentValue -= syndMontly.getSyndicateTax();
            System.out.println("\n~~ Syndicate fee applyed");
            System.out.println("~~ Now total payment is $"+paymentValue);
        }
        System.out.println("\n > The method of payment is "+ montly.getPaymentWay());
        System.out.println("\n*********************************************************\n");
    }


}


