import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap {
	private ArrayList<Student> students;

	public MaxHeap(int capacity) {
		students = new ArrayList<Student>(capacity);
	}

	public MaxHeap(Collection<Student> collection) {
		students = new ArrayList<Student>(collection);
		for (int i = size() / 2; i >= 0; i--) {
			maxHeapify(i);
		}
	}

	public Student getMax() {
		if (size() < 1) {
			throw new IndexOutOfBoundsException(
					"No maximum value:  the heap is empty.");
		}
		return students.get(0);
	}

	public Student extractMax() {
		Student value = getMax();
		swap(0, students.size() - 1);
		students.get(0).setIndex(0);
		students.remove(size() - 1);
		maxHeapify(0);
		return value;
	}

	// inserts a new student to the heap
	// @param elt the student to be inserted
	public void insert(Student elt) {
		int index, temp;
		students.add(elt);
		students.get(students.size() - 1).setIndex(students.size() - 1);
		index = students.size() - 1;
		while (students.get(index).compareTo(students.get(parent(index))) == 1) {
			temp = parent(index);
			swap(index, parent(index));
			index = temp; // changes index so it almost recursively keeps
							// swapping in this loop
		}
	}

	public void changeGPA(Student s, double newGPA) {
		// int index = students.indexOf(s);
		int index = s.index;
		students.get(index).setGPA(newGPA);
		while (students.get(index).compareTo(students.get(parent(index))) == 1) { // reorders
																					// going
																					// up.
			int temp = parent(index);
			swap(index, parent(index));
			index = temp;
		}
		maxHeapify(index);

	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int left(int index) {
		return 2 * index + 1;
	}

	private int right(int index) {
		return 2 * index + 2;
	}

	private int size() {
		return students.size();
	}

	private void swap(int from, int to) {
		Student val = students.get(from);
		students.set(from, students.get(to));
		students.set(to, val);
		int temp = students.get(from).getIndex();
		students.get(from).setIndex(students.get(to).getIndex());
		students.get(to).setIndex(temp);
	}

	private void maxHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int largest = index;
		if (left < size()
				&& students.get(left).compareTo(students.get(largest)) > 0) {
			largest = left;
		}
		if (right < size()
				&& students.get(right).compareTo(students.get(largest)) > 0) {
			largest = right;
		}
		if (largest != index) {
			swap(index, largest);
			maxHeapify(largest);
		}
	}
}
