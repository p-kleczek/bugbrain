package pkleczek.bugbrain.utils;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public class BugMath {
	public static final int SIGNAL_AMPLITUDE = 100;

	public static int clamp(int value) {
		return ((abs(value) > SIGNAL_AMPLITUDE) ? (SIGNAL_AMPLITUDE * (int) signum(value))
				: value);
	}

	public static int clamp(int value, int min, int max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}
}
