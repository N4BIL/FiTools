package com.laadadra.fitools.option;

import com.laadadra.fitools.rate.RateTool;

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
    return RateTool.discount(strike, riskFreeRate, timeToMaturity) * Gaussian.Phi(-d2) - RateTool.discount(spot, dividendRate, timeToMaturity) * Gaussian.Phi(-d1);
  }

  @Override
  public double delta()
  {
    return -Math.exp(-riskFreeRate * timeToMaturity) * Gaussian.Phi(-d1);
  }

  @Override
  public double rho()
  {
    return -RateTool.discount(strike, riskFreeRate, timeToMaturity) * timeToMaturity * Gaussian.Phi(-d2) / 100.;
  }

  @Override
  public double theta()
  {
    return (-RateTool.discount(spot, dividendRate, timeToMaturity) * Gaussian.phi(d1) * volatility / (2 * Math.sqrt(timeToMaturity))
            + RateTool.discount(strike, riskFreeRate, timeToMaturity) * riskFreeRate * Gaussian.Phi(-d2)
            - dividendRate * RateTool.discount(spot, dividendRate, timeToMaturity) * Gaussian.Phi(-d1)) / 365.;
  }
  
  
}
