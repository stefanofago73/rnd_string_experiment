package it.fago.experiment.rndstring.basic;

import java.util.Random;

public class Solution3 {

	public static String randomString(String dictionary,int targetStringLength) {
		char [] buffer = new char[targetStringLength];
		Random random = new Random();
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = dictionary.charAt( (int)(random.nextFloat() * dictionary.length()) );
			buffer[i]=(char) randomLimitedInt;
		}
		return new String(buffer);
	}

}// END
