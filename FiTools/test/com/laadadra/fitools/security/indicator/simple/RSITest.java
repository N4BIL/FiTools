/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import java.util.List;
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
    assertEquals(49.297997, instance.calc(sqhList)[0], 0.000001);
  }

  
}
