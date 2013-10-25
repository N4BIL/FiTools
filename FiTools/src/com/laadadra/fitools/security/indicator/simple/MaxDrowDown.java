package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.Collections;
import java.util.List;

public class MaxDrowDown extends SimpleIndicator
{

  @Override
  public Double[] calc(List<SecurityQuoteHistory> serie)
  {
    Collections.sort(serie);
    Double res = 0.;
    for (int i = serie.size() - 1; i > 0; i--)
      for (int j = i - 1; j >= 0; j--)
      {
        Double drowDown = serie.get(j).getClose() / serie.get(i).getClose() - 1;
        if (drowDown < res)
          res = drowDown;
      }
    
    Double tab[] = new Double[1];
    tab[0] = res;
    return tab;
  }
  
  
  
}
