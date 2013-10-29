package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.ArrayList;
import java.util.List;

public class RSI extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    Double sumUP = 0.;
    Double sumDown = 0.;
    List<Double> valueList = new ArrayList<>(serie.values());
    for (int i = 0; i < valueList.size() - 1; i++)
    {
      if (valueList.get(i) > valueList.get(i + 1))
        sumUP += valueList.get(i) - valueList.get(i + 1);
      else
        sumDown += valueList.get(i + 1) - valueList.get(i);
    }
    
    Double tab[] = new Double[1];
    tab[0] = 100. - 100. / (1. + sumUP / sumDown);
    return tab;
  }

  @Override
  public Double[] calc(TimeSerie serie, Integer period)
  {
    return super.calc(serie, period + 1);
  }
  
  
  
  
}
