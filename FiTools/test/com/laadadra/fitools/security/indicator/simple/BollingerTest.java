package com.laadadra.fitools.security.indicator.simple;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class BollingerTest extends SimpleIndicateurTest
{

  /**
   * Test of calc method, of class Bollinger.
   */
  @Test
  public void testBollinger()
  {
    Bollinger instance = new Bollinger();
    Double res[] = instance.calc(sqhList);
    
    Double moy = 14.74492;
    Double delta = 7.092526;
    
    assertEquals(moy - delta, res[0], 0.00001);
    assertEquals(moy, res[1], 0.00001);
    assertEquals(moy + delta, res[2], 0.00001);
  }
  
}
