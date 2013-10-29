package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AveragePerformance extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    Double res = 0.;
    List<Double> valueList = new ArrayList<>(serie.values());
   
    for (int i = 0; i < valueList.size() - 1; i++)
      res += valueList.get(i) / valueList.get(i + 1) - 1;
    Double tab[] = new Double[1];
    tab[0] = res / (serie.size() - 1);
    return tab;
  }
 
  
  
  
}
