package it.fago.experiment.rndstring.basic;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Solution4 {

	public static String randomString(String dictionary, int targetStringLength) {
		char[] buffer = new char[targetStringLength];
		int randomLimitedInt;
		for (int i = 0; i < targetStringLength; i++) {
			randomLimitedInt = dictionary.charAt((int) (current().nextFloat() * dictionary.length()));
			buffer[i] = (char) randomLimitedInt;
		}
		return new String(buffer);
	}

}// END
