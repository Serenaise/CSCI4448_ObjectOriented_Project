package Model;

public class RoundOfPlay {
    private int roundNumber = 1;

    public int getRoundNumber() {
        return roundNumber;
    }
    public int incrementRoundNumber(){
        this.roundNumber = this.roundNumber + 1;
        return this.roundNumber;
    }
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
//        if (roundNumber == 1){retStr = " (pre flop) ";}
//        else if (roundNumber == 2){retStr = " (flop) ";}
//        else if (roundNumber == 3){retStr = " (turn) ";}
//        else if (roundNumber == 4){retStr = " (river) ";}
//        else {return "Something has gone wrong and there are " + roundNumber + " rounds.";}
        return (Integer.toString(roundNumber) + retStr);
    }
}
