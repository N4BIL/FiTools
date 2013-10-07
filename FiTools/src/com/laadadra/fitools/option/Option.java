package com.laadadra.fitools.option;

import com.laadadra.fitools.rate.RateTool;

/**
 *
 * @author nabil.laadadra
 */
public abstract class Option
{
  protected double spot;
  protected double strike;
  protected TimeToLive timeToMaturity;
  protected double riskFreeRate;
  protected double dividendRate;
  protected double volatility;
  
  protected double d1 = -100.;
  protected double d2 = -100.;

  public Option(double spot,
                double strike,
                TimeToLive timeToMaturity,
                double riskFreeRate,
                double dividendRate,
                double volatility)
  {
    this.spot = spot;
    this.strike = strike;
    this.timeToMaturity = timeToMaturity;
    this.riskFreeRate = riskFreeRate;
    this.dividendRate = dividendRate;
    this.volatility = volatility;
    
    if (checkIntegrity())
    {
      d1 = (Math.log(spot / strike) + (riskFreeRate + volatility * volatility / 2) * timeToMaturity.getDiffDateInYear()) / (volatility * Math.sqrt(timeToMaturity.getDiffDateInYear()));
      d2 = d1 - volatility * Math.sqrt(timeToMaturity.getDiffDateInYear());
    }
  }

  public abstract double price();
  public abstract double delta();
  
  public abstract double rho();
  public abstract double theta();
  
  public double vega()
  {
    return RateTool.discount(strike, dividendRate, timeToMaturity.getDiffDateInYear()) * Gaussian.phi(d1) * Math.sqrt(timeToMaturity.getDiffDateInYear()) / 100.;
  }
  
  public double gamma()
  {
    return Gaussian.phi(d1) * Math.exp(-dividendRate * timeToMaturity.getDiffDateInYear()) / (spot * volatility * Math.sqrt(timeToMaturity.getDiffDateInYear()));
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
    if (timeToMaturity == null || timeToMaturity.getDiffDateInYear() <= 0.)
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

  public TimeToLive getTimeToMaturity()
  {
    return timeToMaturity;
  }

  public void setTimeToMaturity(TimeToLive timeToMaturity)
  {
    this.timeToMaturity = timeToMaturity;
  }

  public double getVolatility()
  {
    return volatility;
  }

  public void setVolatility(double volatility)
  {
    this.volatility = volatility;
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
