package com.laadadra.fitools.example;

import com.laadadra.fitools.option.Call;
import com.laadadra.fitools.option.TimeToLive;

/**
 *
 * @author nabil.laadadra
 */
public class MainOption
{
  public static void main(String args[])
  {
    Call call = new Call(49, 50, new TimeToLive(TimeToLive.DateType.DAY, 60), 0.05, 0., 0.2);
    System.err.println(call.price());
  }
}
