package src.modes;
import java.util.Scanner;


public class Employees { //classe
    Scanner scan = new Scanner(System.in);
    protected String name; 
    protected String employeeType;
    protected int age;
    protected boolean syndicate;
    protected String address; 
    protected String paymentWay; 
    
    int id = 0; 
 
    
    public void setName(String name) {
        this.name = name;  //Vê uma forma de retirar\n do scan (NextLine)
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
    public void setSyndicate(boolean syn){
        this.syndicate = syn;
    }
    public void setSyndicate(String syndicate) {
        if(syndicate.equals("Y")){
            this.syndicate = true;
        }
        else this.syndicate = false;

    }
    public boolean getSyndicate() {
        return this.syndicate;
    }
    public void setAddress(String address) {
        this.address = address;
        //verificar pois ele só lê a primeira linha
    }
    public String getAddress() {
        return this.address;
    }

    public void setAge(int age){
        this.age = age;
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

    public void setEmployeeType(String employeeType) {
        //add dps
        this.employeeType = employeeType;
        //Criar forma de seleção para cada payment
    }
    public String getEmployeeType() {
        return this.employeeType;
    }

    public void printEmployee(){
        System.out.println("[ID]- "+ this.getId()+"\n[Name] - "+this.getName()+
        "\n[Address] - "+ this.getAddress()+
        "\n[Is in syndicate] - "+ this.getSyndicate()+
        "\n[Employee Type] - "+ this.getEmployeeType()+
        "\n[Payment way] - "+ this.getPaymentWay());
        System.out.println("---------------------------------------"); 
       
    }

}
