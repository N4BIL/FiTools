package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class AverageTest extends SimpleIndicateurTest
{

  /**
   * Test of calc method, of class Average.
   */
  @Test
  public void testAverage()
  {
    Average instance = new Average();
    assertEquals(14.7449, instance.calc(timeSerie)[0], 0.0001);
  }
  
}
