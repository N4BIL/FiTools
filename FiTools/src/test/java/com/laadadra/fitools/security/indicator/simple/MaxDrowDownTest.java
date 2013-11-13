package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class MaxDrowDownTest extends SimpleIndicateurTest
{
  /**
   * Test of calc method, of class MaxDrowDown.
   */
  @Test
  public void testMaxDrowDown()
  {
    MaxDrowDown instance = new MaxDrowDown();
    assertEquals(3.06 / 38.3 - 1, instance.calc(timeSerie)[0], 0.00001);
  }
  
}
