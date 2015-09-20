public class Utility {

	static boolean[] answer;
	static int offby = 0;
	static int max = 0;

	public static boolean[] findMaximalClique(Graph g) {
		answer = new boolean[g.size()];
		Graph reduce;
		for (int j = 1; j <= g.size(); j++) {
			if (g.hasClique(j)) {
				max = j;
			}
		}
		offby = 0;
		help(g);
		return answer;
	}

	public static void help(Graph g) {
		int size = g.size();
		for (int i = 0; i < size - offby; i++) {
			Graph reduce = g.removeVertex(i);
			if (reduce.hasClique(max)) {
				answer[i + offby] = false;
				offby++;
				g = reduce; // if it still has the max clique the remove it.
				i--;
			} else {
				answer[i + offby] = true;
			}
		}
	}
	// int size() (Returns the number of vertices in a graph.)
	// Graph removeVertex (int i) (Returns a new graph with the specified vertex
	// removed. The Graph object being called is not modified. Vertices are
	// numbered starting from 0. It will also remove all edges incident to the
	// removed vertex. After removing a vertex of index i, all vertices with
	// higher indexes "move down" to take its place in the graph returned. That
	// is, the remaining vertices keep the same order, but are renumbered as
	// needed fill in from 0. If it is called with an invalid parameter, it will
	// return null.)
	// boolean hasClique(int i) (Returns true if there is a clique of size i or
	// greater in the graph.)

}
