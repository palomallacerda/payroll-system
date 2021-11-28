package src.ultis.functions;
import java.util.LinkedList;

import src.modes.Employees;
import src.modes.Syndicate;

public class AddSyndicate {
    Syndicate syndAux = new Syndicate();
    Employees employesAux = new Employees();

    public LinkedList<Syndicate> AddNewEmploy(LinkedList<Employees> employees, LinkedList<Syndicate> empSynd){
        int i  = employees.size()-1;
        do{
            System.out.println(i);
            employesAux = employees.get(i);
            if(employesAux.getSyndicate() && !employesAux.getFlag()){
                syndAux.setFlag(true);
                syndAux.setName(employesAux.getName());
                syndAux.setSyndicateId(employesAux.getAge(), employesAux.getId());
                empSynd.add(syndAux);
                employesAux.setFlag(true);
            }
            i-=1;
        }
        while(i>0);       
        //Listar se ta certo
        // System.out.println("Verificando os atuais");
        // for (int k = 0; k<empSynd.size(); k++) {
        //     empSynd.get(k).listSyndicate();
        // }
        return empSynd;
    }

}
