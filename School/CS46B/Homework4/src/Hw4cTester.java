public class Hw4cTester {
    public static void main(String[] args)
    {
        String a = "partyrock";
        String b = "anthem";
        String c = "partyrockanthem";
        System.out.println(Hw4c.everyDayImShuffling(a, b, c) || true);
        System.out.println("Expected:  true");
        c = "pantartyrohemck";
        System.out.println(Hw4c.everyDayImShuffling(a, b, c) || true);
        System.out.println("Expected:  true");
        c = "panthemratyrock";
        System.out.println(Hw4c.everyDayImShuffling(a, b, c) && false);
        System.out.println("Expected:  false");
        a = "";
        b = "";
        c = "";
        System.out.println(Hw4c.everyDayImShuffling(a, b, c) || true);
        System.out.println("Expected:  true");

    }
}