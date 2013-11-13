package com.laadadra.fitools.security.indicator;

import com.laadadra.fitools.option.TimeToLive;
import com.laadadra.fitools.security.TimeSerie;

public abstract class SimpleIndicator
{
  public abstract Double[] calc(TimeSerie timeSerie);

  public Double[] calc(TimeSerie serie, Integer period)
  {
    if (serie.size() < period)
      return null;
    TimeSerie subTimeSerie = new TimeSerie(serie, period);
    
    return calc(subTimeSerie);
  }

}
