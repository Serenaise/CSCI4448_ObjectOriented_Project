package View;
import java.util.*;

public class Screen {

    public int getNumberOfPlayers(){
        System.out.println("Welcome!");
        System.out.println("Enter number of players:");
        Scanner InputNumberOfPlayers = new Scanner(System.in);
        int numberOfPlayers = 0;
        boolean goodInput = false;
        while(!goodInput) {
            if (InputNumberOfPlayers.hasNextInt()) {
                numberOfPlayers = InputNumberOfPlayers.nextInt();
                if (numberOfPlayers > 0 && numberOfPlayers < 6){
//                    System.out.print("There are ");
//                    System.out.print(numberOfPlayers);
//                    System.out.print(" players.\n");
                    goodInput = true;
                } else {
                    System.out.println("The game requires between 1 and 5 players");
                    System.out.println("Enter number of players:");
                }
            } else if (InputNumberOfPlayers.hasNext()) {
                if (InputNumberOfPlayers.nextLine().equals("q")) {
                    System.out.println("Quitting");
                    System.exit(0);
                } else {
                    System.out.println("Invalid input. Try again.");
                    System.out.println("Enter number of players:");
                    InputNumberOfPlayers = new Scanner(System.in);
                }
            } else {
                System.out.println("Invalid input. Try again.");
                System.out.println("Enter number of players:");
                InputNumberOfPlayers = new Scanner(System.in);
            }
        }
        return numberOfPlayers;
    }



}
