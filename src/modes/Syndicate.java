package src.modes;

import java.util.ArrayList;
import java.util.LinkedList;

import src.ultis.FindEmployee;

public class Syndicate {
    private ArrayList<Integer> employeeId = new ArrayList<>();
    private double syndicateTax;
    private double serviceTax;
    private int syndicateId;
    Employees employeeSynd = new Employees();
    FindEmployee find = new FindEmployee();
    
    public void syndicate(){
        syndicateTax = 40.0; //Taxa do sindicado é 40 por padrão
        serviceTax = 0.0;
        syndicateId = 0;
    }
    public ArrayList<Integer> getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(LinkedList<Employees> employees){ 
        if(employees.isEmpty()){
            System.out.println("Sorry there isn't any employee");
        }
        else{
            for(int i = 0; i < employees.size();i++){  
                Employees aux = employees.get(i);
                if(aux.getSyndicate()){
                    employeeId.add(this.syndicateId);
                    syndicateId +=1;
                }
            }
            System.out.println("Id's do sindicato colocados");
        }
    }
    public double getServiceTax() {
        return this.serviceTax;
    }
    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }
    public void setSyndicateId(int syndicateId) {
        this.syndicateId = syndicateId;
    }
    public int getSyndicateId() {
        return this.syndicateId;
    }

}
