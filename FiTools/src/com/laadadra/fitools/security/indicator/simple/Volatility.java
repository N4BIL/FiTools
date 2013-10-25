package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.SecurityQuoteHistory;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.Collections;
import java.util.List;

public class Volatility extends SimpleIndicator
{

  @Override
  public Double[] calc(List<SecurityQuoteHistory> serie)
  {
    Collections.sort(serie);
    AveragePerformance a = new AveragePerformance();
    
    Double avg = a.calc(serie)[0];
    Double accu = 0.;
    for (int i = 0; i < serie.size() - 1; i++)
      accu += Math.pow((serie.get(i).getClose() / serie.get(i + 1).getClose() - 1) - avg, 2);
    
    Double res[] = new Double[1];
    res[0] = Math.sqrt(accu / (serie.size() - 1));
    res[0] *= Math.sqrt(250.);
    return res;
  }
 
  
  
  
}
