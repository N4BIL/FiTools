package com.laadadra.fitools.rate;

/**
 *
 * @author nabil.laadadra
 */
public class RateTool
{
  public static double discount(double value, double rate, double time)
  {
    return value * Math.exp(-rate * time);
  }
}
