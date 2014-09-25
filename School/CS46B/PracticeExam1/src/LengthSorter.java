
import java.util.Arrays;
import java.util.Comparator;

public class LengthSorter {

    public static void main(String[] args) {

        class StringLengthComparator implements Comparator<String>
        {
       
            public int compare(String first, String second) {
                if (first.length() > second.length()) {
                    return 1;
                } else if (first.length() < second.length()) {
                    return -1;
                }
                return 0;
            }
        }

        String[] names = {"Oklahoma", "Maryland", "California", "Nevada",
            "Texas", "Arizona"};

        Arrays.sort(names, new StringLengthComparator());
        System.out.println(Arrays.toString(names));
    }
}