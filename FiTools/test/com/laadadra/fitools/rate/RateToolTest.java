package com.laadadra.fitools.rate;

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
public class RateToolTest
{
  
  public RateToolTest()
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
   * Test of discount method, of class RateTool.
   */
  @Test
  public void testDiscount()
  {
    assertEquals(100., RateTool.discount(110.52, 0.1, 1.), 0.01);
  }
}