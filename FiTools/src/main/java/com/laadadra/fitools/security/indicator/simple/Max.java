package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.data.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public class Max extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie timeSerie)
  {
    Double res = 0.;
    for (Double d : timeSerie.values())
      if (res < d)
        res = d;
    
    Double tab[] = new Double[1];
    tab[0] = res;
    return tab;
  }
  
  
  
}
