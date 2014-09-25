
import java.util.ArrayList;
import java.util.List;

public class Trees3 {

    public static void main(String[] args) {
        for (BinaryTree t : allTrees(6)) {
            if (t.height() == 3) {
                System.out.println(t);
            }
        }
    }

    public static List<BinaryTree> allTrees(int n) {
        List<BinaryTree> l = new ArrayList<>();
        if (n == 0) {
            l.add(new BinaryTree());
        } else if (n == 1) {
            l.add(new BinaryTree(n));
        } else {
            for (int k = 0; k < n; k++) {
                List<BinaryTree> l1 = allTrees(k);
                List<BinaryTree> l2 = allTrees(n - k - 1);
                for (BinaryTree t1 : l1) {
                    for (BinaryTree t2 : l2) {
                        l.add(new BinaryTree(n, t1, t2));
                    }
                }
            }
        }
        return l;
    }
}