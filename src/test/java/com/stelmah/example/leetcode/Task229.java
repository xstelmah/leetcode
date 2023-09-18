package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

class Task229 {

	public  Task229 (){

		System.out.println("1");
		if (true) return ;
		System.out.println("2");
	}

	@Test
	void example1() {
		var t = new Task229();
//		PhantomReference p  = new PhantomReference();
		System.out.println(t);
	}
	public List<Integer> majorityElement(int[] nums) {
		var response = new ArrayList<Integer>();
		return response;
	}

	public static class Task229_2 extends Task229 {


		@Override
		public String toString() {
			return "Task229_2{}";
		}

	}
}
