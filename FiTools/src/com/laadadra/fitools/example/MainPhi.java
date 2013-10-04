package com.laadadra.fitools.example;

import com.laadadra.fitools.option.Gaussian;


/**
 *
 * @author nabil.laadadra
 */
public class MainPhi
{
  // write a CSV of the Gaussian
  public static void main(String args[])
  {
    System.out.println("x,y");
    for (double x = -8; x <= 8; x += 0.01)
    {
      System.out.println(x + "," + Gaussian.Phi(x));
    }
  }
}
