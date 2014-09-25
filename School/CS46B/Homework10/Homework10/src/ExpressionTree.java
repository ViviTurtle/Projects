
public class ExpressionTree {

    private Node root = new Node();

    /**
     * Constructs a tree with one node and no children.
     *
     * @param val the value stored in the root.
     */
    public ExpressionTree(int val) {
        root.data = val;
    }

    /**
     * Constructs a tree with an operator at the root, with the given left and
     * right arguments for that operator.
     *
     * @param operator the operator represented by the root
     * @param left the expression to the left of the operator
     * @param right the expression to the right of the operator
     */
    public ExpressionTree(char operator, ExpressionTree left, ExpressionTree right) {
        if (!isOperator(operator)) {
            throw new IllegalArgumentException("Operator should be from {*, -, +}");
        }
        root.left = left.root;
        root.right = right.root;
        root.data = operator;
    }

    public boolean isOperator(Object operator) {
        if (operator != '*' && operator != '-' && operator != '+') {
            return false;
        }
        return true;
    }

    public String toString() {
           return root.toString();
    }

    public int eval() {
        return root.eval();


    }

    class Node {

        public Object data;
        public Node left;
        public Node right;

        public int eval() {
            if (!isOperator(data)) {
                return (int) data;
            }
            int left = root.left.eval();
            int right = root.right.eval();
            if (root.data == '*') {
                return left * right;
            }
            if (root.data == '-') {
                return left - right;
            }
            return left + right;
        }

        public String toString() {
            if (isOperator(data)) {
                return "(" + left.toString() + " " + (char) root.data + " " + right.toString() + ")" ;
            }
            int test = (int) data;
            return Integer.toString(test);
        }
    }
}
