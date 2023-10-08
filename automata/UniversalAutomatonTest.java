import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test UniversalAutomaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author 1762656
 * @id Xianli Wen
 * @author NAME
 * @id ID
 */
public class UniversalAutomatonTest {
    UniversalAutomaton automaton = new UniversalAutomaton();

    @Test
    public void testGenToString() {
        // TODO 13:
        //gen1: case that the cell is not occupied and both neighbors are not occupied.
        boolean[] gen1 = {false, false, false};
        assertEquals("   ", automaton.genToString(gen1));

        //gen2: case that the cell is not occupied and one of neighbors is occupied
        boolean[] gen2 = {true, false, false};
        assertEquals("*  ", automaton.genToString(gen2));

        //gen3: case that the cell is not occupied and both neighbors are occupied
        boolean[] gen3 = {true, false, true};
        assertEquals("* *", automaton.genToString(gen3));

        //gen4: case that the cell is occupied and both neighbors are occupied
        boolean[] gen4 = {true, true, true};
        assertEquals("***", automaton.genToString(gen4));

        //gen5: case that the cell is occupied and one of neighbors is occupied
        boolean[] gen5 = {false, true, true};
        assertEquals(" **", automaton.genToString(gen5));

        //gen6: case that the cell is occupied and both neighbors are not occupied
        boolean[] gen6 = {false, true, false};
        assertEquals(" * ", automaton.genToString(gen6));
    }

    @Test
    public void testNextGen() {
        // TODO 15:
        // Motivate each test case with a line comment like this.
    }

}