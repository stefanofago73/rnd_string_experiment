package it.fago.experiment.rndstring.streams;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Solution3Stream {

	public static String _rndStringWithStreamFrom(String dictionary, int rndStringLength) {
		char[] buffer = new char[rndStringLength];
		int[] counter = { 0 };
		
		current()
		   .ints(0, dictionary.length())
		      .limit(rndStringLength)
		      .forEach(value ->buffer[counter[0]++] = dictionary.charAt(value));
		
		return new String(buffer);
	}

}// END
