package src.modes;
import java.util.Scanner;

public class Employees { //classe
    Scanner scan = new Scanner(System.in);
    String name; 
    int age;
    String address; 
    String paymentWay; 
    int paymentType;
    int id = 0; 

 
    public void setName() {
        this.name = scan.next();  //Vê uma forma de retirar\n do scan (NextLine)
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }

    public void setAddress() {
        this.address = scan.next();
        //verificar pois ele só lê a primeira linha
    }
    public String getAddress() {
        return this.address;
    }

    public void setAge(){
        this.age = scan.nextInt();
    }
    public int getAge() {
        return this.age;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }
    public String getPaymentWay() {
        return this.paymentWay;
    }

    public void setPaymentType() {
        //add dps
        this.paymentType = scan.nextInt();
        //Criar forma de seleção para cada payment
    }
    public void employee(String name, String address, int age, int paymentType, String paymentWay, int id){ //metodo
        this.name = name;
        this.address = address;
        this.age = age;
        this.paymentType = paymentType;
        this.paymentWay = paymentWay;
        this.id = id;
    } //Analisar se é viavel

    // public String printEmployee(){
    //     return "\nEmployee UNIC ID: "+ this.id +
    //            "\nEmployee name: "+ this.name +
    //            "\nEmployee age "+ this.age+
    //            "\nEmployee address: "+ this.address+
    //            "\nEmployee payment type: "+ this.paymentType;
    // }
}
