public class Hw7cFinalTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s;
		int h;
		String result;
		
		
		s = "g";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());
		
		s = "HELLO";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());
		
		s = "good";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());
		
		s = "bye";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());
		
		s = "great";
		h = WeakStringHashCoder.weakStringCode(s);
		result = WeakStringHashDecoder.weakStringDecode(h);
		System.out.println("Decoded:  " + result);
		System.out.println("Expected:  " + s.toLowerCase());		

	}

}