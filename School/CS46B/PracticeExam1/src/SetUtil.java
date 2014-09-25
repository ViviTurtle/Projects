
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetUtil {

    public static Set union(Set A, Set B) {
        String cat;
        Set C = new TreeSet();
        for (Object cats : A) {
            C.add(cats);
        }
        for (Object cats : B) {
            C.add(cats);
        }
        return C;
    }
    
}