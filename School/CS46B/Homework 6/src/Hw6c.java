
import java.util.LinkedList;
import java.util.ListIterator;

public class Hw6c {

    public static void breeze(LinkedList<Student> students) {
        ListIterator<Student> iterator = students.listIterator();
        while (iterator.hasNext()) {
            iterator.next(); //moves the iterator to the last element
        }
        iterator.previous(); //movies the iterator to the second to last element
        while (iterator.hasPrevious()) {
            Student s1 = iterator.previous();
            if (!s1.didShower()) {
                iterator.next();
                iterator.next();
                iterator.remove();
                iterator.previous();

            }
        }

    }
}
