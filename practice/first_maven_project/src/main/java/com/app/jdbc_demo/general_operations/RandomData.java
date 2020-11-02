package com.app.jdbc_demo.general_operations;

import java.util.Random;

public class RandomData {
	public static int generateRandomAge(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}
}
