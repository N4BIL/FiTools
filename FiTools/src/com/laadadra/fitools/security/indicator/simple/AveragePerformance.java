package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.Collections;
import java.util.List;

public class AveragePerformance extends SimpleIndicator
{

  @Override
  public Double[] calc(List<SecurityQuoteHistory> serie)
  {
    Collections.sort(serie);
    
    Double res = 0.;
    for (int i = 0; i < serie.size() - 1; i++)
      res += serie.get(i).getClose() / serie.get(i + 1).getClose() - 1;
    Double tab[] = new Double[1];
    tab[0] = res / (serie.size() - 1);
    return tab;
  }
 
  
  
  
}
