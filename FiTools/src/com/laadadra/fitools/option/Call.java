package com.laadadra.fitools.option;

/**
 *
 * @author nabil.laadadra
 */
public class Call extends Option
{

  public Call(double spot, double strike, double timeToMaturity, double riskFreeRate, double dividendRate, double volatility)
  {
    super(spot, strike, timeToMaturity, riskFreeRate, dividendRate, volatility);
  }

  @Override
  public double price()
  {
    return spot * Gaussian.Phi(d1) * Math.exp(-dividendRate * timeToMaturity) - strike * Math.exp(-riskFreeRate * timeToMaturity) * Gaussian.Phi(d2);
  }

  @Override
  public double delta()
  {
    return Gaussian.Phi(d1) * Math.exp(-dividendRate * timeToMaturity);
  }

  @Override
  public double rho()
  {
    return strike * timeToMaturity * Math.exp(-timeToMaturity * riskFreeRate) * Gaussian.Phi(d2) / 100.;
  }

  
}
