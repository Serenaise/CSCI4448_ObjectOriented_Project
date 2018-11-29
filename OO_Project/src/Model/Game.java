package Model;

/**
 * The Game class holds the objects that determine the state of the game/
 */
public class Game {
    /**
     * A list of players currently in the game.
     */
    private PlayerList players;
    /**
     * The current pot.
     */
    private Pot pot;
    /**
     * The current board.
     */
    private Board board;
    /**
     * The current round
     */
    private RoundOfPlay round;

    /**
     * Creates a new game with the attributes as specified.
     * @param players a PlayerList of players.
     * @param pot the pot as a Pot object
     * @param board the board as a Board object
     * @param round the round as a RoundOfPlay object
     */
    public Game(PlayerList players, Pot pot, Board board, RoundOfPlay round) {
        this.players = players;
        this.pot = pot;
        this.board = board;
        this.round = round;
    }

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
