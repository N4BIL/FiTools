package com.laadadra.fitools.security.indicator;

import com.laadadra.fitools.security.TimeSerie;
import java.util.Date;

public abstract class SimpleIndicator
{
  public abstract Double[] calc(TimeSerie timeSerie);
  
  public Double[] calc(TimeSerie timeSerie, Date lastDate)
  {
    //TODO: Test it
    TimeSerie newTS = new TimeSerie();
    newTS.putAll(timeSerie.tailMap(lastDate, true));
    return calc(newTS);
  }
  
  public Double[] calc(TimeSerie timeSerie, Date lastDate, Integer period)
  {
    //TODO: Test it
    TimeSerie newTS = new TimeSerie();
    newTS.putAll(timeSerie.tailMap(lastDate, true));
    return calc(newTS, period);
  }
  
  public Double[] calc(TimeSerie timeSerie, Date firstDate, Date lastDate)
  {
    //TODO: Test it
    TimeSerie newTS = new TimeSerie();
    newTS.putAll(timeSerie.subMap(lastDate, true, firstDate, true));
    return calc(newTS);
  }

  public Double[] calc(TimeSerie serie, Integer period)
  {
    if (serie.size() < period)
      return null;
    TimeSerie subTimeSerie = new TimeSerie(serie, period);
    
    return calc(subTimeSerie);
  }

}
