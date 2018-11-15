package View;
import Model.*;

import java.util.*;

public class Screen {

    // Displays the Welcome Screen and gets the number of players
    public int getNumberOfPlayers(){
        System.out.println("Welcome!");
        String requirements = "Enter number of players between 1 and 5 or press q to quit:";
        int numberOfPlayers = getInput(requirements,0, 6);
        return numberOfPlayers;
    }

    public int getBet(int playerIndex, PlayerList players, Board b, int currentBet, Pot p, RoundOfPlay round){
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

    public int getRaiseValue(){
        String requirements = "Enter the amount you would like to raise by. Must be an integer between 1 and 10.";
        int raiseValue = getInput(requirements,0,11);
        return raiseValue;
    }

    public void getHand(Player p, Board b){
        System.out.println("Player " + p.getNumber());
        System.out.println("Board Cards: ");
        for (int i = 0; i < 5; i++){
            System.out.println("Card " + (i+1) + ": " + b.getBoard().get(i));
        }
        System.out.println("Personal Cards:");
        System.out.println("Card 6: " + p.getPersonalCard(0));
        System.out.println("Card 7: " + p.getPersonalCard(1));
        String reqStr = "Enter the numbers of the cards you would like to play (e.g. 12457)";
        int cardSelection;
        int i;
        boolean validHand = false;
        while (!validHand){
            cardSelection = getInput(reqStr,12345, 76543);
            i = cardSelection;
//            while(i>0){
//
//            }
        }
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
    // Descriptions of each screen can be found in the UI mockups from Part 2 of this project.
    //TODO: display the Hand Screen and get the hands that each player wants to play
    //TODO: display the Winner Screen

}
