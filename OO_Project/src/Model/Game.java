package Model;

public class Game {
    private PlayerList players;
    private Pot pot;
    private Board board;
    private RoundOfPlay round;

    public Game(PlayerList players, Pot pot, Board board, RoundOfPlay round) {
        this.players = players;
        this.pot = pot;
        this.board = board;
        this.round = round;
    }

    public Game(){}

    public PlayerList getPlayers() {
        return players;
    }

    public Pot getPot() {
        return pot;
    }

    public Board getBoard() {
        return board;
    }

    public RoundOfPlay getRound() {
        return round;
    }
}
