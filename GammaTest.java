import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class GammaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFactorial() {
		Gamma tester = new Gamma();
	    assertEquals(2, tester.factorial(2),0);
	}
	
	@Test
	public void testSqrt() {
		Gamma tester = new Gamma();
	    assertEquals(Math.sqrt(4), tester.sqrt(4),0);
	}
	
	@Test
	public void testX() {
		Gamma tester = new Gamma();
		assertTrue(tester.x>=0);
	}

	@Test
	public void testExp() {
		Gamma tester = new Gamma();
		double math = Math.exp(2);
		String actual = Double.toString(math);
		actual = actual.substring(0, 10);
		double func = tester.exp(2);
		String expected = Double.toString(func);
		expected = expected.substring(0, 10);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testSin() {
		Gamma tester = new Gamma();
	    assertEquals(Math.sin(1.1), tester.sin(1.1),0);
	}
	
	@Test
	public void testPower() {
		Gamma tester = new Gamma();
	    assertEquals(Math.pow(11, 2), tester.Pow(11,2),0);
	}
	
	@Test
	public void testLog() {
		Gamma tester = new Gamma();
		double math = Math.log(2);
		String actual = Double.toString(math);
		actual = actual.substring(0, 10);
		double func = tester.lnCustom(2);
		String expected = Double.toString(func);
		expected = expected.substring(0, 10);
		assertEquals(actual,expected);
	}
	

	@Test
	public void testFracPower() {
		Gamma tester = new Gamma();
		double math = Math.pow(2,1.1);
		String actual = Double.toString(math);
		actual = actual.substring(0, 10);
		double func = tester.fracPow(2, 1.1);
		String expected = Double.toString(func);
		expected = expected.substring(0, 10);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testLanczosGamma() {
		Gamma tester = new Gamma();
		assertEquals(9.513507698779327,tester.la_gamma(0.1),0);
	}
	
}
