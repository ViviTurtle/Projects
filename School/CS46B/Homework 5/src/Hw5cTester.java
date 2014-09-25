import java.util.Comparator;


/***********DO NOT CHANGE THIS FILE BUT DO SUBMIT IT**************/
public class Hw5cTester {
    public static void main(String[] args)
    {
        Integer[] in1 = {4, 6, 2, 3, 1, 7, 9, 0};
        Hw5cCountingComparator comp = new Hw5cCountingComparator();
                
        Hw5c hw5c = new Hw5c(in1, comp);
        hw5c.sort();
        System.out.println(comp.getCount());
        System.out.println("Expected:  15"); 
    }    
}

