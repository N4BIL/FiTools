package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;

public class Average extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    Double res = 0.;
    
    for (Double d : serie.values())
      res += d;
    
    Double tab[] = new Double[1];
    tab[0] = res / serie.size();
    return tab;
  }
  
  
  
}
