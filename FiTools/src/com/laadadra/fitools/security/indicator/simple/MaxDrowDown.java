package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDrowDown extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    List<Double> valueList = new ArrayList<>(serie.values());
    Double res = 0.;
    for (int i = valueList.size() - 1; i > 0; i--)
      for (int j = i - 1; j >= 0; j--)
      {
        Double drowDown = valueList.get(j)/ valueList.get(i) - 1;
        if (drowDown < res)
          res = drowDown;
      }
    
    Double tab[] = new Double[1];
    tab[0] = res;
    return tab;
  }
  
  
  
}
