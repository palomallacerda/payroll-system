package src.modes;


public class Employees { //classe
    String name; 
    String address; 
    int paymentType;
    int paymentWay; 
    int id; 

    public void employee(String name, String address, int paymentType, int paymentWay, int id){ //metodo
        this.name = name;
        this.address = address;
        this.paymentType = paymentType;
        this.paymentWay = paymentWay;
        this.id = id;
    }

    public String printEmployee(){
        return "\nEmployee UNIC ID: "+ this.id +
               "\nEmployee name: "+ this.name +
               "\nEmployee address: "+ this.address+
               "\nEmployee payment type: "+ this.paymentType;
    }
}
