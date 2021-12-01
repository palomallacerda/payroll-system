package src.modes;

public class Syndicate { 
    private String name;
    private double syndicateTax; //taxa do sindicato
    private double serviceTax;  //taxa por serviço
    private int syndicateId;
    private boolean flag = false;

    public Syndicate(){ 
        syndicateTax = 40.0; //Taxa do sindicado é 40 por padrão
        serviceTax = 10.0;
        syndicateId = 0;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag(){
        return this.flag;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public double getServiceTax() {
        return this.serviceTax;
    }
    public void setSyndicateTax(double syndicateTax) {
        this.syndicateTax = syndicateTax;
    }
    public void setServiceTax(double serviceTax) {
        this.serviceTax += serviceTax;
    }
    public double getSyndicateTax() {
        return this.syndicateTax;
    }

    public void setSyndicateId(int id) {
        this.syndicateId = id;
    }
    public void setSyndicateId(int age, int id) {
        this.syndicateId = (age*id)+1;
    }
    public int getSyndicateId() {
        return this.syndicateId;
    }    

    public void listSyndicate(){
        System.out.println("[Name]: "+this.name);
        System.out.println("[Syndicate Id]:"+ this.syndicateId);
        System.out.println("[Service Tax]: "+ this.serviceTax);
        System.out.println("[Syndicate Tax]: "+ this.syndicateTax);
        System.out.println("[Flag]: "+this.flag);
        System.out.println("------------------------------------");
    }
}
