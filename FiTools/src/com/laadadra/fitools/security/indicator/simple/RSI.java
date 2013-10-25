package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.Collections;
import java.util.List;

public class RSI extends SimpleIndicator
{

  @Override
  public Double[] calc(List<SecurityQuoteHistory> serie)
  {
    Collections.sort(serie);
    Double sumUP = 0.;
    Double sumDown = 0.;
    for (int i = 0; i < serie.size() - 1; i++)
    {
      if (serie.get(i).getClose() > serie.get(i + 1).getClose())
        sumUP += serie.get(i).getClose() - serie.get(i + 1).getClose();
      else
        sumDown += serie.get(i + 1).getClose() - serie.get(i).getClose();
    }
    
    Double tab[] = new Double[1];
    tab[0] = 100. - 100. / (1. + sumUP / sumDown);
    return tab;
  }

  @Override
  public Double[] calc(List<SecurityQuoteHistory> serie, Integer period)
  {
    return calc(serie.subList(0, period + 1));
  }
  
  
  
  
}
