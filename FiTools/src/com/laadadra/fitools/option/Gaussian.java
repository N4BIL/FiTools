package com.laadadra.fitools.option;

/**
 *
 * @author nabil.laadadra
 */
public class Gaussian
{
    public static double phi(double x)
    {
      return Math.exp(-Math.pow(x, 2) / 2) / Math.sqrt(2 * Math.PI);
    }
    
    public static double Phi(double x)
    {
      if (x > 8)
        return 1.;
      if (x < -8)
        return 0.;
      
      double accu = 0.;
      for (double z = -8, delta = 0.001; z < x; z += delta)
      {
        accu += phi(z) * delta;
      }
      return accu;
    }

}
