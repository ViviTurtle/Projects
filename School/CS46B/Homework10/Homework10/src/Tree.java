
import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    /**
     * Constructs a tree with one node and no children.
     *
     * @param rootData the data for the root
     */
    public Tree(Object rootData) {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
     * Constructs an empty tree, with null for a root.
     */
    public Tree() {
    }

    /**
     * Adds a subtree as the last child of the root. Doesn't work on an empty
     * tree.
     */
    public void addSubtree(Tree subtree) {
        root.children.add(subtree.root);
    }

    public int nodesWithOddNumberChildren() {
        
        if (root == null) {
            return 0;
        }
        return root.nodesWithOddNumberChildren();
    }
}

class Node {

    public Object data;
    public List<Node> children;

    public int nodesWithOddNumberChildren() {
        int count = 0;
        if (children == null ) {
            return 0;
        }
        if (children.size() % 2 == 1) {
            count++;
        }
        for (int i = 0; i < children.size(); i++) {
            count += children.get(i).nodesWithOddNumberChildren();
        }
        return count;
    }
}
