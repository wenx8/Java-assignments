import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test ABAutomaton.
 * 
 * TODO 3: FIll in your names and student IDs
 * @author Xianli Wen
 * @id 1762656
 * @author NAME
 * @id ID
 */
public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        // TODO 6: 
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
    public void testNextGenA() {
        // TODO 8: 
        // Occupied cells remain occupied only if exactly one of the neighbors is occupied:
        // gen1: no neighbor is occupied.
        boolean[] gen1 = {false, true, false};
        boolean[] expected1 = {true, false, true};
        assertArrayEquals(expected1, automaton.nextGenA(gen1));

        // gen2: one left neighbor is occupied.
        boolean[] gen2 = {true, true, false};
        boolean[] expected2 = {true, true, true};
        assertArrayEquals(expected2, automaton.nextGenA(gen2));

        // gen3: one right neighbor is occupied.
        boolean[] gen3 = {false, true, true};
        boolean[] expected3 = {true, true, true};
        assertArrayEquals(expected3, automaton.nextGenA(gen3));

        // gen4: both neighbor are occupied.
        boolean[] gen4 = {true, true, true};
        boolean[] expected4 = {true, false, true};
        assertArrayEquals(expected4, automaton.nextGenA(gen4));

        // Empty cells remain empty only if both neighbors are empty:
        // gen5: no neighbor is occupied.
        boolean[] gen5 = {false, false, false};
        boolean[] expected5 = {false, false, false};
        assertArrayEquals(expected5, automaton.nextGenA(gen5));

        // gen6: one left neighbor is occupied.
        boolean[] gen6 = {true, false, false};
        boolean[] expected6 = {false, true, false};
        assertArrayEquals(expected6, automaton.nextGenA(gen6));

        // gen7: one right neighbor is occupied.
        boolean[] gen7 = {false, false, true};
        boolean[] expected7 = {false, true, false};
        assertArrayEquals(expected7, automaton.nextGenA(gen7));

        // gen8: both neighbor are occupied.
        boolean[] gen8 = {true, false, true};
        boolean[] expected8 = {false, true, false};
        assertArrayEquals(expected8, automaton.nextGenA(gen8));
    }

    @Test
    public void testNextGenB() {
        // TODO 10: 
        // Occupied cells remain occupied only if the right-hand neighbor is empty:
        // gen1: no neighbor is occupied.
        boolean[] gen1 = {false, true, false};
        boolean[] expected1 = {true, true, true};
        assertArrayEquals(expected1, automaton.nextGenB(gen1));

        // gen2: one left neighbor is occupied.
        boolean[] gen2 = {true, true, false};
        boolean[] expected2 = {false, true, true};
        assertArrayEquals(expected2, automaton.nextGenB(gen2));

        // gen3: one right neighbor is occupied.
        boolean[] gen3 = {false, true, true};
        boolean[] expected3 = {true, false, true};
        assertArrayEquals(expected3, automaton.nextGenB(gen3));

        // gen4: both neighbor are occupied.
        boolean[] gen4 = {true, true, true};
        boolean[] expected4 = {false, false, true};
        assertArrayEquals(expected4, automaton.nextGenB(gen4));

        // Empty cells become occupied if exactly one neighbor is occupied:
        // gen5: no neighbor is occupied.
        boolean[] gen5 = {false, false, false};
        boolean[] expected5 = {false, false, false};
        assertArrayEquals(expected5, automaton.nextGenB(gen5));

        // gen6: one left neighbor is occupied.
        boolean[] gen6 = {true, false, false};
        boolean[] expected6 = {true, true, false};
        assertArrayEquals(expected6, automaton.nextGenB(gen6));

        // gen7: one right neighbor is occupied.
        boolean[] gen7 = {false, false, true};
        boolean[] expected7 = {false, true, true};
        assertArrayEquals(expected7, automaton.nextGenB(gen7));

        // gen8: both neighbor are occupied.
        boolean[] gen8 = {true, false, true};
        boolean[] expected8 = {true, false, true};
        assertArrayEquals(expected8, automaton.nextGenB(gen8));
    }

}
