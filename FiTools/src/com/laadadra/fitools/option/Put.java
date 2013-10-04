package com.laadadra.fitools.option;

/**
 *
 * @author nabil.laadadra
 */
public class Put extends Option
{

  public Put(double spot, double strike, double timeToMaturity, double riskFreeRate, double dividendRate)
  {
    super(spot, strike, timeToMaturity, riskFreeRate, dividendRate);
  }

  @Override
  public double calcPrice(double volatility)
  {
    if (!checkIntegrity() || volatility <= 0. || volatility >= 1.)
      return 0;
    double d1 = (Math.log(spot / strike) + (riskFreeRate + volatility * volatility / 2) * timeToMaturity) / (volatility * Math.sqrt(timeToMaturity));
    double d2 = d1 - volatility * Math.sqrt(timeToMaturity);
    
    return strike * Math.exp(-riskFreeRate * timeToMaturity) * Gaussian.Phi(-d2) - spot * Gaussian.Phi(-d1) * Math.exp(-dividendRate * timeToMaturity);
  }
  
  
}
