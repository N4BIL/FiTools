package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class MinTest extends SimpleIndicateurTest
{
  

  /**
   * Test of calc method, of class Min.
   */
  @Test
  public void testMin()
  {
    Min instance = new Min();
    assertEquals(3.06, instance.calc(sqhList)[0], 0.001);
  }
  
}
