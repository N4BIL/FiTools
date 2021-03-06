package com.laadadra.fitools.security.indicator;

import com.laadadra.fitools.security.data.yahoo.YahooQuoteHistory;
import java.util.List;

/**
 *
 * @author nabil.laadadra
 */
public interface ComparableIndicator
{
  public Double calc(List<YahooQuoteHistory> referenceSerie, List<YahooQuoteHistory> compareSerie);
}
