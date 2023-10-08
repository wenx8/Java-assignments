import java.util.Random;
import java.util.Scanner;

/**
 * Simple number guessing game for computers.
 * 
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher" 
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 * 
 * @author Xianli Wen
 * @id     1762656
 * @author TODO
 * @id     TODO
 * @data   TODO
 */
public class ComputerGame {
    Scanner sc = new Scanner(System.in);
    private Random randomGenerator;

    void run() {
        System.out.println("Type an arbitrary number:"); 
        //Generate random numbers.       
        long seed = sc.nextLong();
        randomGenerator = new Random(seed);
        int code = randomGenerator.nextInt(100);

        int nrOfAttempts = 0; //number of attempts the user has tried
        boolean guessingRight = false;

        System.out.println("Start guessing!");
        StringBuilder guessingHistory = new StringBuilder();

        //7 attempts is the maximum. 
        while (nrOfAttempts < 7) {
            int guess = sc.nextInt();
            nrOfAttempts++;

            //Compare the guess with the correct generated number.
            if (guess == code) {
                guessingRight = true;
                System.out.println("Good guess! You won.");
                break;
            } else if (guess < code) {
                System.out.println("higher");
            } else {
                System.out.println("lower");
            } 

            //Build the guessing history.
            StringBuilder historyLine = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                if (i == guess) {
                    historyLine.append("X");
                } else if (i == code) {
                    historyLine.append("|");
                } else {
                    historyLine.append(".");
                }
            }
            guessingHistory.append(historyLine.toString()).append("\n");
        }

        //Worst case: running out 7 attempts and not correct.
        if (!guessingRight) {
            System.out.println("No more guesses, you lost.");
        }

        //Print the guessing history.
        System.out.println(nrOfAttempts + " guesses:");
        System.out.println(guessingHistory);
    }

    public static void main(String[] args) {
        new ComputerGame().run();
    }
}
