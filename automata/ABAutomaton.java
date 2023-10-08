import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * TODO 3: FIll in your names and student IDs:
 * 
 * @author Xianli Wen
 * @id 1762656
 * @author NAME
 * @id ID
 */
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        // TODO 5
        StringBuilder result = new StringBuilder();
        for (boolean cell : gen) {
            result.append(cell ? '*' : ' ');
        }
        return result.toString();
    }

    boolean[] nextGenA(boolean[] gen) {
        // TODO 7
        boolean[] nextGeneration = new boolean[gen.length];
        for (int i = 0; i < gen.length; i++) {
            boolean left = (i == 0) ? false : gen[i - 1];
            boolean right = (i == gen.length - 1) ? false : gen[i + 1];
            nextGeneration[i] = (gen[i] && (left ^ right)) || (!gen[i] && (left && right));
        }
        return nextGeneration;
    }

    boolean[] nextGenB(boolean[] gen) {
        // TODO 9
        boolean[] nextGeneration = new boolean[gen.length];
        for (int i = 0; i <gen.length; i++) {
            boolean right = (i == gen.length - 1) ? false : gen[i + 1];
            nextGeneration[i] = (gen[i] && !right) || (!gen [i] && right);
        }
        return nextGeneration;
    }

    boolean[] readInitalGeneration(int length) {
        // TODO 11
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

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
