package Model;
import java.util.*;

/**
 * Keeps a list of mementos that can be used to revert back to earlier states in the game.
 */
public class CareTaker {
    /**
     * The list of mementos that have been saved.
     */
    private ArrayList<Memento> mementoList = new ArrayList<Memento>();

    /**
     * Add a memento to the careTaker
     * @param state the memento to add
     */
    public void add(Memento state){
        mementoList.add(state);
    }

    /**
     * Retrieve a memento from the careTaker.
     * @param index the index in the list of mementos that the careTaker has of the memento to be retrieved
     * @return Returns the memento retrieved from the careTaker.
     */
    public Memento get(int index){
        return mementoList.get(index);
    }

    /**
     * Checks to see if there are mementos in the careTaker.
     * @return Returns true if there are no mementos in the careTaker and false if there are mementos.
     */
    public boolean isEmpty(){
        return mementoList.isEmpty();
    }

    /**
     * Gets the number of mementos stored in the careTaker.
     * @return the number of mementos in the careTaker
     */
    public int getSize(){
        return mementoList.size();
    }

}
