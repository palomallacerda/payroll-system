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
         
        newBack = allStates.get(head);
        if(this.head == 0){
            System.out.println("There is nothing to return!");
        }
        else{
            this.head-=1;
            newBack = allStates.get(head);
            System.out.println("------------------------");
            System.out.println("  The change is undone!");
            System.out.println("------------------------");

        }
        return newBack;
    }

   
    public Backup redo()    {
        newBack = allStates.get(head);

        if(this.head > this.allStates.size()) {
          System.out.println("Sorry There is nothing ahead");
        }
        else {
          this.head+=1;
          newBack=  allStates.get(head);
          System.out.println("------------------------");
          System.out.println("  The change is redone!");
          System.out.println("------------------------");
        }
    
        return newBack;
    }

  
    public ArrayList<Backup> getBackups() {
        // TODO Auto-generated method stub
        return allStates;
    }

  
    public int getHead() {
        // TODO Auto-generated method stub
        return this.head;
    }
    public HistoryHandler(int head, ArrayList<Backup> states){ //constructor
        this.head = head;
        this.allStates = states;
    }
}
