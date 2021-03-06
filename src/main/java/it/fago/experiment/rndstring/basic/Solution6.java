package it.fago.experiment.rndstring.basic;

import java.util.function.Supplier;

public class Solution6 {

	private static final int absXorShift32(int x) {
		x = (((x ^ (x << 13)) ^ x >>> 17) ^ x << 5);
		return (x ^ (x >> 31)) + (x >>> 31);
	}

	public static Supplier<String> randomString(String dictionary, int targetStringLength) {
		char[] buffer = new char[targetStringLength];
		for (int i = 0, len = dictionary
				.length(), x = (int) System.nanoTime(); i < targetStringLength; buffer[i] = dictionary
						.charAt(((x = absXorShift32(x)) % len)), i++)
			;
		return () -> new String(buffer);
	}

}// END
