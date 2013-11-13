package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;

/**
 *
 * @author nabil.laadadra
 */
public class Performance extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie timeSerie)
  {
    Double res[] = new Double[1];
    res[0] = timeSerie.firstEntry().getValue() / timeSerie.lastEntry().getValue() - 1;
    return res;
  }
  
}
