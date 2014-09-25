
import java.util.ArrayList;

public class RecursiveSumDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(16);
        list.add(32);
        list.add(64);

        System.out.println(sum(list));
        System.out.println("Expected: 126");
    }

    public static int sum(ArrayList<Integer> list) {
        int count = 0;
        if (list.isEmpty()) {
            return count;
        } // Base case
        ArrayList<Integer> smallerList;
        smallerList = list;
        count += smallerList.remove(0);
        return sum(smallerList) + count;
        /* copy all but the first element to smallerList
         Add the first element to the sum of the smallerList
         */
        //... your code goes here
    }
}