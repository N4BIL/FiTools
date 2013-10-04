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

  public Option(double spot, double strike, double timeToMaturity, double riskFreeRate, double dividendRate)
  {
    this.spot = spot;
    this.strike = strike;
    this.timeToMaturity = timeToMaturity;
    this.riskFreeRate = riskFreeRate;
    this.dividendRate = dividendRate;
  }

  protected boolean checkIntegrity()
  {
    if (spot <= 0.)
      return false;
    if (strike <= 0.)
      return false;
    if (riskFreeRate < 0. || riskFreeRate >= 1.)
      return false;
    if (dividendRate < 0. || dividendRate >= 1.)
      return false;
    if (timeToMaturity <= 0.)
      return false;
    return true;
  }
  
  public abstract double calcPrice(double volatility);

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
