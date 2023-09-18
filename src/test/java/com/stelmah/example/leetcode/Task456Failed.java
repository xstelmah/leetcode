package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Task456Failed {

	int i = 1;

	private void qwe() {
		i++;
		Stream.of(1,2,3)
				.map(p -> p + i)
				.collect(Collectors.toList());
	}



}
