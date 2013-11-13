package com.laadadra.fitools.currency;

/**
 *
 * @author nabil.laadadra
 */
public class Currency
{
  private String isoCode;
  private Double annualRiskFreeRate;

  public String getIsoCode()
  {
    return isoCode;
  }

  public void setIsoCode(String isoCode)
  {
    this.isoCode = isoCode;
  }

  public Double getAnnualRiskFreeRate()
  {
    return annualRiskFreeRate;
  }

  public void setAnnualRiskFreeRate(Double annualRiskFreeRate)
  {
    this.annualRiskFreeRate = annualRiskFreeRate;
  }
  
}
