package src.modes;
import java.util.ArrayList;

/*Empregados comissionados e fixos no mês*/
public class Salaried extends Employees{

    private ArrayList<Integer> sales = new ArrayList<>();
    int i = 0;
    public void setSale(int saleE) {
        sales.add(i, saleE);
        i+=1;
       //Apenas os comissionados lançam vendas
    }

     public ArrayList<Integer> getSale() {
        return sales;  
     }


     public String listSalaried(){
        return "[ID]- "+ super.getId()+"\n[Name] - "+super.getName()+
        "\n[Address] - "+ super.getAddress()+
        "\n[Is in syndicate] - "+ super.getSyndicate()+
        "\n[Employee Type] - "+ super.getEmployeeType()+
        "\n[Payment way] - "+ super.getPaymentWay()+
        "\n[Sales]-" +getSale()+
        "\n--------------------------------------------";
    }

}
