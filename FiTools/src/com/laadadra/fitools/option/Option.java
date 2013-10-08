package com.laadadra.fitools.option;

import com.laadadra.fitools.rate.RateTool;

/**
 * Abstract class for an European Option
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

  /**
   * All fields of an option need to be declared at the instanciation.
   * @param spot Price of the underlying
   * @param strike Strike price of the option
   * @param timeToMaturity Time between now and the expiry date
   * @param riskFreeRate Risk free rate (ex: 0.03 for 3%)
   * @param dividendRate Annual dividend rate of the underlying (ex: 0.05 for 5%)
   * @param volatility Implied volatility (ex: 0.2 for 20%)
   */
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

  /**
   * Compute the theoretical price of the option
   * @return price of the option
   */
  public abstract double price();
  /**
   * Compute the delta of the option. If the underlying if up by N then the option change by N * delta.
   * @return
   */
  public abstract double delta();
  
  /**
   * Compute rho. Rho is the variation of the option price when the risk free rate changes.
   * @return
   */
  public abstract double rho();
  
  /**
   * Compute Theta. Theta is the variation of the option price when the time pass.
   * @return Theta per day.
   */
  public abstract double theta();
  
  /**
   * Compute Vega. Vega is the variation of the option price when the volatility changes.
   * @return
   */
  public double vega()
  {
    return RateTool.discount(strike, dividendRate, timeToMaturity.getDiffDateInYear()) * Gaussian.phi(d1) * Math.sqrt(timeToMaturity.getDiffDateInYear()) / 100.;
  }
  
  /**
   * Compute Gamma. Gamma is the rate of change of Delta.
   * @return
   */
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
