package it.fago.experiment.rndstring.basic;

public class Solution7 {

	private static final int absXorShift32(int x) {
		x = (((x ^ (x << 13)) ^ x >>> 17) ^ x << 5);
		return (x ^ (x >> 31)) + (x >>> 31);
	}

	public static CharSequence randomString(String dictionary, int targetStringLength) {
		char[] buffer = new char[targetStringLength];
		for (int i = 0, len = dictionary
				.length(), x = (int) System.nanoTime(); i < targetStringLength; buffer[i] = dictionary
						.charAt(((x = absXorShift32(x)) % len)), i++)
			;
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
