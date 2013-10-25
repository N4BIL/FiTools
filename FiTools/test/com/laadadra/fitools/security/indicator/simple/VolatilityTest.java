package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class VolatilityTest extends SimpleIndicateurTest
{
  /**
   * Test of calc method, of class Volatility.
   */
  @Test
  public void testVolatility()
  {
    Volatility instance = new Volatility();
    assertEquals(0.43029751, instance.calc(sqhList)[0], 0.0001);
  }
  
}
