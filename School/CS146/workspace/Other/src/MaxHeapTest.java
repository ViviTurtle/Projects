import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {
	private MaxHeap heap;

	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap(15);
		heap.insert(new Student("Susan", 60, 3.5));
		heap.insert(new Student("Ben", 70, 3.4));
		heap.insert(new Student("Reed", 120, 4.0));
		heap.insert(new Student("Jackie", 100, 2.0));
		heap.insert(new Student("Chris", 80, 4.0));
		heap.insert(new Student("Michael", 70, 1.0));
		heap.insert(new Student("Anthony", 40, 3.9));
		heap.insert(new Student("Alyssa", 110, 1.5));
		heap.insert(new Student("Mitchica", 150, 2.3));
		heap.insert(new Student("Flora", 95, 4.3));
		heap.insert(new Student("Lisa", 40, 3.8));
		heap.insert(new Student("Roatanak", 10, 3.2));
	}

	@Test
	public void test1() {
		assertEquals(4.3, heap.extractMax().gpa(), .000001);
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		assertEquals(3.9, heap.extractMax().gpa(), .000001);
		assertEquals(3.8, heap.extractMax().gpa(), .000001);
		assertEquals(3.5, heap.extractMax().gpa(), .000001);
		assertEquals(3.4, heap.extractMax().gpa(), .000001);
		assertEquals(3.2, heap.extractMax().gpa(), .000001);
		assertEquals(2.3, heap.extractMax().gpa(), .000001);
	}

	@Test
	public void test2() {
		Student Todd = new Student("Todd", 200, 5.0);
		Student David = new Student("Taylor", 10, 1.0);
		heap.insert(Todd);
		heap.insert(David);
		assertEquals(5.0, heap.getMax().gpa(), .000001);
		heap.changeGPA(Todd, 2.0);
		assertEquals(4.3, heap.extractMax().gpa(), .000001);
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		heap.changeGPA(David, 5.0);
		assertEquals(5.0, heap.getMax().gpa(), .000001);
		heap.changeGPA(David, 3.0);
		assertEquals(3.9, heap.extractMax().gpa(), .000001);
		assertEquals(3.8, heap.extractMax().gpa(), .000001);
		assertEquals(3.5, heap.extractMax().gpa(), .000001);
		assertEquals(3.4, heap.extractMax().gpa(), .000001);
		assertEquals(3.2, heap.extractMax().gpa(), .000001);
		assertEquals(3.0, heap.getMax().gpa(), .000001);
		assertEquals(3.0, heap.getMax().gpa(), .000001);

	}

	@Test
	public void test3() {
		Student Todd = new Student("Todd", 200, 2.6);
		Student David = new Student("Taylor", 10, 1.0);
		heap.insert(Todd);
		heap.insert(David);
		assertEquals(4.3, heap.extractMax().gpa(), .000001);
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		heap.insert(new Student("Tom", 0, 3.75));
		assertEquals(3.9, heap.extractMax().gpa(), .000001);
		assertEquals(3.8, heap.extractMax().gpa(), .000001);
		assertEquals(3.75, heap.extractMax().gpa(), .000001); // should delete
		heap.changeGPA(David, 3.3);
		heap.insert(new Student("Tom", 0, 3.75));
		assertEquals(3.75, heap.extractMax().gpa(), .000001); // deletes Tom
		assertEquals(3.5, heap.extractMax().gpa(), .000001);
		assertEquals(3.4, heap.extractMax().gpa(), .000001);
		assertEquals(3.3, heap.extractMax().gpa(), .000001); // Deletes David
		assertEquals(3.2, heap.extractMax().gpa(), .000001);
		assertEquals(2.6, heap.getMax().gpa(), .000001); // Looks at Todd
		heap.insert(new Student("Tom", 0, 1.9));
		heap.changeGPA(Todd, 1.3);
		assertEquals(2.3, heap.extractMax().gpa(), .000001);
		assertEquals(2.0, heap.extractMax().gpa(), .000001);
		assertEquals(1.9, heap.extractMax().gpa(), .000001); // deletes tom
		assertEquals(1.5, heap.extractMax().gpa(), .000001);
		assertEquals("Todd", heap.getMax().getName());
		assertEquals(1.3, heap.extractMax().gpa(), .000001);// deletes todd
		assertEquals(1.0, heap.extractMax().gpa(), .000001);
	}

	@Test
	public void test4() {
		ArrayList heap2 = new ArrayList<Student>();
		heap2.add(new Student("Susan", 60, 3.5));
		heap2.add(new Student("Ben", 70, 3.4));
		heap2.add(new Student("Reed", 120, 4.0));
		heap2.add(new Student("Jackie", 100, 2.0));
		heap2.add(new Student("Chris", 80, 4.0));
		heap2.add(new Student("Michael", 70, 1.0));
		heap2.add(new Student("Anthony", 40, 3.9));
		heap2.add(new Student("Alyssa", 110, 1.5));
		heap2.add(new Student("Mitchica", 150, 2.3));
		heap2.add(new Student("Flora", 95, 4.3));
		heap2.add(new Student("Lisa", 40, 3.8));
		heap2.add(new Student("Roatanak", 10, 3.2));
		Student Todd = new Student("Todd");
		Todd.setGPA(3.95);
		Todd.setUnits(200);
		MaxHeap heap3 = new MaxHeap(heap2);
		heap3.insert(Todd);
		assertEquals(4.3, heap3.extractMax().gpa(), .000001);
		assertEquals(4.0, heap3.extractMax().gpa(), .000001);
		assertEquals(4.0, heap3.extractMax().gpa(), .000001);
		assertEquals(200, heap3.getMax().units(), .000001); // todd is here
		heap3.getMax().setUnits(250);
		assertEquals(250, heap3.getMax().units(), .000001); // todd is here
		assertEquals(3.95, heap3.extractMax().gpa(), .000001);
		assertEquals(3.9, heap3.extractMax().gpa(), .000001);

	}

	@Test
	public void test5() {
		MaxHeap heap4 = new MaxHeap(15);
		Student todd = new Student("todd");
		todd.setGPA(5.0);
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(todd);
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		assertEquals(5.0, heap4.getMax().gpa(), .000001);
		heap4.changeGPA(todd, 3.3);
		for (int i = 0; i < 17; i++) {
			assertEquals(3.5, heap4.extractMax().gpa(), .000001);
		}
		assertEquals(3.3, heap4.getMax().gpa(), .000001);
		heap4.insert(new Student("Bob", 60, -3.5));
		heap4.insert(new Student("Bob", 60, -3.7));
		heap4.insert(new Student("Susan", 60, 3.5));
		heap4.insert(new Student("Susan", 60, 3.5));
		assertEquals(3.5, heap4.extractMax().gpa(), .000001);
		assertEquals(3.5, heap4.extractMax().gpa(), .000001);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test6() {
		for (int i = 0; i < 12; i++) {
			heap.extractMax();
		}
		heap.extractMax();

	}

}
