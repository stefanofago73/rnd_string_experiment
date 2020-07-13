package it.fago.experiment.rndstring.basic;

import java.util.Random;

public class Solution2 {

	public static String randomString(int leftLimit,int rightLimit,int targetStringLength) {
		char [] buffer = new char[targetStringLength];
		Random random = new Random();
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer[i]=(char) randomLimitedInt;
		}
		return new String(buffer);
	}

}// END
