public class TwoThreeTree {
	private Node root;

	public TwoThreeTree() {
		root = null;
	}

	public String search(int x) {
		return root.search(x);
	}

	public boolean insert(int x) {
		if (root == null) {
			root = new Node(x);
			return true;
		} else
			return root.addNode((Comparable) x);

	}

	class Node {
		Comparable[] keys = new Comparable[3]; // [key0, key1, TEMP]
		Node[] children = new Node[4]; // [children0, children1, children2,
										// TEMP]
		int key_size = 0;
		int children_size = 0;
		Node parent;

		public Node(Comparable x) {
			keys[0] = x;
			key_size++;
		}

		public void split() {
			Node left = new Node(this.keys[0]);
			Node right = new Node(this.keys[2]);
			if (this == root) {
				keys[0] = keys[1];
				keys[1] = null;
				keys[2] = null;
				left.parent = root;
				right.parent = root;
				if (children_size == 4) {
					children[0].parent = left;
					children[1].parent = left;
					children[2].parent = right;
					children[3].parent = right;
					left.children[0] = children[0];
					left.children[1] = children[1];
					right.children[0] = children[2];
					right.children[1] = children[3];
					left.children_size = 2;
					right.children_size = 2;
				}
				children[0] = left;
				children[1] = right;
				children[2] = null;
				children[3] = null;
				children_size = 2;
				key_size = 1;
			} else {

				left.parent = parent;
				right.parent = parent;
				parent.remove_child(this);
				if (children_size == 4) {
					children[0].parent = left;
					children[1].parent = left;
					children[2].parent = right;
					children[3].parent = right;
					left.children[0] = children[0];
					left.children[1] = children[1];
					right.children[0] = children[2];
					right.children[1] = children[3];
					left.children_size = 2;
					right.children_size = 2;
				}
				parent.insert_children(left);
				parent.insert_children(right);
				parent.insert(keys[1]);

			}

		}

		public void remove_child(Node remove) {
			int i = 0;
			while (children[i] != remove) { // finds the node to be removed
				i++;
			}
			while (i < children_size) { // move everything down
				children[i] = children[++i];
			}
			children_size--;
		}

		public String search(Comparable x) {
			int i = 0;
			String answer = keys[0].toString();
			while (i < key_size && x.compareTo(keys[i]) > 0) {
				i++;
			}

			if (children_size == 0
					|| (keys[i] != null && x.compareTo(keys[i]) == 0)) { // if
																			// its
																			// a
				// leaf or
				// key is
				// there
				int j = 1;
				while (j < key_size) { // this is suppose to print everything
										// but key[0]
					answer = answer + " " + keys[j].toString();
					j++;
				}
				return answer;
			} else
				return children[i].search(x);
		}

		/**
		 * Inserts a new node as a descendant of this node
		 * 
		 * @param newNode
		 *            the node to insert
		 */
		public boolean addNode(Comparable x) {
			int i = 0;
			if (check_duplicates(x) == true) {
				return false;
			}
			if (children_size != 0) // if its not a leaf
			{
				while (keys[i] != null && x.compareTo(keys[i]) > 0) {
					i++;
				}
				return children[i].addNode(x);
			}
			return insert(x);
		}

		public boolean check_duplicates(Comparable x) {

			for (int i = 0; i < key_size; i++) {
				if (x.compareTo(keys[i]) == 0)
					return true;
			}
			return false;
		}

		public boolean insert(Comparable x) // insertion of an unfull leaf
		{
			for (int i = 0; i < key_size; i++) {
				if (x.compareTo(keys[i]) <= 0) {

					for (int j = 1; j > i - 1; j--) // slides all values up
					{
						keys[j + 1] = keys[j];
					}
					keys[i] = x;
					key_size++;
					if (key_size == 3) {
						split();
					}
					return true;
				}
			}
			keys[key_size] = x;
			key_size++;
			if (key_size == 3) {
				split();
			}
			return true;

		}

		public void insert_children(Node x) {
			boolean change = false;
			{
				for (int i = 0; i < children_size && change == false; i++) {
					if (x.keys[0].compareTo(children[i].keys[0]) < 0) {
						for (int j = 2; j >= i; j--) // slides all values up
						{
							children[j + 1] = children[j];
						}
						children[i] = x;
						children_size++;
						change = true;
					}
				}
				if (change == false) {
					children[children_size] = x;
					children_size++;
				}
			}
		}

	}

}
