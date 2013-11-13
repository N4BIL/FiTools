package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class MaxTest extends SimpleIndicateurTest
{
  
  /**
   * Test of calc method, of class Max.
   */
  @Test
  public void testMax()
  {
    Max instance = new Max();
    assertEquals(38.3, instance.calc(timeSerie)[0], 0.001);
  }
  
}
