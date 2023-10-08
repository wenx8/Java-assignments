import java.util.*; // For Scanner, Random, etc.

/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Xianli Wen
 * @id     1762656
 * @author TODO
 * @id     TODO
 * @data   TODO
 */
public class HumanGame {
    Scanner sc = new Scanner(System.in);

    void run() {
        // TODO: Implementation
        System.out.println("Think of a secret number not smaller than 0 and not greater than 999. Type 'go' when you have one.");
        String input = sc.nextLine();
        
        while (input.equals("go")) {
            int lowerBound = 0;
            int higherBound = 1000;
            int guess; 

            for (int i = 1; i <= 10; i++) {
                guess = (lowerBound + higherBound) / 2;
                System.out.println(guess);

                input = sc.nextLine();
                if (input.equals("guessed")) {
                    System.out.println("Computer wins!");
                    return;
                } else if (input.equals("lower")) {
                    higherBound = guess;
                } else {
                    lowerBound = guess + 1;
                }
            }
            System.out.println("I give up");
        }
      
        // END TODO
    }

    public static void main(String[] args) {
        new HumanGame().run();
    }
}
