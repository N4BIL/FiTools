package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class RSITest extends SimpleIndicateurTest
{
  

  /**
   * Test of calc method, of class RSI.
   */
  @Test
  public void testRSI()
  {
    RSI instance = new RSI();
    assertEquals(49.297997, instance.calc(timeSerie)[0], 0.000001);
  }

  
}
