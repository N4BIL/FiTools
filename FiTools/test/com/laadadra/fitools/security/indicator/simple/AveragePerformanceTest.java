package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class AveragePerformanceTest extends SimpleIndicateurTest
{


  /**
   * Test of calc method, of class AveragePerformance.
   */
  @Test
  public void testAveragePerformance()
  {
    AveragePerformance instance = new AveragePerformance();
    assertEquals(0.0000622408, instance.calc(timeSerie)[0], 0.0000000001);
  }
  
}
