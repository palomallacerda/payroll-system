package src.modes.History;

import java.util.ArrayList;

public class HistoryHandler  implements HistoryInterface{
    int head = 0;
    Backup newBack = new Backup();
    ArrayList<Backup> allStates = new ArrayList<>();
    
    public ArrayList<Backup> getAllStates() {
        return this.allStates;
    } 

    public Backup undo() {
         
        this.newBack = allStates.get(this.head);
        if(this.head == 0){
            System.out.println("There is nothing to return!");
        }
        else{

            System.out.println("------------------------");
            System.out.println("  The change is undone!");
            System.out.println("------------------------");

            this.head-=1;
            this.newBack = allStates.get(this.head);
        }
        return this.newBack;
    }

   
    public Backup redo()    {
        this.newBack = allStates.get(this.head);

        if(this.head > this.allStates.size()) {
            System.out.println("Sorry There is nothing ahead");
        }
        else {
            System.out.println("------------------------");
            System.out.println("  The change is redone!");
            System.out.println("------------------------");
            this.head+=1;
            newBack = allStates.get(this.head);
        }
    
        return this.newBack;
    }

  
    public ArrayList<Backup> getBackups() {
        return this.allStates;
    }
  
    public int getHead() {
        return this.head;
    }
    public HistoryHandler(int head, ArrayList<Backup> states){ //constructor
        this.head = head;
        this.allStates = states;
    }
}
