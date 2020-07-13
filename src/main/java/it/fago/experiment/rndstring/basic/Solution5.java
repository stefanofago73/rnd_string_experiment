package it.fago.experiment.rndstring.basic;

public class Solution5 {

	 private static final int absXorShift32(int x){
		 x = (((x^(x<<13))^x>>>17)^x<<5);
		 return (x ^ (x >> 31)) + (x >>> 31);
	 }
	 
	public static String randomString(String dictionary, int targetStringLength) {
		char[] buffer = new char[targetStringLength];
		int len = dictionary.length();
		int x = (int)System.nanoTime();
		int randomLimitedInt;
		for (int i = 0; i < targetStringLength; i++) {
			randomLimitedInt = dictionary.charAt(  ((x=absXorShift32(x))%len) );
			buffer[i] = (char) randomLimitedInt;
		}
		return new String(buffer);
	}

}// END
