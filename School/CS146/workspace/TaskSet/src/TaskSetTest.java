import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TaskSetTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void default_test() {
		TaskSet ts = new TaskSet();
		ts.addTask(8);
		ts.addTask(3);
		ts.addTask(5);
		assertEquals(8, ts.minCompletionTime(), .000001);
		ts.addConstraint(0, 2);
		assertEquals(13, ts.minCompletionTime());
		ts.addConstraint(0, 1);
		assertEquals(13, ts.minCompletionTime());
		assertEquals(5, ts.getStartTime(0));
		assertEquals(0, ts.getStartTime(1));
		assertEquals(0, ts.getStartTime(2));
		ts.addConstraint(1, 2);
		assertEquals(16, ts.minCompletionTime());
		assertEquals(8, ts.getStartTime(0));
		assertEquals(5, ts.getStartTime(1));
		assertEquals(0, ts.getStartTime(2));
		ts.addConstraint(1, 0);
		assertEquals(-1, ts.minCompletionTime());
		assertEquals(-1, ts.getStartTime(0));
		assertEquals(-1, ts.getStartTime(1));
		assertEquals(0, ts.getStartTime(2));

	}

	@Test
	public void unconnected_test() {
		TaskSet ts = new TaskSet();
		for (int i = 0; i < 100; i++) {
			ts.addTask(i);
		}
		assertEquals(99, ts.minCompletionTime());
		for (int j = 0; j < 100; j++) {
			assertEquals(0, ts.getStartTime(j));
		}
	}

	@Test
	public void connected_test() {
		int answer = 0;
		TaskSet ts = new TaskSet();
		for (int i = 0; i < 100; i++) {
			ts.addTask(i);
		}
		for (int i = 0; i < 99; i++) {
			ts.addConstraint(i, i + 1);
		}
		for (int j = 0; j < 100; j++) {
			answer += j;
		}
		assertEquals(answer, ts.minCompletionTime());

	}

	@Test
	public void disjoint_Test() {
		TaskSet ts = new TaskSet();
		for (int i = 0; i < 10; i++) {
			ts.addTask(i);
		}
		ts.addConstraint(0, 2);
		ts.addConstraint(2, 4);
		ts.addConstraint(4, 6);
		ts.addConstraint(6, 8);
		ts.addConstraint(1, 3);
		ts.addConstraint(3, 5);
		ts.addConstraint(5, 7);
		ts.addConstraint(7, 9);
		assertEquals(25, ts.minCompletionTime());
		assertEquals(20, ts.getStartTime(0));
		assertEquals(24, ts.getStartTime(1));
		assertEquals(18, ts.getStartTime(2));
		assertEquals(21, ts.getStartTime(3));
		assertEquals(14, ts.getStartTime(4));
		assertEquals(16, ts.getStartTime(5));
		assertEquals(8, ts.getStartTime(6));
		assertEquals(9, ts.getStartTime(7));
		assertEquals(0, ts.getStartTime(8));
		assertEquals(0, ts.getStartTime(9));

	}

	@Test
	public void real_Test() {
		TaskSet ts = new TaskSet();
		ts.addTask(11);// 0
		ts.addTask(10);// 1
		ts.addTask(9);// 2
		ts.addTask(8);// 3
		ts.addTask(7);// 4
		ts.addTask(5);// 5
		ts.addTask(3);// 6
		ts.addTask(2);// 7
		ts.addConstraint(0, 5);
		ts.addConstraint(0, 4);
		ts.addConstraint(7, 0);
		ts.addConstraint(1, 0);
		ts.addConstraint(2, 0);
		ts.addConstraint(2, 3);
		ts.addConstraint(3, 4);
		ts.addConstraint(3, 6);
		ts.addConstraint(1, 6);
		assertEquals(27, ts.minCompletionTime());
		assertEquals(7, ts.getStartTime(0));
		assertEquals(18, ts.getStartTime(1));
		assertEquals(18, ts.getStartTime(2));
		assertEquals(7, ts.getStartTime(3));
		assertEquals(0, ts.getStartTime(4));
		assertEquals(0, ts.getStartTime(5));
		assertEquals(0, ts.getStartTime(6));
		assertEquals(18, ts.getStartTime(7));
	}

	@Test
	public void real_test2() {
		TaskSet ts = new TaskSet();
		ts.addTask(1);// 0
		ts.addTask(2);// 1
		ts.addTask(3);// 2
		ts.addTask(4);// 3
		ts.addTask(5);// 4
		ts.addTask(6);// 5
		ts.addTask(7);// 6
		ts.addConstraint(6, 0);
		ts.addConstraint(4, 0);
		ts.addConstraint(3, 0);
		ts.addConstraint(2, 1);
		ts.addConstraint(4, 1);
		ts.addConstraint(5, 1);
		ts.addConstraint(3, 2);
		ts.addConstraint(4, 2);
		ts.addConstraint(5, 4);
		ts.addConstraint(6, 5);
		assertEquals(0, ts.getStartTime(0));
		assertEquals(0, ts.getStartTime(1));
		assertEquals(2, ts.getStartTime(2));
		assertEquals(5, ts.getStartTime(3));
		assertEquals(5, ts.getStartTime(4));
		assertEquals(10, ts.getStartTime(5));
		assertEquals(16, ts.getStartTime(6));
	}

	@Test
	public void loop_test() {
		TaskSet ts = new TaskSet();
		ts.addTask(1);// 0
		ts.addTask(2);// 1
		ts.addTask(3);// 2
		ts.addTask(4);// 3
		ts.addTask(5);// 4
		ts.addTask(6);// 5
		ts.addTask(7);// 6
		ts.addConstraint(4, 3);
		ts.addConstraint(0, 4);
		ts.addConstraint(0, 3);
		ts.addConstraint(1, 0);
		ts.addConstraint(1, 5);
		ts.addConstraint(2, 1);
		ts.addConstraint(3, 2);
		ts.addConstraint(2, 6);
		assertEquals(-1, ts.getStartTime(0));
		assertEquals(-1, ts.getStartTime(1));
		assertEquals(-1, ts.getStartTime(2));
		assertEquals(-1, ts.getStartTime(3));
		assertEquals(-1, ts.getStartTime(4));
		assertEquals(0, ts.getStartTime(5));
		assertEquals(0, ts.getStartTime(6));
	}

	@Test
	public void loop_test2() {
		TaskSet ts = new TaskSet();
		ts.addTask(1);// 0
		ts.addTask(2);// 1
		ts.addTask(3);// 2
		ts.addTask(4);// 3
		ts.addTask(5);// 4
		ts.addTask(6);// 5
		ts.addTask(7);// 6
		ts.addConstraint(4, 3);
		ts.addConstraint(0, 4);
		ts.addConstraint(0, 3);
		ts.addConstraint(1, 0);
		ts.addConstraint(2, 1);
		ts.addConstraint(3, 2);
		ts.addConstraint(3, 5);
		ts.addConstraint(6, 4);
		assertEquals(-1, ts.getStartTime(0));
		assertEquals(-1, ts.getStartTime(1));
		assertEquals(-1, ts.getStartTime(2));
		assertEquals(-1, ts.getStartTime(3));
		assertEquals(-1, ts.getStartTime(4));
		assertEquals(0, ts.getStartTime(5));
		assertEquals(-1, ts.getStartTime(6));
	}

	@Test
	public void effeciency_test1() {
		TaskSet ts = new TaskSet();
		for (int i = 0; i < 100; i++) {
			ts.addTask(2);
		}
		for (int i = 99; i > 0; i--) {
			ts.addConstraint(i, i - 1);
		}
		assertEquals(0, ts.getStartTime(0));
		assertEquals(2, ts.getStartTime(1));

	}
}
