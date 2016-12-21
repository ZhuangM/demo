package com.up.demo.algorithm;

import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		int[] arr = generateArr(50);
		printArr(arr);
		long startTime = System.currentTimeMillis();
		// quickSort(arr, 0, arr.length - 1);
		// bubbleSort(arr);
		selectSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("cost：" + (endTime - startTime) + "ms");
		printArr(arr);
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

	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param arr
	 */
	public static void selectSort(int[] arr) {

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[] generateArr(int count) {
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = new Random().nextInt(9999);
		}
		return arr;
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
