package src.ultis;
import src.modes.*;

import java.util.LinkedList;
import java.util.Scanner;

public class ListAll {
    LinkedList<Employees> employee = new LinkedList<>();
    LinkedList<Syndicate> syndEmp = new LinkedList<>();
    Hourly hourlyEmploy = new Hourly();
    Salaried salariedEmploy = new Salaried();
    Scanner scann = new Scanner(System.in);

    public void listEmploy(LinkedList <Employees> employees, LinkedList<Syndicate> syndEmp){
        System.out.println("Witch option would you like:");
        System.out.println("[1] - List basic Employee");
        System.out.println("[2] - List hourly Employee");
        System.out.println("[3] - List salaried Employee");
        System.out.println("[4] - List Syndicate Employee");

        int key = scann.nextInt();
        switch(key){
            case 1:
                for (Employees employe : employees) {
                    employe.printEmployee();
                }
                break;
            case 2:
                for (Employees employe : employees) {
                    if(employe.getEmployeeType().equals("Hourly")){
                        hourlyEmploy = (Hourly) employe;
                        hourlyEmploy.listHourlyEmployee();
                    }
                }
                break;
            case 3:
                for (Employees employe : employees) {
                    if(employe.getEmployeeType().equals("Monthly Fixed") || employe.getEmployeeType().equals("Commmission")){
                        salariedEmploy = (Salaried) employe;
                        salariedEmploy.listSalaried();
                    }
                }
                break;
            case 4:
                if(syndEmp.isEmpty()){
                    System.out.println("There isn't any syndicate member");
                }
                else{
                    for(Syndicate employe: syndEmp){
                        employe.listSyndicate();
                    }
                }
                break;
            default:
                break;
        }
    }
}
