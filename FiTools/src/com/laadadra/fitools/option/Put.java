package com.laadadra.fitools.option;

/**
 *
 * @author nabil.laadadra
 */
public class Put extends Option
{

  public Put(double spot, double strike, double timeToMaturity, double riskFreeRate, double dividendRate, double volatility)
  {
    super(spot, strike, timeToMaturity, riskFreeRate, dividendRate, volatility);
  }

  @Override
  public double price()
  {
    return strike * Math.exp(-riskFreeRate * timeToMaturity) * Gaussian.Phi(-d2) - spot * Gaussian.Phi(-d1) * Math.exp(-dividendRate * timeToMaturity);
  }

  @Override
  public double delta()
  {
    return -Math.exp(-riskFreeRate * timeToMaturity) * Gaussian.Phi(-d1);
  }
  
  
}
