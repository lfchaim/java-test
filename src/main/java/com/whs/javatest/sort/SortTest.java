package com.whs.javatest.sort;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		sort(0);
		sort(1);
	}

	private static void sort( int type ) {
		int len = 1000;
		int[] arrToSort = new int[len];
		Random rand = new Random();
		for (int i = 0; i < len; i++)
			arrToSort[i] = rand.nextInt(1, 10000);
		Calendar c1 = Calendar.getInstance();
		if( type == 0 )
			Arrays.sort(arrToSort);
		else
			Arrays.parallelSort(arrToSort);
		Calendar c2 = Calendar.getInstance();
		System.out.println("Time: " + (c2.getTimeInMillis() - c1.getTimeInMillis()) + " ms");
		for (int i = 0; i < len; i++)
			System.out.print(arrToSort[i] + ",");
		System.out.println("");
	}
}
