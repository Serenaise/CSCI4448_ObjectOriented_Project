package Model;

public class RoundOfPlay {
    private int roundNumber = 0;

    public int getRoundNumber() {
        return roundNumber;
    }
    public int incrementRoundNumber(){
        this.roundNumber = this.roundNumber + 1;
        return this.roundNumber;
    }
}
