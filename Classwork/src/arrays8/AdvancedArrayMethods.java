package arrays8;

public class AdvancedArrayMethods {

	
	
	public static void main(String[] args) {
		String[] array = {"a","b","c","d","e","f","g","h"};
		shuffle(array);
		
		
	}

	
	public static int longestSharedSequence(int[] array1, 
			int[] array2){
		int max = 0;
		int count = 0;
		
		for(int seqStart = 0; seqStart < array1.length;
				seqStart++){
			//!!!!!insert a loop here
			int seqEnd = seqStart;
			int[] seq = getSequence(seqStart, seqEnd, array1);
			if(checkSequence(seq, array2)){
				count ++;
				if(count > max){
					max = count;
				}
			}
			//reset the count after every seq has been checked
			count = 0;
		}
		
		
		return max;
	}
	
	//returns true if seq is found inside array2
	private static boolean checkSequence(int[] seq, int[] array2) {
		// TODO Auto-generated method stub
		return false;
	}


	//returns a sub-array containing the elements
	//in array1 from seqStart to seqEnd
	private static int[] getSequence(int seqStart, int seqEnd, int[] array1) {
		// TODO Auto-generated method stub
		return null;
	}


	private static void shuffle(Object[] array) {
		for(int i = 0; i < array.length; i++){
			int random = (int)(Math.random()*6);
			swap(array, i, random);
		}
	}




	private static void swap(Object[] arr, int a, int b) {
		Object placeholder = arr[b];
		arr[b] = arr[a];
		arr[a] = placeholder;
	}

	private static void methodA(int[] someArray) {
		int[] newArray = new int[someArray.length];
		
	}
	
	public static void copyArray(int[] original, 
			int[] target){
		if(original.length == target.length){
			for(int i = 0; i < original.length; i++){
				target[i] = original[i];
			}
		}else{
			//print an "error" message
			System.out.println("ERROR: tried to copy arrays"
					+ " of two different lengths.");
		}
	}

}
















