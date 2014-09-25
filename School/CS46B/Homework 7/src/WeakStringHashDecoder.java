
public class WeakStringHashDecoder {

    public static String result = "";

    public static String weakStringDecode(int h) {
        result = "";
        return helperWeakStringDecode(h);

    }

    private static String helperWeakStringDecode(int h) {
        if (h != 0) {
            int i = ((h % 31) - 1 + 'a');
            char[] c = new char[1];
            c[0] = (char) i;
            String s = new String(c);
            result = s + result;
            return helperWeakStringDecode((h - (h % 31)) / 31);
        }
        return result;


    }
}
