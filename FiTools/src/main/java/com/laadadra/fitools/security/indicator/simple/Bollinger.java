package com.laadadra.fitools.security.indicator.simple;

import com.laadadra.fitools.security.data.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.TimeSerie;
import com.laadadra.fitools.security.indicator.SimpleIndicator;
import java.util.List;

public class Bollinger extends SimpleIndicator
{

  @Override
  public Double[] calc(TimeSerie serie)
  {
    Average avg = new Average();
    
    Double mm = avg.calc(serie)[0];
    Double accu = 0.;
    
    for (Double d : serie.values())
      accu += Math.pow(d - mm, 2);
    accu /= serie.size();
    accu = Math.sqrt(accu);
    
    Double tab[] = new Double[3];
    tab[0] = mm - accu;
    tab[1] = mm;
    tab[2] = mm + accu;
    return tab;
  }
  
  
  
}
