package src.modes;
import java.util.ArrayList;
import java.util.Scanner;


public class Employees { //classe
    Scanner scan = new Scanner(System.in);
    private ArrayList<Integer> sales = new ArrayList<>();
    private String name; 
    private String employeeType; //Mudar pra uma lista talvez?
    private int age;
    private boolean syndicate;
    private String address; 
    private String paymentWay; 
    private int workedhours;
    
    int id = 0; 
    int i = 0;
 
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
    public void setWorkedhours(int workedhours) {
        this.workedhours = workedhours;
    }
    public int getWorkedhours() {
        return workedhours;
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

    public void setEmployeeType(String employeeType) {
        //add dps
        this.employeeType = employeeType;
        //Criar forma de seleção para cada payment
    }
    public String getEmployeeType() {
        return this.employeeType;
    }

    public void setSale(int saleE) {
        sales.add(i, saleE);
        i+=1;
    }

     public ArrayList<Integer> getSale() {
         return this.sales;    
     }
    public void employee(String name, String address, ArrayList<Integer> sales, boolean syndicate,String employeeType, String paymentWay, int id){ //metodo
        this.name = name;
        this.syndicate = syndicate;
        this.address = address;
        this.sales = sales;
        this.employeeType = employeeType;
        this.paymentWay = paymentWay;
        this.id = id;
    } //Analisar se é viavel

}
