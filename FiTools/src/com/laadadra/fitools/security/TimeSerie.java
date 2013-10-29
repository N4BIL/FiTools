package com.laadadra.fitools.security;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author nabil.laadadra
 */
public class TimeSerie extends TreeMap<Date, Double>
{
  private static Comparator<Date> reverseDateComparator = new Comparator<Date>() {

    @Override
    public int compare(Date o1, Date o2)
    {
      return -o1.compareTo(o2);
    }
  };
  
  public TimeSerie()
  {
    super(reverseDateComparator);
  }

  public TimeSerie(TimeSerie timeSerie, Integer period)
  {
    super(reverseDateComparator);
    for (Map.Entry<Date, Double> entry : timeSerie.entrySet())
    {
      if (period == 0)
        break;
      put(entry.getKey(), entry.getValue());
      period--;
    }
  }
  
  

}

