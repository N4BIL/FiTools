package com.laadadra.fitools.security.indicator;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import java.util.List;

public abstract class SimpleIndicator
{
  public abstract Double[] calc(List<SecurityQuoteHistory> serie);
  public Double[] calc(List<SecurityQuoteHistory> serie, Integer period)
  {
    if (serie.size() < period)
      return null;
    return calc(serie.subList(0, period));
  }
}
