package it.fago.experiment.rndstring.streams;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Solution2Stream {

  public static String _rndStringWithStreamFrom(String dictionary,int rndStringLength) {
	char[] buffer = new char[rndStringLength];
	int [] counter = {0};
	
	current()
	  .ints(0, dictionary.length())
	    .limit(rndStringLength)
	    .map(dictionary::charAt)
         .forEach(value->buffer[counter[0]++]=(char)value);
	
	return new String(buffer);
}

}// END
