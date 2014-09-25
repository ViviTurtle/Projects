public class Hw5aTester {
    public static void main(String[] args)
    {
        int[] in1 = {9, 5, 3, 7, 1};
        Hw5a hw5a = new Hw5a(in1);
        hw5a.sort(2);
        System.out.println(hw5a);
        System.out.println("Expected:  [1, 5, 3, 7, 9]");  

        
        int[] in2 = {1, 5, 3, 7, 9, 8, 4, 6, 2, 10, 0};
        hw5a = new Hw5a(in2);
        hw5a.sort(4);
        System.out.println(hw5a);
        System.out.println("Expected:  [1, 5, 3, 6, 0, 2, 4, 7, 8, 9, 10]");   
    }
}
