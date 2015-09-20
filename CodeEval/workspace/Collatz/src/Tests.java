import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() {
		assertEquals(16, Collatz.cycleLength(22));
		assertEquals(20, Collatz.maximumCycle(1, 10));
		assertEquals(125, Collatz.maximumCycle(100, 200));
		assertEquals(89, Collatz.maximumCycle(201, 210));
		assertEquals(174, Collatz.maximumCycle(900, 1000));
	}

	@Test
	public void test2() {
		assertEquals(525, Collatz.maximumCycle(1, 1000000)); // 525 from piazza:
																// https://piazza.com/class/hkmo56odqer4db?cid=398
		assertEquals(443, Collatz.maximumCycle(100000, 250000)); // 443 from
																	// piazza:
																	// https://piazza.com/class/hkmo56odqer4db?cid=398

	}

	@Test
	public void swap_test3() {
		assertEquals(20, Collatz.maximumCycle(10, 1));
		assertEquals(125, Collatz.maximumCycle(200, 100));
		assertEquals(89, Collatz.maximumCycle(210, 201));
		assertEquals(174, Collatz.maximumCycle(1000, 900));

	}

}
