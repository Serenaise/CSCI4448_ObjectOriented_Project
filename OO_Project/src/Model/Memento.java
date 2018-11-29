package Model;

/**
 * Holds a game state.
 */
public class Memento {
    private Game state;

    /**
     * Creates a memento with the state specified.
     * @param state the state to create the memento with.
     */
    public Memento(Game state){
        this.state = state;
    }

    /**
     * Gets the state stored in the memento.
     * @return the state from the memento as a Game object.
     */
    public Game getState(){
        return state;
    }

}
