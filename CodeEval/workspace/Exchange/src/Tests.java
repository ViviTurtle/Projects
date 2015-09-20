import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() {
		Exchange e = new Exchange(3);
		e.setRate(0, 1, 1.5);
		e.setRate(0, 2, 2);
		e.setRate(1, 2, 1.5);
		e.setRate(2, 0, .3);
		assertFalse(e.arbitrageExists()); // returns false
		assertEquals(0.45, e.bestExchangeRate(1, 0), .000001);
		assertEquals(1, e.bestExchangeRate(1, 1), .000001);
		assertEquals(2.25, e.bestExchangeRate(0, 2), .000001);

	}

	@Test
	public void test2() {
		Exchange e2 = new Exchange(3);
		e2.setRate(0, 1, .5);
		e2.setRate(0, 2, 2);
		e2.setRate(1, 0, 1.9);
		e2.setRate(1, 2, 4);
		e2.setRate(2, 0, .51);
		e2.setRate(2, 1, .22);
		assertTrue(e2.arbitrageExists()); // returns true
	}

}
