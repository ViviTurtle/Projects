
import java.util.ArrayList;
import java.util.List;

public class Trees4 {

    public static void main(String[] args) {
        List<BinarySearchTree> trees = allTrees(6);
        int k = 1;
        for (BinarySearchTree t : trees) {
            fill(t.root, k);
            k++;
        }
        for (BinarySearchTree t : trees) {
            System.out.println(t);
        }
    }

    public static List<BinarySearchTree> allTrees(int n) {
        List<BinarySearchTree> l = new ArrayList<>();
        if (n == 0) {
            l.add(new BinarySearchTree());
        } else if (n == 1) {
            BinarySearchTree t = new BinarySearchTree();
            t.root = new BinarySearchTree.Node();
            l.add(t);
        } else {
            for (int k = 0; k < n; k++) {
                List<BinarySearchTree> l1 = allTrees(k);
                List<BinarySearchTree> l2 = allTrees(n - k - 1);
                for (BinarySearchTree t1 : l1) {
                    for (BinarySearchTree t2 : l2) {
                        BinarySearchTree t = new BinarySearchTree();
                        t.root = new BinarySearchTree.Node();
                        t.root.data = n;
                        t.root.left = t1.copy().root;
                        t.root.right = t2.copy().root;
                        l.add(t);
                    }
                }
            }
        }
        return l;
    }

    public static int fill(BinarySearchTree.Node n, int start) {
        if (n == null) {
            return start;
        }
        int r = fill(n.left, start);
        n.data = r;
        r = fill(n.right, r + 1);
        return r;
    }
  
}