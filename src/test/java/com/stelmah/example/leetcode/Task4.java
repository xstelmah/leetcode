package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task4 {

	@Test
	void addTwoNumbersExample1() {
		var l1 = new int[] { 1, 2 };
		char q =12345;
		var l2 = new int[] { 3, 4 };
		var result = findMedianSortedArrays(l1, l2);
		Assertions.assertEquals(2.5D, result);
	}

	@Test
	void addTwoNumbersExample2() {
		var l1 = new int[] { 1, 3 };
		var l2 = new int[] { 2 };
		var result = findMedianSortedArrays(l1, l2);
		Assertions.assertEquals(2, result);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) {
			return 0D;
		}
		var index1 = 0;
		var index2 = 0;
		var resultArray = new int[nums1.length + nums2.length];
		while (index1 != nums1.length || index2 != nums2.length) {
			if (index1 != nums1.length && index2 != nums2.length) {
				if (nums1[index1] < nums2[index2]) {
					resultArray[index1 + index2] = nums1[index1++];
				} else {
					resultArray[index1 + index2] = nums2[index2++];
				}
			} else if (index1 != nums1.length) {
				resultArray[index1 + index2] = nums1[index1++];
			} else {
				resultArray[index1 + index2] = nums2[index2++];
			}
		}

		if (resultArray.length % 2 != 0) {
			return resultArray[resultArray.length / 2];
		} else {
			return (resultArray[resultArray.length / 2] + resultArray[resultArray.length / 2 - 1]) / 2.0D;
		}
	}

}
