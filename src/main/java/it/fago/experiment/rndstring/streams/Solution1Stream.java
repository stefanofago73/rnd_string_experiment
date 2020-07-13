package it.fago.experiment.rndstring.streams;

import java.util.stream.Stream;

public class Solution1Stream {

	private static final int absXorShift32(int x) {
		x = (((x ^ (x << 13)) ^ x >>> 17) ^ x << 5);
		return (x ^ (x >> 31)) + (x >>> 31);
	}

	public static String _rndStringWithStreamFrom(String dictionary, int rndStringLength) {
		char[] buffer = new char[rndStringLength];
		int[] counter = { 0 };
		int[] x = new int[] { (int) System.nanoTime() };
		int len = dictionary.length();

		Stream
		    .generate(() -> x[0] = absXorShift32(x[0]))
		       .limit(rndStringLength)
		       .map(i -> i % len)
			.forEach(value -> buffer[counter[0]++] = dictionary.charAt(value));
		
		return new String(buffer);
	}

}// END
