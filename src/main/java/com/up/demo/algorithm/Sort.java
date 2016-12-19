package com.up.demo.algorithm;

public class Sort {
	private static final int[] PARAM = { 99, 1, 881, 77, 33, 22, 89, 76, 10, 47 };

	public static void main(String[] args) {
		printArr(PARAM);
		quickSort(PARAM, 0, PARAM.length - 1);
		printArr(PARAM);
	}

	/**
	 * 快速排序
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 */
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int midIndex = getMidIndex(arr, startIndex, endIndex);
		quickSort(arr, startIndex, midIndex - 1);
		quickSort(arr, midIndex + 1, endIndex);
	}

	private static int getMidIndex(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return -1;
		}
		int key = arr[startIndex];
		while (startIndex < endIndex) {
			while (startIndex < endIndex && key < arr[endIndex]) {
				endIndex--;
			}
			arr[startIndex] = arr[endIndex];
			while (startIndex < endIndex && key > arr[startIndex]) {
				startIndex++;
			}
			arr[endIndex] = arr[startIndex];
		}
		arr[startIndex] = key;
		return startIndex;
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
