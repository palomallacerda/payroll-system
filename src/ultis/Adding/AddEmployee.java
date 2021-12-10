package src.ultis.Adding;
import java.util.LinkedList;
import java.util.Scanner;
import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;
import src.ultis.SetSalary;
import src.ultis.functions.PaymentScheduel;

public class AddEmployee {
    
    Scanner scann = new Scanner(System.in);
    SetSalary setsalary = new SetSalary();
    Employees employee = new Employees();
    Hourly hourlyEmploy = new Hourly();
    AddHourly addHourly = new AddHourly();
    Salaried salariedEmploy = new Salaried();
    AddSalaried addSalaried = new AddSalaried();
    PaymentScheduel paySchedueles = new PaymentScheduel();
    int[] employeesCounter = {0};
    int[] syndicatesCounter = {-1};

    public Employees addNewEmployee(int id, LinkedList<String> scheduel){
        System.out.println("\n############ Enter the employee infomation #################");
        while(true){
            System.out.println("\nEmployee type:\n[1] - Hourly\n[2] - Monthly Fixed\n[3] - Commissioned");
            System.out.print("--> ");
            int key = scann.nextInt();
            if(key == 1) {  
                hourlyEmploy = addHourly.AddHourly();
                hourlyEmploy.setEmployeeType("Hourly");
                employee = hourlyEmploy;
                employee.setPaymentScheduel("weekly 1 friday");
                break;
            }else if(key == 2){
                salariedEmploy = addSalaried.addSalaried();
                salariedEmploy.setEmployeeType("Monthly Fixed");
                employee = salariedEmploy;
                employee.setPaymentScheduel("weekly 2 friday");
                break;
            }else if(key == 3){
                salariedEmploy = addSalaried.addSalaried();
                salariedEmploy.setEmployeeType("Commmission");
                employee = salariedEmploy;
                employee.setPaymentScheduel("monthly $");
                break;
            }else{
                System.out.println("Invalid input, Try again!");
            }
        }
       
        paySchedueles.defaultScheduel(scheduel, employee);    
        
        
        employee.setId(id);
       
        return employee;
    }

    public void updateNewEmployee(Employees empAux, LinkedList<Employees> employeeAdd){
        System.out.println("Set the employee type that you would like to put:");
        while(true){
            System.out.println("\nEmployee type:\n[1] - Hourly\n[2] - Monthly Fixed\n[3] - Commissioned");
            System.out.print("--> ");
            int key = scann.nextInt();
            if(key == 1) {  
                hourlyEmploy = addHourly.updateHourly(empAux);
                employeeAdd.add(hourlyEmploy);
                System.out.println(empAux.getEmployeeType() + " Changed to Hourly");
                break;
            }else if(key == 2){
                salariedEmploy = addSalaried.updateSalariedMonthly(empAux);
                employeeAdd.add(salariedEmploy);
                System.out.println(empAux.getEmployeeType() + " Changed to Monthly Fixed");
                break;
            }else if(key == 3){
                salariedEmploy = addSalaried.updateCommissioned(empAux);
                employeeAdd.add(salariedEmploy);
                System.out.println(empAux.getEmployeeType() + " Changed to Comissioned");
                break;
            }else{
                System.out.println("Invalid input, Try again!");
            }
        }
    }


    public int[] getSyndicatesCounter() {
        return this.syndicatesCounter;
    }

    public int[] getEmployeesCounter() {
        return this.employeesCounter;
    }
}
