package com.laadadra.fitools.option;

import com.laadadra.fitools.rate.RateTool;

/**
 *
 * @author nabil.laadadra
 */
public class Call extends Option
{

  public Call(double spot, double strike, TimeToLive timeToMaturity, double riskFreeRate, double dividendRate, double volatility)
  {
    super(spot, strike, timeToMaturity, riskFreeRate, dividendRate, volatility);
  }

  @Override
  public double price()
  {
    return Gaussian.Phi(d1) * RateTool.discount(spot, dividendRate, timeToMaturity.getDiffDateInYear()) - RateTool.discount(strike, riskFreeRate, timeToMaturity.getDiffDateInYear()) * Gaussian.Phi(d2);
  }

  @Override
  public double delta()
  {
    return Gaussian.Phi(d1) * Math.exp(-dividendRate * timeToMaturity.getDiffDateInYear());
  }

  @Override
  public double rho()
  {
    return timeToMaturity.getDiffDateInYear() * RateTool.discount(strike, riskFreeRate, timeToMaturity.getDiffDateInYear()) * Gaussian.Phi(d2) / 100.;
  }

  @Override
  public double theta()
  {
    return (- RateTool.discount(spot, dividendRate, timeToMaturity.getDiffDateInYear()) * Gaussian.phi(d1) * volatility / (2 * Math.sqrt(timeToMaturity.getDiffDateInYear()))
            - riskFreeRate * RateTool.discount(strike, riskFreeRate, timeToMaturity.getDiffDateInYear()) * Gaussian.Phi(d2)
            + dividendRate * RateTool.discount(spot, dividendRate, timeToMaturity.getDiffDateInYear()) * Gaussian.Phi(d1)) / 365.;
  }

  
}
