package com.laadadra.fitools.security.indicator;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import java.util.List;

/**
 *
 * @author nabil.laadadra
 */
public interface ComparableIndicator
{
  public Double calc(List<SecurityQuoteHistory> referenceSerie, List<SecurityQuoteHistory> compareSerie);
}
