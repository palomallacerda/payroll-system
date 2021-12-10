package src.modes.History;

import java.util.ArrayList;

public class EmptyHistory implements HistoryInterface{

    @Override
    public Backup undo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Backup redo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Backup> getBackups() {
        // TODO Auto-generated method stub
        return new ArrayList<>(); //null
    }

    @Override
    public int getHead() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
