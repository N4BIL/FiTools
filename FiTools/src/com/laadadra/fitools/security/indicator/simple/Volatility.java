package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Volatility extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    AveragePerformance a = new AveragePerformance();
    
    Double avg = a.calc(serie)[0];
    Double accu = 0.;
    List<Double> valueList = new ArrayList<>(serie.values());
    for (int i = 0; i < valueList.size() - 1; i++)
      accu += Math.pow((valueList.get(i) / valueList.get(i + 1) - 1) - avg, 2);
    
    Double res[] = new Double[1];
    res[0] = Math.sqrt(accu / (serie.size() - 1));
    res[0] *= Math.sqrt(250.);
    return res;
  }
 
  
  
  
}
