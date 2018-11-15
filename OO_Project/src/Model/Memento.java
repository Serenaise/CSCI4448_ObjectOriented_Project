package Model;

public class Memento {
    private PlayerList players;
    private Pot pot;
    private Board board;
    private RoundOfPlay round;

    public PlayerList getPlayers() {
        return players;
    }

    public void setPlayers(PlayerList players) {
        this.players = players;
    }

    public Pot getPot() {
        return pot;
    }

    public void setPot(Pot pot) {
        this.pot = pot;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public RoundOfPlay getRound() {
        return round;
    }

    public void setRound(RoundOfPlay round) {
        this.round = round;
    }
}
