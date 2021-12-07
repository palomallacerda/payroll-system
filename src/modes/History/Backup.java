package src.modes.History;

import java.util.LinkedList;
import src.modes.Employees;
import src.modes.Syndicate;

import src.ultis.functions.PaymentScheduel;

public class Backup {
    private PaymentScheduel schedueles  = new PaymentScheduel();
    private LinkedList<Employees> employees = new LinkedList<>();
    private LinkedList<Syndicate> syndicates = new LinkedList<>();
    private int employeCounter = 0;
    private int syndCounter = -1;

    public Backup(PaymentScheduel scheduel, LinkedList<Employees> auxEmp, LinkedList<Syndicate> auxSynd){
        this.schedueles = scheduel;
        this.employees = auxEmp;
        this.syndicates = auxSynd;
    }
    public Backup(){
        //just an option
    }
    public void setEmployees(LinkedList<Employees> employees) {
        this.employees = employees;
    }
    public LinkedList<Employees> getEmployees() {
        return this.employees;
    }
    public void setSchedueles(PaymentScheduel schedueles) {
        this.schedueles = schedueles;
    }
    public PaymentScheduel getSchedueles() {
        return this.schedueles;
    }
    public void setSyndicates(LinkedList<Syndicate> syndicates) {
        this.syndicates = syndicates;
    }
    public LinkedList<Syndicate> getSyndicates() {
        return this.syndicates;
    }

    public void setEmployeCounter(int employeCounter) {
        this.employeCounter = employeCounter;
    }
    public int getEmployeCounter() {
        return this.employeCounter;
    }
    public void setSyndCounter(int syndCounter) {
        this.syndCounter = syndCounter;
    }
    public int getSyndCounter() {
        return this.syndCounter;
    }
}
