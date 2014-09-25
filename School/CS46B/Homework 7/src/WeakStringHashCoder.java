public class WeakStringHashCoder {
	public static int weakStringCode(String s)
	{
		s = s.toLowerCase();
		final int HASH_MULTIPLIER = 31;
		int h = 0;
		for (int i = 0; i < s.length(); i++)
		   h = HASH_MULTIPLIER * h + (1 + s.charAt(i) - 'a');
		return h;
	}
}