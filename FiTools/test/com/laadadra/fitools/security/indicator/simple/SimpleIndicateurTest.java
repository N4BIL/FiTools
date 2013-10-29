/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.yahoo.YahooLoader;
import java.util.List;
import org.junit.Before;

/**
 *
 * @author nabil.laadadra
 */
public class SimpleIndicateurTest
{
  protected TimeSerie timeSerie = new TimeSerie();
  
  @Before
  public void setUp() throws Exception
  {
    YahooLoader yl = new YahooLoader();
    List<YahooQuoteHistory> sqhList = yl.loadFromCSV("data/AF");
    for (YahooQuoteHistory sqh : sqhList)
      timeSerie.put(sqh.getQuoteDate(), sqh.getClose());
  }
}
