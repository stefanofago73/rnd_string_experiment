package it.fago.experiment.rndstring.basic;

import java.util.Random;

public class Solution0 {

	public static String randomString() {
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		return generatedString;
	}

}// END
