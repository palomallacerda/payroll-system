package src.modes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/*Empregados comissionados e fixos no mês*/
public class Salaried extends Employees{

    ArrayList<Date> date = new ArrayList<>();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");  
    private ArrayList<Integer> sales = new ArrayList<>();
    int i = 0, j = 0;
    public void setSale(int saleE) {
        sales.add(i, saleE);
        i+=1; //Apenas os comissionados lançam vendas
    }
    
    public ArrayList<Integer> getSale() {
        return sales;  
    }

    public void setDate(String data) throws ParseException {
        date.add(format.parse(data));              
    }

    public void listSalaried(){
        System.out.println("[ID]- "+ super.getId()+"\n[Name] - "+super.getName()+
        "\n[Address] -> "+ super.getAddress()+
        "\n[Is in syndicate] -> "+ super.getSyndicate()+
        "\n[Employee Type] -> "+ super.getEmployeeType()+
        "\n[Payment way] ->"+ super.getPaymentWay()+
        "\n[Sales] ->"+getSale());
        System.out.println("[Dates] ->");
        for(int k = 0; k< date.size();k++){
            System.out.println(date.get(k).toString()); 
        }
        System.out.println("\n--------------------------------------------");
    }
    
}
