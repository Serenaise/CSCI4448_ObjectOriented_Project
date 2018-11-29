package View;
import Model.*;

import java.util.*;

public class Screen {

    /**
     * Gets the number of players from the user.
     * @return Returns the number of players as an int.
     */
    public int getNumberOfPlayers(){
        System.out.println("Welcome!");
        String requirements = "Enter number of players between 1 and 5 or press q to quit:";
        int numberOfPlayers = getInput(requirements,0, 6);
        return numberOfPlayers;
    }

    /**
     * Gets the type of bet from the player.
     * @param playerIndex the index of the player making the bet in the PlayerList players as a Player object
     * @param players the list of players currently in the game as a PlayerList object
     * @param b the current board as a Board object
     * @param currentBet the value of the current bet as an int
     * @param p the current pot as a Pot object
     * @param round the current round as a RoundOfPlay object
     * @return Returns 1 for raise, 2 for call, and 3 for flop.
     */
    public int getBet(int playerIndex, PlayerList players, Board b, int currentBet, Pot p, RoundOfPlay round){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player " + (players.getPlayer(playerIndex).getNumber()));
        System.out.println("Board: " + b.toString());
        System.out.println("Personal Cards: " + players.getPlayer(playerIndex).getPersonalCard(0).toString() + players.getPlayer(playerIndex).getPersonalCard(1).toString());
        System.out.println("Current Bet: " + currentBet);
        System.out.println("Current Pot: " + p.toString());
        System.out.println("Current Round: " + round.toString() + "\n");
        String requStr = "Enter a number to choose an action or press q to quit: ";
        requStr = requStr + "\n (1) Raise";
        requStr = requStr + "\n (2) Call";
        requStr = requStr + "\n (3) Fold";
        int betChoice = getInput(requStr, 0, 4);
        return betChoice;
    }

    /**
     * Gets the amount the player chooses to raise by from the user.
     * Used if they choose the raise bet type.
     * @return Returns an integer number to raise by.
     */
    public int getRaiseValue(){
        String requirements = "Enter the amount you would like to raise by. Must be an integer between 1 and 10.";
        int raiseValue = getInput(requirements,0,11);
        return raiseValue;
    }

    /**
     * Gets the cards the user chooses to play at the end of the game and sets the hand attribute of the Player
     * object it is passed.
     * @param p the player to get the hand for as a Player object
     * @param b the current board as a Board object
     */
    public void getHand(Player p, Board b){
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        System.out.println("Player " + p.getNumber());
        System.out.println("Board Cards: ");
        for (int i = 0; i < 5; i++){
            System.out.println("Card " + (i+1) + ": " + b.getBoard().get(i));
            cards.add(b.getBoard().get(i));
        }
        System.out.println("Personal Cards:");
        System.out.println("Card 6: " + p.getPersonalCard(0));
        System.out.println("Card 7: " + p.getPersonalCard(1));
        cards.add(p.getPersonalCard(0));
        cards.add(p.getPersonalCard(1));
        String reqStr = "Enter the numbers of the cards you would like to play (e.g. 12457)";
        int cardSelection;
        boolean validHand = false;
        List<Integer> digits = new ArrayList<>();
        while (!validHand){
            validHand = true;
            cardSelection = getInput(reqStr,12344, 76544);
            for (int i = 0; i < 5; i++){
                digits.add(cardSelection % 10);
                cardSelection = cardSelection / 10;
                if (digits.get(i) > 7 || digits.get(i) < 1){validHand = false;}
                else{hand.add(cards.get(digits.get(i) - 1));}
            }
            Set<Integer> digitSet = new HashSet<>(digits);
            if (digitSet.size() < digits.size()){validHand = false;}
        }
        p.setHand(new Hand(hand));
    }

    /**
     * Gets whether or not the player wants to revert to an earlier point in the game.
     * @return Returns true if they choose to revert and false if they choose not to.
     */
    public boolean getRevertOption(){
        boolean revert = false;
        String requirements = "Would you like to revert back to earlier in the game or continue playing?\n";
        requirements = requirements + "(1) Revert back \n";
        requirements = requirements + "(2) Continue playing";
        int choice = getInput(requirements,0,3);
        if (choice == 1){revert = true;}
        return revert;
    }

    /**
     * Gets location that the user chooses to return to.
     * @param careTaker list of states that can be reverted to.
     * @return the index+1 of the element of the careTaker to revert to.
     */
    public int getRevertChoice(CareTaker careTaker){
        String reqStr = "Select save to revert back to\n";
        for (int i = 0; i < careTaker.getSize();i++){
            reqStr = reqStr + "(" + (i+1) + ") Revert to round "  + careTaker.get(i).getState().getRound().toString() + "\n";
        }
        return getInput(reqStr, 0, careTaker.getSize()+1);
    }

    /**
     * Gets whether or not the player chooses to save the game.
     * @return Returns true if they chose to save and false if they chose not to save.
     */
    public boolean getSaveOption(){
        boolean save = false;
        String requirements = "Would you like to save the game?\n";
        requirements = requirements + "(1) Save \n";
        requirements = requirements + "(2) Don't save";
        int choice = getInput(requirements,0,3);
        if (choice == 1){save = true;}
        return save;
    }

    /**
     * Displays the number of the winning player.
     * @param winner the winning player as a Player object
     */
    public void displayWinner(Player winner){
        System.out.println("The winner is Player number " + winner.getNumber());
    }

    private int getInput(String requirementsMessage, int lowerBound, int upperBound){
        //Upper and lower bounds are exclusive
        System.out.println(requirementsMessage);
        Scanner scannerInput = new Scanner(System.in);
        int inputValue = 0;
        boolean goodInput = false;
        while(!goodInput) {
            if (scannerInput.hasNextInt()) {
                inputValue = scannerInput.nextInt();
                if (inputValue > lowerBound && inputValue < upperBound){
                    goodInput = true;
                } else {
                    System.out.println("Invalid input. Try again.");
                    System.out.println(requirementsMessage);
                    scannerInput.nextLine();
                }
            } else if (scannerInput.hasNext()) {
                String next = scannerInput.nextLine();
                if (next.equals("q")) {
                    System.out.println("Quitting");
                    System.exit(0);
                } else {
                    System.out.println("Invalid input. Try again.");
                    System.out.println(requirementsMessage);
                    scannerInput = new Scanner(System.in);
                }
            } else {
                System.out.println("Invalid input. Try again.");
                System.out.println(requirementsMessage);
                scannerInput = new Scanner(System.in);
            }
        }
        return inputValue;
    }

}
