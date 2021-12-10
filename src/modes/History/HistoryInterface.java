package src.modes.History;

import java.util.ArrayList;

public interface HistoryInterface {
    public Backup undo();
    public Backup redo();
    public ArrayList<Backup> getBackups();
    public int getHead();
}
