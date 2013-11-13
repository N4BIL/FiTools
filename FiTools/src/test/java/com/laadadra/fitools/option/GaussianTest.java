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
public class GaussianTest
{
  
  public GaussianTest()
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
   * Test of phi method, of class Gaussian.
   */
  @Test
  public void testLittlePhi()
  {
    assertEquals(1. / Math.sqrt(Math.PI * 2), Gaussian.phi(0.), 0.001);
    assertEquals(0., Gaussian.phi(-500), 0.001);
    assertEquals(0., Gaussian.phi(500.), 0.001);
  }

  /**
   * Test of Phi method, of class Gaussian.
   */
  @Test
  public void testBigPhi()
  {
    assertEquals(1., Gaussian.Phi(500.), 0.001);
    assertEquals(0., Gaussian.Phi(-500.), 0.001);
    assertEquals(0.02275, Gaussian.Phi(-2), 0.001);
    assertEquals(0.15865, Gaussian.Phi(-1), 0.001);
    assertEquals(0.30853, Gaussian.Phi(-0.5), 0.001);
    assertEquals(0.5, Gaussian.Phi(0.), 0.001);
    assertEquals(0.69146, Gaussian.Phi(0.5), 0.001);
    assertEquals(0.84134, Gaussian.Phi(1.), 0.001);
    assertEquals(0.97724, Gaussian.Phi(2.), 0.001);
  }
}