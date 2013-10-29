package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class PerformanceTest extends SimpleIndicateurTest
{

  /**
   * Test of calc method, of class Average.
   */
  @Test
  public void testPerformance()
  {
    Performance instance = new Performance();
    assertEquals(-0.664296597, instance.calc(timeSerie)[0], 0.0001);
  }
  
  @Test
  public void testPerformancePeriod()
  {
    Performance instance = new Performance();
    assertEquals(0.085385878, instance.calc(timeSerie, 10)[0], 0.0001);
  }
  
}
