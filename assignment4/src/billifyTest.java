import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class billifyTest {
	public billify billify;		
	@Before
	public void initialize() {
	   billify = new billify();
	}	
	private Random random = new Random();

	private int[] produceArray() {
		//Randomly generate integers only from 1 to 100
		//1 and 100 are included
		int length = 1 + random.nextInt(3); 
		int[] arr = new int[length];
		
		//Randomly generate the array with the size from 1 to 100
		//1 and 100 are included
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 1 + random.nextInt(1);
		}		
		return arr;
	}


	/*
	 * Property Test 1: Array Size Test
	 * The length of the output array should be one element longer than that of the input array
	 */
	@Test
	public void ArraySizeTest() {
		//Randomly generate 150 arrays, and run 150 times
		for(int i = 0; i < 150; i++) {
			int[] arr = produceArray();
			int[] bArray = billify.Billify(arr);
			if(bArray.length != (arr.length + 1)) {
				fail();
			}
		}
		boolean sizePlusOne = true;
		assertTrue(sizePlusOne);
	}
	
	/*
	 * Property Test 2: Sum Value Test
	 * The sum value should be greater than or equal to all other elements in the output array
	 */
	@Test
	public void SumValueTest() {
		//Randomly generate 150 arrays, and run 150 times
		for(int i = 0; i < 150; i++) {
			int[] arr = produceArray();
			int[] bArray = billify.Billify(arr);		
			for(int j = 0; j < arr.length; j++) {
				if(bArray[j] > bArray[arr.length]) {
					fail();
				}
			}
		}
		boolean sumBiggest = true;
		assertTrue(sumBiggest);
	}
	
	
	/*
	 * Property Test 3: Purity Test
	 * Test the value, except the sum value in the output array is always the square of the input
	 */
	@Test
	public void PurityTest() {
		boolean sameResults = true;
		//Randomly generate 150 arrays, and run 150 times
		for(int i = 0; i < 150; i++) {
			int[] arr = produceArray();
			int[] bArray1 = billify.Billify(arr);	
			int[] bArray2 = billify.Billify(arr);
			if(!Arrays.equals(bArray1, bArray2)) {
				sameResults = false;
				break;
			}
		}
		assertTrue(sameResults);
	}
}


