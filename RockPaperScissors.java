package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wins = 0;
        int losses = 0;
        int ties = 0;

        while (true) {

            System.out.println("\nEnter rock, paper, or scissors:  \nIf you want to exit the game, type in 'quit'. ");
            String userInput = scanner.nextLine();

            //quit the game
            if (userInput.equalsIgnoreCase("quit")) {
                break;
            }

            //Verify move is valid
            if (!userInput.equalsIgnoreCase("rock") && !userInput.equalsIgnoreCase("paper") && !userInput.equalsIgnoreCase("scissors")) {
                System.out.println("\nPlease enter a valid move.");
            } else {


                //Random number formula
                int randomInt = new Random().nextInt(3);
                String opponentMove = "";

                if (randomInt == 0) {
                    opponentMove = "rock";
                } else if (randomInt == 1) {
                    opponentMove = "paper";
                } else if (randomInt == 2) {
                    opponentMove = "scissors";
                }
                System.out.println("\nThe opponent chose... " + opponentMove + "!");

                //Calculate if user won, lost or tied
                if (userInput.equalsIgnoreCase(opponentMove)) {
                    System.out.println("You tied!");
                    ties++;
                } else if (userInput.equalsIgnoreCase("rock") && opponentMove.equalsIgnoreCase("scissors")
                        || opponentMove.equalsIgnoreCase("scissors") && opponentMove.equalsIgnoreCase("paper")
                        || userInput.equalsIgnoreCase("paper") && opponentMove.equalsIgnoreCase("rock")) {
                    System.out.println("\nCongratulations, you won!");
                    wins++;
                } else {
                    System.out.println("\nThis is awkward... you lost :(");
                    losses++;
                }
                //Print wins, losses and ties
                int totalGamesPlayed = wins + losses + ties;
                double winsPercentage = ((double) wins / totalGamesPlayed) * 100;
                System.out.println("\nYou won: " + wins + "\nYou lost: " + losses + "\nYou tied: " + ties + "\nYour winning percentage: " + winsPercentage + "%");
            }
        }
        System.out.println("That was fun, thank you for playing!");
    }

}
