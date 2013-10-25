/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import com.laadadra.fitools.security.YahooLoader;
import java.util.List;
import org.junit.Before;

/**
 *
 * @author nabil.laadadra
 */
public class SimpleIndicateurTest
{
  protected List<SecurityQuoteHistory> sqhList;
  
  @Before
  public void setUp() throws Exception
  {
    YahooLoader yl = new YahooLoader();
    sqhList = yl.loadFromCSV("data/AF");
  }
}
