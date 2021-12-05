package src.modes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;

/*Empregados comissionados e fixos no mês*/
public class Salaried extends Employees{

    private ArrayList<LocalDate> saleDate = new ArrayList<>();
    private ArrayList<Integer> sales = new ArrayList<>();
    protected String lastPayDay;
    int i = 0;
    int j = 0;

    public void setLastPayDay(String lastPayDay) {
        this.lastPayDay = lastPayDay;
    }
    public String getLastPayDay() {
        return this.lastPayDay;
    }
    public void setSale(int saleE) {
        sales.add(i, saleE);
        i+=1; //Apenas os comissionados lançam vendas
    }
    
    public ArrayList<Integer> getSale() {
        return sales;  
    }

    public void setDate(LocalDate data)  {
        saleDate.add(data);            
    }
    public ArrayList<LocalDate> getSaleDate() {
        return saleDate;
    }

    public void listSalaried(){
        System.out.println("[ID]- "+ super.getId()+"\n[Name] - "+super.getName()+
        "\n[Address] -> "+ super.getAddress()+
        "\n[Is in syndicate] -> "+ super.getSyndicate()+
        "\n[Employee Type] -> "+ super.getEmployeeType()+
        "\n[Payment way] ->"+ super.getPaymentWay()+
        "\n[Sales] ->"+getSale());
        System.out.println("[Dates] ->");
        for(int k = 0; k< saleDate.size();k++){
            System.out.println(saleDate.get(k)); 
        }
        System.out.println("\n--------------------------------------------");
    }
    
}
