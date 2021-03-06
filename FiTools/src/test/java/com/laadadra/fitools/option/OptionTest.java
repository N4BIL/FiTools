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
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(11.34, o.price(), 0.1);
  }

  /**
   * Test of putPrice method, of class Option.
   */
  @Test
  public void putAtMoney()
  {
    Option o = new Put(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(12.877, o.price(), 0.1);
  }

  @Test
  public void callOutMoney()
  {
    Option o = new Call(375, 200, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(173.3, o.price(), 0.1);
  }

  @Test
  public void putOutMoney()
  {
    Option o = new Put(200, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(175.676, o.price(), 0.1);
  }

  @Test
  public void putDelta()
  {
    Option o = new Put(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(-0.504, o.delta(), 0.1);
  }

  @Test
  public void callDelta()
  {
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(0.496, o.delta(), 0.1);
  }

  @Test
  public void putRho()
  {
    Option o = new Put(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(-0.315, o.rho(), 0.01);
  }

  @Test
  public void callRho()
  {
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(0.30, o.rho(), 0.01);
  }

  @Test
  public void putVega()
  {
    Option o = new Put(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(0.607, o.vega(), 0.01);
  }

  @Test
  public void callVega()
  {
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(0.607, o.vega(), 0.01);
  }
  
  @Test
  public void putTheta()
  {
    Option o = new Put(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(-0.113, o.theta(), 0.01);
  }

  @Test
  public void callTheta()
  {
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(-0.087, o.theta(), 0.01);
  }
  
  @Test
  public void gamma()
  {
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.005, 0.03, 0.2);
    assertEquals(0.013, o.gamma(), 0.01);
  }

  /**
   * Test fancy cases.
   */
  @Test
  public void testFancy()
  {
    Option o = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 25), 3., 0.03, 25. / 100.);
    assertEquals(0., o.price(), 0.001);

    Option o1 = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 25), 0.03, 0.03, 25.);
    assertEquals(0., o1.price(), 0.001);

    Option o2 = new Call(375, 375, new TimeToLive(TimeToLive.DateType.DAY, 25), 0.03, 5., 25. / 100.);
    assertEquals(0., o2.price(), 0.001);

    Option o3 = new Call(375, 0., new TimeToLive(TimeToLive.DateType.DAY, 25), 3., 0.03, 25. / 100.);
    assertEquals(0., o3.price(), 0.001);

    Option o4 = new Call(0., 375, new TimeToLive(TimeToLive.DateType.DAY, 25), 3., 0.03, 25. / 100.);
    assertEquals(0., o4.price(), 0.001);
  }
}