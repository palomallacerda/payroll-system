package src.modes;
import java.util.Scanner;

// Por ser a super classe foi preciso analisar melhor o uso dos métodos 
// nas subclasses
public class Employees { //classe
    Scanner scan = new Scanner(System.in);
    protected String name; 
    protected String employeeType;
    protected int age;
    protected boolean syndicate;
    protected String address; 
    protected String paymentWay; 
    protected String paymentScheduel;
    private boolean flag = false;
    
    int id = 0; 

    public void setPaymentScheduel(String paymentScheduel) {
        this.paymentScheduel = paymentScheduel;
    }
    
    public String getPaymentScheduel() {
        return this.paymentScheduel;
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    
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
        this.employeeType = employeeType;
    }
    
    public String getEmployeeType() {
        return this.employeeType;
    }

    public void printEmployee(){
        System.out.println("[ID]- "+ this.getId()+"\n[Name] - "+this.getName()+
        "\n[Address] - "+ this.getAddress()+
        "\n[Is in syndicate] - "+ this.getSyndicate()+
        "\n[Employee Type] - "+ this.getEmployeeType()+
        "\n[Payment way] - "+ this.getPaymentWay()+
        "\n[Payment Scheduel] - "+this.getPaymentScheduel());
        System.out.println("---------------------------------------"); 
       
    }

}
