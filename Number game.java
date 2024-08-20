import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        scanner.close();
        System.out.println("Thank you for playing!");
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("I have generated a number between 1 and 100. Try to guess it!");

        while (attempts < MAX_ATTEMPTS && !hasWon) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                hasWon = true;              System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }

        if (!hasWon) {         System.out.println("Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The number was: " + numberToGuess);
        }
    }
}
