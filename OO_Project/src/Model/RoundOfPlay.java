package Model;

/**
 * Tracks the current round in the game.
 */
public class RoundOfPlay implements Cloneable{
    /**
     * The current round number. Between 1 and 4 inclusive.
     */
    private int roundNumber = 1;

    /**
     * Returns the current round number.
     * @return The round number as an int.
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * Increments the current round number by one(1) and returns the new round number.
     * @return The updated round number.
     */
    public int incrementRoundNumber(){
        this.roundNumber = this.roundNumber + 1;
        return this.roundNumber;
    }

    /**
     * Generates a String representation of the round number.
     * @return The round number as an integer and a description of the round of the form "# (round name)".
     */
    public String toString(){
        String retStr;
        switch (roundNumber){
            case 1:
                retStr = " (pre flop) ";
                break;
            case 2:
                retStr = " (flop) ";
                break;
            case 3:
                retStr = " (turn) ";
                break;
            case 4:
                retStr = " (river) ";
                break;
            default:
                return "Something has gone wrong and there are " + roundNumber + " rounds.";

        }
        return (Integer.toString(roundNumber) + retStr);
    }

    @Override
    public RoundOfPlay clone(){
        RoundOfPlay rfclone = new RoundOfPlay();
        rfclone.roundNumber = this.getRoundNumber();
        return rfclone;
    }
}
