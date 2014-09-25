public class Hw7cDraftTester {
	public static void main(String[] args) {
		String s;
		int h;
		String result;
		
		s = "g";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());

		s = "H";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());

		s = "r";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());

		s = "b";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());

		s = "e";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());		

	}
}