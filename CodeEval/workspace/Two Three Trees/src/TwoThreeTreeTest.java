import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TwoThreeTreeTest {
	private TwoThreeTree tree;

	@Before
	public void setUp() throws Exception {
		tree = new TwoThreeTree();

	}

	@Test
	public void test1() {
		for (int i = 7; i > 0; i--) {
			tree.insert(i);
		}
		for (int j = 1; j < 8; j++) {
			assertEquals(Integer.toString(j), tree.search(j));
		}

	}

	@Test
	public void test2() {
		for (int i = 1; i < 8; i++) {
			tree.insert(i);
		}
		for (int j = 7; j > 0; j--) {
			assertEquals(Integer.toString(j), tree.search(j));
		}

	}

	@Test
	public void test3() {
		tree.insert(1);
		tree.insert(7);
		tree.insert(2);
		tree.insert(5);
		tree.insert(6);
		tree.insert(4);
		tree.insert(3);
		for (int j = 1; j < 8; j++) {
			assertEquals(Integer.toString(j), tree.search(j));
		}
	}

	@Test
	public void test4() {
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		assertEquals(Integer.toString(1), tree.search(1));
		assertEquals(Integer.toString(2), tree.search(2));
		assertEquals(Integer.toString(3), tree.search(3));
		tree.insert(4);
		assertEquals("3 4", tree.search(3));
		assertEquals("3 4", tree.search(4));
		tree.insert(5);
		assertEquals("5", tree.search(5));
		assertEquals("2 4", tree.search(2));
		assertEquals("2 4", tree.search(4));
		assertEquals("3", tree.search(3));
	}

	@Test
	public void test5() {
		tree.insert(1);
		tree.insert(7);
		tree.insert(2);
		assertEquals("7", tree.search(9));
		assertEquals("1", tree.search(-1));
		tree.insert(4);
		assertEquals("4 7", tree.search(6));
		tree.insert(5);
		assertEquals("4", tree.search(4));
		assertEquals("4", tree.search(3));
	}

	@Test
	public void test6() {
		tree.insert(1);
		tree.insert(7);
		for (int i = 0; i < 10; i++) {
			tree.insert(4);
		}
		assertEquals("4", tree.search(4));
		tree.insert(2);
		tree.insert(8);
		tree.insert(2);
		assertEquals("1 2", tree.search(2));
		assertEquals("7 8", tree.search(9));
		tree.insert(9);
		tree.insert(3);
		tree.insert(4);
		tree.insert(10);
		tree.insert(2);
		tree.insert(5);
		tree.insert(6);
		assertEquals("6 8", tree.search(8));
		assertEquals("9 10", tree.search(9));
		assertEquals("9 10", tree.search(15));
		assertEquals("4", tree.search(4));
		tree.insert(-4);
		assertEquals("-4 1", tree.search(-4));
	}

	@Test
	public void test7() {
		for (int i = 1; i < 12; i++) {
			tree.insert(i);
		}
		assertEquals("4 8", tree.search(4));
		assertEquals("4 8", tree.search(8));
		for (int j = 1; j < 12; j++) {
			if (j != 4 && j != 8) {
				assertEquals(Integer.toString(j), tree.search(j));
			}
		}
		for (int k = 0; k > -4; k--) {
			tree.insert(k);
		}
		for (int l = -3; l < 12; l++) {
			assertEquals(Integer.toString(l), tree.search(l));
		}
	}

	@Test
	public void test8() {
		for (int i = 0; i < 100000; i++) {
			tree.insert(i);
		}
		for (int i = 0; i < 100000; i++) {
			tree.search(i);
		}

	}
}