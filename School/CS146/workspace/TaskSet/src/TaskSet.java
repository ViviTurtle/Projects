import java.util.LinkedList;

public class TaskSet {
	LinkedList<Node> all = new LinkedList<Node>();
	public int node_number = 0;
	LinkedList<Node> temp = new LinkedList<Node>();
	private static final int infinity = -999999999;
	LinkedList<Integer> constraints = new LinkedList<Integer>();
	private boolean finished;
	private boolean wholeSet;

	TaskSet() {
	}

	public void addTask(int x) {
		all.add(new Node(x));
		temp.add(new Node(x));
		node_number++;
	}

	public void addConstraint(int i, int j) {
		all.get(i).contraintin();
		all.get(j).contraintout(all.get(i));
		temp.get(i).contraintin();
		temp.get(j).contraintout(temp.get(i));
		constraints.add(i);
		constraints.add(j);
	}

	public void addConstraint(int i, int j, LinkedList<Node> hi) {
		hi.get(i).contraintin();
		hi.get(j).contraintout(hi.get(i));
	}

	public int minCompletionTime() {
		wholeSet = true; // go through the whole set
		return minCompletionTime(null);
	}

	public int minCompletionTime(Node k) {
		int answer;
		int relaxation = infinity;
		int max = infinity;
		finished = false;
		Node source = k;
		LinkedList<Node> sorted = topSort(k);
		temp = clone(all);
		// iterates in order for
		for (int i = 0; i < sorted.size(); i++) {
			if (sorted.get(i).relax == infinity) {
				relaxation = sorted.get(i).time;
				sorted.get(i).relax = relaxation;
				if (relaxation > max) {
					max = relaxation;
				}
			}
			for (int j = 0; j < sorted.get(i).out.size(); j++) {
				relaxation = sorted.get(i).relax
						+ sorted.get(i).out.get(j).time;
				if (sorted.get(i).out.get(j).relax < relaxation) {
					sorted.get(i).out.get(j).relax = relaxation;
				}
			}
			if (relaxation > max) {
				max = relaxation;
			}
		}
		answer = sorted.getLast().relax;
		for (int l = 0; l < sorted.size(); l++) {
			sorted.get(l).relax = infinity;
		}
		if (wholeSet == true) {
			if (sorted.size() < all.size()) {
				return -1;
			}
			wholeSet = false;
			return max;
		}
		// If its the node were looking for
		if (source.originalIndex == sorted.getLast().originalIndex
				&& wholeSet == false) {
			return answer;
		}
		return -1;
	}

	public LinkedList<Node> clone(LinkedList<Node> original) {
		LinkedList<Node> copy2 = new LinkedList<Node>();
		int copy_time;
		node_number = 0;
		for (Node copy : original) {
			copy_time = copy.time;
			copy2.add(new Node(copy_time));
			node_number++;
		}
		for (int k = 0; k < constraints.size(); k = k + 2) {
			addConstraint(constraints.get(k), constraints.get(k + 1), copy2);
		}
		return copy2;
	}

	public int getStartTime(int k) {
		wholeSet = false;
		int start = minCompletionTime(all.get(k));
		if (start == -1) {
			return -1;
		}
		return start - all.get(k).time;
	}

	public LinkedList<Node> topSort(Node k) {
		LinkedList<Node> answer = new LinkedList<Node>();
		LinkedList<Node> add = new LinkedList<Node>();
		Node finish;
		if (k == null) {
			finish = null;
		} else
			finish = temp.get(k.index);
		while (finished == false) {
			add = search(temp, finish);
			if (add.isEmpty()) {
				return answer;
			} else
				answer.addAll(add);
		}
		return answer;

	}

	private LinkedList<Node> search(LinkedList<Node> queue, Node finish) {
		LinkedList<Node> answer = new LinkedList<Node>();
		Node delete, check;
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).in == 0) {
				check = queue.get(i);
				delete = temp.remove(check.index);
				if (delete == finish || temp.isEmpty()) {
					finished = true;
					answer.add(all.get(delete.originalIndex));
					return answer;
				}
				for (int j = check.index; j < temp.size() && j >= 0; j++) {
					temp.get(j).index--;
				}
				answer.addAll(DFS_thing(delete));
			}
		}
		return answer;
	}

	private LinkedList<Node> DFS_thing(Node added) {
		LinkedList<Node> answer = new LinkedList<Node>();
		Node temp2;
		answer.add(all.get(added.originalIndex));
		// decrements all the in degrees of this node by one
		while (added.out.size() != 0) {
			// records and removes the tail of this node
			temp2 = (added.out.removeLast());
			temp2.in--;
		}
		return answer;
	}

	class Node {
		int in = 0;
		LinkedList<Node> out = new LinkedList<Node>();
		public int time = 0;
		public int index;
		public int originalIndex;
		public int relax = infinity;

		public Node(int x) {
			index = node_number;
			originalIndex = node_number;
			time = x;
		}

		public Node(int x, int index) {
			originalIndex = index;
			time = x;
			this.index = index;
		}

		public void relax(int x) {
			relax = x;
		}

		public void contraintout(Node i) {
			out.add(i);
		}

		public void contraintin() {
			in++;
		}

	}

}