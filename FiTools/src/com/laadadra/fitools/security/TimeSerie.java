package com.laadadra.fitools.security;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author nabil.laadadra
 */
public class TimeSerie extends TreeMap<Date, Double>
{

  public TimeSerie()
  {
    super(new Comparator<Date>() {

    @Override
    public int compare(Date o1, Date o2)
    {
      return -o1.compareTo(o2);
    }
  });
  }

  public TimeSerie(TimeSerie timeSerie, Integer period)
  {
    super();
    List<Date> dateList = new ArrayList<>(timeSerie.keySet());
    List<Double> valueList = new ArrayList<>(timeSerie.values());
    for (int i = 0; i < period; i++)
      put(dateList.get(i), valueList.get(i));
  }
  
  

}

