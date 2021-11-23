package src.modes;

// import java.util.ArrayList;

public class Hourly extends Employees{
    private int workedhours;
    // ArrayList <TimeCard> timeCard = new ArrayList<>();
    
    public Hourly(){
        workedhours = 0;
    }
    public void setWorkedhours(int workedhours) {
        this.workedhours = workedhours;
    }
    public int getWorkedhours() {
        return this.workedhours;
    }
        
    public String listHourlyEmployee(){
        return "[ID]- "+ super.getId()+"\n[Name] - "+super.getName()+
        "\n[Address] - "+ super.getAddress()+
        "\n[Is in syndicate] - "+ super.getSyndicate()+
        "\n[Employee Type] - "+ super.getEmployeeType()+
        "\n[Payment way] - "+ super.getPaymentWay()+
        "\n[Worked hours]"+ this.getWorkedhours();
    }

    
}
