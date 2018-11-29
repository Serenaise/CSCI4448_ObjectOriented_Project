package Model;

/**
 * The Originator class has the current state of the game and can save the state.
 */
public class Originator implements Cloneable {
    /**
     * The state of the game.
     */
    private Game state;

    public void setState(Game state){ this.state = state; }

    public Game getState(){ return state; }

    public PlayerList getPlayers(){return state.getPlayers();}

    public Pot getPot() { return state.getPot(); }

    public Board getBoard() { return state.getBoard(); }

    public RoundOfPlay getRound() { return state.getRound(); }

    /**
     * Saves the current state to a Memento object.
     * @return a Memento that
     */
    public Memento saveStateToMemento(){
//        Board currentBoard = new Board();

        Game currentState = new Game(state.getPlayers().clone(),state.getPot().clone(),state.getBoard().clone(),state.getRound().clone());
        return new Memento(currentState);
    }

    /**
     * Resets the sate to the state held in the memento.
     * @param memento the memento to retrieve the state from.
     */
    public void getStateFromMemento(Memento memento){ state = memento.getState(); }

    @Override
    public Originator clone(){
        Originator originatorClone = new Originator();
        originatorClone.state = this.state;
        return originatorClone;
    }
}
