package it.fago.experiment.rndstring.streams;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Solution4Stream {

	public static CharSequence _rndStringWithStreamFrom(String dictionary, int rndStringLength) {
		char[] buffer = new char[rndStringLength];
		int[] counter = { 0 };

		current()
		  .ints(rndStringLength, 0, dictionary.length())
				.forEach(value -> buffer[counter[0]++] = dictionary.charAt(value));

		return ImmutableCharSequence.create(buffer);
	}

	interface ImmutableCharSequence extends CharSequence {

		char[] buffer();

		default int length() {
			return buffer().length;
		}

		default char charAt(int index) {
			return buffer()[index];
		}

		default CharSequence subSequence(int start, int end) {
			int len = end - start;
			char[] newBuffer = new char[len];
			System.arraycopy(buffer(), start, newBuffer, 0, len);
			return ((ImmutableCharSequence) () -> newBuffer);
		}

		public static ImmutableCharSequence create(char[] buffer) {
			return new ImmutableCharSequence() {

				private volatile String representation;

				public String toString() {
					return representation == null ? (representation = new String(buffer)) : representation;
				}

				@Override
				public char[] buffer() {
					return buffer;
				}

			};
		}

	}// END

}// END
