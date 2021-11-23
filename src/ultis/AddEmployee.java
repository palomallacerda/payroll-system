package src.ultis;
import java.util.Scanner;
import src.modes.Employees;
import src.modes.Hourly;
import src.modes.Salaried;

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
}
