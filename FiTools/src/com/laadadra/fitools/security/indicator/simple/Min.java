package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.List;

public class Min extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    Double res = Double.MAX_VALUE;
    
    for (Double d : serie.values())
      if (res > d)
        res = d;
    
    Double tab[] = new Double[1];
    tab[0] = res;
    return tab;
  }
  
  
  
}
