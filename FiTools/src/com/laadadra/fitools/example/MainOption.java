package com.laadadra.fitools.example;

import com.laadadra.fitools.option.Call;
import com.laadadra.fitools.option.Put;
import com.laadadra.fitools.option.TimeToLive;
import java.util.Calendar;

/**
 *
 * @author nabil.laadadra
 */
public class MainOption
{
  public static void main(String args[])
  {
    Calendar cal = Calendar.getInstance();
    cal.set(2013, Calendar.DECEMBER, 20);
    Put put = new Put(388, 370, new TimeToLive(cal.getTime()), 0.005, 0.03, 0.145);
    System.err.println(put.price());
    System.err.println(put.delta());
    System.err.println(put.gamma());
    System.err.println(put.vega());
    System.err.println(put.theta());
  }
}
