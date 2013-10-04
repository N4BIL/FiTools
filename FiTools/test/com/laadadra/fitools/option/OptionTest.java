package com.laadadra.fitools.option;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class OptionTest
{

  public OptionTest()
  {
  }

  @BeforeClass
  public static void setUpClass()
  {
  }

  @AfterClass
  public static void tearDownClass()
  {
  }

  @Before
  public void setUp()
  {
  }

  @After
  public void tearDown()
  {
  }

  /**
   * Test of callPrice method, of class Option.
   */
  @Test
  public void callAtMoney()
  {
    Option o = new Call(375, 375, 60. / 365., 0.005, 0.03, 0.2);
    assertEquals(11.34, o.price(), 0.1);
  }

  /**
   * Test of putPrice method, of class Option.
   */
  @Test
  public void putAtMoney()
  {
    Option o = new Put(375, 375, 60. / 365., 0.005, 0.03, 0.2);
    assertEquals(12.877, o.price(), 0.1);
  }

  @Test
  public void callOutMoney()
  {
    Option o = new Call(375, 200, 60. / 365., 0.005, 0.03, 0.2);
    assertEquals(173.3, o.price(), 0.1);
  }

  @Test
  public void putOutMoney()
  {
    Option o = new Put(200, 375, 60. / 365., 0.005, 0.03, 0.2);
    assertEquals(175.676, o.price(), 0.1);
  }

  @Test
  public void putDelta()
  {
    Option o = new Put(375, 375, 60. / 365., 0.005, 0.03, 0.2);
    assertEquals(-0.504, o.delta(), 0.1);
  }

  @Test
  public void callDelta()
  {
    Option o = new Call(375, 375, 60. / 365., 0.005, 0.03, 0.2);
    assertEquals(0.496, o.delta(), 0.1);
  }

  /**
   * Test fancy cases.
   */
  @Test
  public void testFancy()
  {
    Option o = new Call(375, 375, 25. / 365., 3., 0.03, 25. / 100.);
    assertEquals(0., o.price(), 0.001);

    Option o1 = new Call(375, 375, 25. / 365., 0.03, 0.03, 25.);
    assertEquals(0., o1.price(), 0.001);

    Option o2 = new Call(375, 375, 25. / 365., 0.03, 5., 25. / 100.);
    assertEquals(0., o2.price(), 0.001);

    Option o3 = new Call(375, 0., 25. / 365., 3., 0.03, 25. / 100.);
    assertEquals(0., o3.price(), 0.001);

    Option o4 = new Call(0., 375, 25. / 365., 3., 0.03, 25. / 100.);
    assertEquals(0., o4.price(), 0.001);
  }
}