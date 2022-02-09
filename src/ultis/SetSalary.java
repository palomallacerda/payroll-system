package src.ultis;
import src.modes.*;

/*Setar o salario para cada empregado*/ 
public class SetSalary {
    private double month;
    private double week;
    private double commission;
    Employees employ  = new Employees();
    TimeCard timecard = new TimeCard();

    public SetSalary(){ //construtor
        this.month = 0.0;
        this.week = 0.0;
        this.commission = 0.0;
    }   
    
    /*metodos setter and getter*/
    public void setCommission(double commission) {
        this.commission = commission;
    }
    public double getCommission() {
        return this.commission;
    }
    public void setMonth(double month) {
        this.month = month;
    }
    public double getMonth() {
        return this.month;
    }
    public void setWeek(double week) {
        this.week = week;
    }
    public double getWeek() {
        return this.week;
    }

    public void salary(){
        int exeededTime = 0;
        if(employ.getEmployeeType().equals("Hourly")){
            exeededTime =  timecard.getExeededTime();
            System.out.println("This employee worked"+ exeededTime+"more than expected");
        }
        if(employ.getSyndicate()){
            System.out.println("Syndicate will discount the tax");

        }   
    }

}
