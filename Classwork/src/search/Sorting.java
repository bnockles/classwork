package search;

import java.util.Arrays;

public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayToSort={133,0,-5,31,12,91,2};
		selectionSort(arrayToSort);
		System.out.println("Sorted Array: "+Arrays.toString(arrayToSort));
	}
	public static void selectionSort(int[] arrayToSort){
		int minIndex=0;
		int minimum=arrayToSort[0];
		for(int i=0;i<arrayToSort.length;i++){
			minIndex=i;
			minimum=arrayToSort[i];
			for(int j=i;j<arrayToSort.length;j++){
				if(arrayToSort[j]<minimum){
					minimum=arrayToSort[j];
					minIndex=j;
				}
			}
			int placeHolder=arrayToSort[i];
			arrayToSort[i]=minimum;
			arrayToSort[minIndex]=placeHolder;
		}
	}

}
