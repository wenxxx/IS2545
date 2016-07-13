public class billify {

	public int[] Billify(int[] x) {	
		//initialization
		int[] array = new int[x.length + 1];  
		int sum = 0;
		
		//calculate the square of each element
		for (int i = 0; i < x.length; i++) {
			array[i] = (int) Math.pow(x[i], 2);
			sum += array[i];
		}
		
		//the last element is the sum of all other ones in the array.
		array[x.length] = sum; 
		
		return array;
	}

}