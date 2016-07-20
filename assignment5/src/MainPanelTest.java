import static org.junit.Assert.*;

import org.junit.Test;


public class MainPanelTest {
	/*
	 * 1
	 * This series of three tests verifies the improved method implements the same function as the previous one
	 * MainPanel.convertToInt() is improved
	 * getNumNeighbors0 represents previous one
	 * getNumNeighbors1 represents improved one
	 */
	
	@Test
	public void convertTotest1() {
		MainPanel testConvertToInt = new MainPanel(9);
		int getNumNeighbors1Result = testConvertToInt.getNumNeighbors1(2,2);
        int getNumNeighbors0Result = testConvertToInt.getNumNeighbors0(2,2);
        assertEquals(getNumNeighbors1Result, getNumNeighbors0Result);
	}	

	@Test
	public void convertTotest2() {
		MainPanel testConvertToInt = new MainPanel(6);
		int getNumNeighbors1Result = testConvertToInt.getNumNeighbors1(5,4);
        int getNumNeighbors0Result = testConvertToInt.getNumNeighbors0(5,4);
        assertEquals(getNumNeighbors1Result, getNumNeighbors0Result);
	}
	
	@Test
	public void convertTotest3() {
		MainPanel testConvertToInt = new MainPanel(15);
		int getNumNeighbors1Result = testConvertToInt.getNumNeighbors1(9,14);
        int getNumNeighbors0Result = testConvertToInt.getNumNeighbors0(9,14);
        assertEquals(getNumNeighbors1Result, getNumNeighbors0Result);
	}
	
	
	
	/*
	 * 2
	 * This series of three tests verifies the improved method implements the same function as the previous one
	 * MainPanel.backup is improved
	 * backup0 represents the previous one
	 * backup1 represents the improved one
	 */

	@Test
	public void backupTest1() {
		MainPanel m = new MainPanel(15);
		Cell[][] _cells = new Cell[15][15];
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
			    _cells[i][j] = new Cell(false);
			}
		}	
		m.backup1();	
		assertEquals(m._backupCells[14][14].getAlive(), _cells[14][14].getAlive());
	}
	
	@Test
	public void backupTest2() {
		MainPanel m = new MainPanel(15);
		Cell[][] _cells = new Cell[15][15];
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
			    _cells[i][j] = new Cell(true);
			}
		}	
		m.setCells(_cells);
		m.backup1();	
		assertEquals(m._backupCells[14][14].getAlive(), _cells[14][14].getAlive());
	}
	
		@Test
		public void backupTest3() {
			MainPanel m = new MainPanel(10);
			Cell[][] _cells = new Cell[10][10];
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
				    _cells[i][j] = new Cell(true);
				}
			}	
			m.setCells(_cells);
			m.backup1();	
			assertEquals(m._backupCells[9][9].getAlive(), _cells[9][9].getAlive());
		}
}
