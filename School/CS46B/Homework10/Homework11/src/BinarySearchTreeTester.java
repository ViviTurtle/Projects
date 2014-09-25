
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTreeTester {

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();

        b.add("G");
        b.add("B");
        b.add("I");
        b.add("A");
        b.add("E");
        b.add("H");
        b.add("D");
        b.add("F");
        b.add("C");

        b.print();

        Iterator it = b.iterator();

        System.out.println();

        System.out.println(it.hasNext());
        System.out.println("Expected: true");

        System.out.println(it.next());
        System.out.println("Expected: A");
        
        

        System.out.println(it.next());
        System.out.println("Expected: B");
        
        it.remove();
        
        System.out.println(it.next());
        System.out.println("Expected: C");

        it.next();

        System.out.println("\nBEFORE REMOVE");
        b.print();
        it.remove();
        System.out.println("AFTER REVOVE");
        b.print();
        System.out.println();

        try {
            it.remove();
        } catch (IllegalStateException ex) {
            System.out.println("IllegalStateException");
        }
        System.out.println("Expected: IllegalStateException");

        /*
         System.out.println(it.next());
         System.out.println("Expected: D"); */

        System.out.println(it.next());
        System.out.println("Expected: E");

        System.out.println(it.next());
        System.out.println("Expected: F");

        System.out.println(it.next());
        System.out.println("Expected: G");

        System.out.println(it.next());
        System.out.println("Expected: H");

        System.out.println(it.next());
        System.out.println("Expected: I");

        System.out.println(it.hasNext());
        System.out.println("Expected: false");

        try {
            it.next();
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }
        System.out.println("Expected:  NoSuchElementException");


        System.out.println("\nBEFORE REMOVE");
        b.print();
        it.remove();
        System.out.println("AFTER REVOVE");
        b.print();
        System.out.println();

        try {
            it.remove();
        } catch (IllegalStateException ex) {
            System.out.println("IllegalStateException");
        }
        System.out.println("Expected: IllegalStateException");


        System.out.println("_________________________________");

        BinarySearchTree c = new BinarySearchTree();
        c.add(50);
        c.add(25);
        c.add(75);
        c.add(15);
        c.add(35);
        c.add(65);
        c.add(100);

        c.print();

        Iterator it1 = c.iterator();

        System.out.println();

        System.out.println(it1.hasNext());
        System.out.println("Expected: true");

        System.out.println(it1.next());
        System.out.println("Expected: 15");

        System.out.println(it1.next());
        System.out.println("Expected: 25");

        System.out.println(it1.next());
        System.out.println("Expected: 35");

        System.out.println(it1.next());
        System.out.println("Expected: 50");

        System.out.println(it1.next());
        System.out.println("Expected: 65");

        System.out.println(it1.next());
        System.out.println("Expected: 75");

        System.out.println(it1.next());
        System.out.println("Expected: 100");

        System.out.println(it1.hasNext());
        System.out.println("Expected: false");
        
        try {
            it1.next();
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException");
        }
        System.out.println("Expected: NoSuchElementException");
        
        System.out.println("\nBEFORE REMOVE");
        c.print();
        it1.remove();
        System.out.println("After REMOVE");
        c.print();
        
        try {
            it1.remove();
        } catch (IllegalStateException ex) {
            System.out.println("IllegalStateException");
        }
        System.out.println("Expected: IllegalStateException");
    }
}