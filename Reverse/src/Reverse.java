import java.lang.*;
import java.io.*;
import java.util.*;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] first_array = {2, -7, 3, 4, 10}; 
		int[] second_array = {1, 4, -5, -2, -11};
		
		int length = first_array.length;
		
		int[] resultArray = new int[length];
		
		for(int flag = 0; flag < length; flag++) {
			resultArray[flag] = first_array[flag] * second_array[flag];
		}
		
		System.out.println(first_array[0] * second_array[0]);
		System.out.println(first_array[1] * second_array[1]);
		System.out.println(first_array[2] * second_array[2]);
		System.out.println(first_array[3] * second_array[3]);
		System.out.println(first_array[4] * second_array[4]);
		System.out.println(Arrays.toString(resultArray));
		
	}

}
