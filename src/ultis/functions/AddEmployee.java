package src.ultis.functions;
import java.util.LinkedList;
import java.util.Scanner;
import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;
import src.ultis.SetSalary;

public class AddEmployee {
    
    Scanner scann = new Scanner(System.in);
    SetSalary setsalary = new SetSalary();
    Employees employee = new Employees();
    Hourly hourlyEmploy = new Hourly();
    AddHourly addHourly = new AddHourly();
    Salaried salariedEmploy = new Salaried();
    AddSalaried addSalaried = new AddSalaried();

    public Employees addNewEmployee(int id){
        System.out.println("\n############ Enter the employee infomation #################");
        while(true){
            System.out.println("\nEmployee type:\n[1] - Hourly\n[2] - Monthly Fixed\n[3] - Commissioned");
            System.out.print("--> ");
            int key = scann.nextInt();
            if(key == 1) {  
                hourlyEmploy = addHourly.AddHourly();
                hourlyEmploy.setEmployeeType("Hourly");
                employee = hourlyEmploy;
                break;
            }else if(key == 2){
                salariedEmploy = addSalaried.addSalaried();
                salariedEmploy.setEmployeeType("Monthly Fixed");
                employee = salariedEmploy;
                break;
            }else if(key == 3){
                salariedEmploy = addSalaried.addSalaried();
                salariedEmploy.setEmployeeType("Commmission");
                employee = salariedEmploy;
                break;
            }else{
                System.out.println("Invalid input, Try again!");
            }
        }
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
}
