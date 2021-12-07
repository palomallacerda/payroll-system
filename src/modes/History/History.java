package src.modes.History;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import src.ultis.functions.PaymentScheduel;

public class History extends Default{
    ArrayList<Backup> states = new ArrayList<>();
    int head = 0;
    Scanner scan = new Scanner(System.in);

    public History(){
        Backup inicialization = new Backup(new PaymentScheduel(),new LinkedList<>(), new LinkedList<>());
        this.setStates(inicialization);
        this.head-=1;
        
    }
    public void setHead(int head) {
        this.head = head;
    }
    public int getHead() {
        return this.head;
    }
    public ArrayList<Backup> getStates() {
        return this.states;
    }
    public void setStates(ArrayList<Backup> states) {
        this.states = states;
    }

    @Override
    public void setStates(Backup auxState){
        int i = 0;

        for(Backup state: states){
            if(i > this.head){
                states.remove(state);
            }
            i+=1;
        }

        this.head+=1;

        this.states.add(auxState);
    }
   
}
