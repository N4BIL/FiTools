package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.List;

public class Min extends SimpleIndicator
{

  @Override
  public Double[] calc(List<SecurityQuoteHistory> serie)
  {
    Double res = Double.MAX_VALUE;
    
    for (SecurityQuoteHistory s : serie)
      if (res > s.getClose())
        res = s.getClose();
    
    Double tab[] = new Double[1];
    tab[0] = res;
    return tab;
  }
  
  
  
}
