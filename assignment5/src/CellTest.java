import static org.junit.Assert.*;
import org.junit.Test;

public class CellTest {
	
	/*
	 * This test verifies the revised method implements the same function as the previous one
	 * Cell.toString() is revised
	 * toString0 represents previous one
	 * toString1 represents revised one
	 */
	
	@Test
	public void toStringtest1() {
		Cell toString0 = new Cell();
		Cell toString1 = new Cell();
        String toString0Result = toString0.toString0();
        String toString1Result = toString1.toString1();
        assertEquals(toString0Result, toString1Result);
	}
	
    @Test
    public void toStringtest2() {
        Cell toString1 = new Cell();
        toString1.setAlive(true);
        String toString1Result = toString1.toString1();
        assertEquals(toString1Result, "X");
    }
    
    @Test
    public void toStringtest3() {
        Cell toString1 = new Cell();
        String toString1Result = toString1.toString1();
        assertEquals(toString1Result, ".");
    }
}