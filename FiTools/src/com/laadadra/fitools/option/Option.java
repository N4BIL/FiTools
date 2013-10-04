package com.laadadra.fitools.option;

/**
 *
 * @author nabil.laadadra
 */
public abstract class Option
{
  protected double spot;
  protected double strike;
  protected double timeToMaturity;
  protected double riskFreeRate;
  protected double dividendRate;
  protected double volatility;
  
  protected double d1 = -100.;
  protected double d2 = -100.;

  public Option(double spot, double strike, double timeToMaturity, double riskFreeRate, double dividendRate, double volatility)
  {
    this.spot = spot;
    this.strike = strike;
    this.timeToMaturity = timeToMaturity;
    this.riskFreeRate = riskFreeRate;
    this.dividendRate = dividendRate;
    this.volatility = volatility;
    
    if (checkIntegrity())
    {
      d1 = (Math.log(spot / strike) + (riskFreeRate + volatility * volatility / 2) * timeToMaturity) / (volatility * Math.sqrt(timeToMaturity));
      d2 = d1 - volatility * Math.sqrt(timeToMaturity);
    }
  }

  public abstract double price();
  public abstract double delta();
  public abstract double rho();
  
  public double vega()
  {
    return strike * Math.exp(-dividendRate * timeToMaturity) * Gaussian.phi(d1) * Math.sqrt(timeToMaturity) / 100.;
  }
  
  private boolean checkIntegrity()
  {
    if (spot <= 0.)
      return false;
    if (strike <= 0.)
      return false;
    if (riskFreeRate < 0. || riskFreeRate >= 1.)
      return false;
    if (dividendRate < 0. || dividendRate >= 1.)
      return false;
    if (volatility < 0. || volatility >= 1.)
      return false;
    if (timeToMaturity <= 0.)
      return false;
    return true;
  }
  
  public double getSpot()
  {
    return spot;
  }

  public void setSpot(double spot)
  {
    this.spot = spot;
  }

  public double getStrike()
  {
    return strike;
  }

  public void setStrike(double strike)
  {
    this.strike = strike;
  }

  public double getTimeToMaturity()
  {
    return timeToMaturity;
  }

  public void setTimeToMaturity(double timeToMaturity)
  {
    this.timeToMaturity = timeToMaturity;
  }

  public double getRiskFreeRate()
  {
    return riskFreeRate;
  }

  public void setRiskFreeRate(double riskFreeRate)
  {
    this.riskFreeRate = riskFreeRate;
  }

  public double getDividendRate()
  {
    return dividendRate;
  }

  public void setDividendRate(double dividendRate)
  {
    this.dividendRate = dividendRate;
  }
  
  
}
