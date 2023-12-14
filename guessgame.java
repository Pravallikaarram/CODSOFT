import java.util.Scanner;
import java.util.Random;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1;
        int maxNum = 100;
        int secretNumber;
        int attempts = 0;
        int rounds = 0;
        int totalAttempts = 0;
System.out.println("Guess game starts");
System.out.println("Guess number between " + minNum + " and " + maxNum);
boolean playAgain = true;
while (playAgain) {
            secretNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            attempts = 0;
            rounds++;
     while (true) {
                System.out.print("What is your guess: ");
       if (input.hasNextInt()) {
                    int userGuess = input.nextInt();
                    attempts++;
         if (userGuess < minNum || userGuess > maxNum) {
                        System.out.println("Guess must be between " + minNum + " and " + maxNum);
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low......Retry");
                    } else if (userGuess > secretNumber) {
                        System.out.println("Too high....Retry");
                    } else {
                        System.out.println("You guessed the correct number (" + secretNumber + ") in " + attempts + " attempts.");
                        break;
                    }
                } else {
                    System.out.println("Enter a valid number.");
                    input.next(); // Clear the invalid input
                }}
         System.out.print("Play again (YES/NO): ");
            String playAgainResponse = input.next();
if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
   System.out.println("Game over......You played " + rounds + " rounds and had a total of " + totalAttempts + " attempts.");
        if (rounds > 0) {
            double averageAttemptsPerRound = (double) totalAttempts / rounds;
            System.out.printf("Average attempts per round are: %.2f%n", averageAttemptsPerRound);
        }

        input.close();
    }
}
