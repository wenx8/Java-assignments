import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author Xianli Wen
 * @id 1762656
 * @author NAME
 * @id ID
 */
class UniversalAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        StringBuilder result = new StringBuilder();
        for (boolean cell : gen) {
            result.append(cell ? '*' : ' ');
        }
        return result.toString();
    }

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        // TODO 14
        return new boolean[] { true, false };
    }

    boolean[] readInitalGeneration(int length) {
        // TODO 16: Copyt from ABAutomaton.java
        boolean[] initialGeneration = new boolean[length];
        String[] positions = scanner.next().split(" ");

        boolean isReadingPosition = false;

        for (String position : positions) {
            if (position.equals("init_start")) {
                isReadingPosition = true;
            } else if (position.equals("init_end")) {
                break;
            } else if (isReadingPosition) {
                int pos = Integer.parseInt(position);
                if (pos >= 1 && pos <= length) {
                    initialGeneration[pos - 1] = true;
                }
            }
        }
        return initialGeneration;
    }

    boolean[] readRuleSequence() {
        // TODO 17
        return new boolean[] { true, false };
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
