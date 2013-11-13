package com.laadadra.fitools.security.data.nasdaq;

/**
 *
 * @author nabil.laadadra
 */
public class NasdaqQuote
{
  private String symbol;
  private String name;
  private Double lastPrice;
  private Double marketCap;
  private String adrTSO;
  private String url;

  public String getSymbol()
  {
    return symbol;
  }

  public void setSymbol(String symbol)
  {
    this.symbol = symbol;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Double getLastPrice()
  {
    return lastPrice;
  }

  public void setLastPrice(Double lastPrice)
  {
    this.lastPrice = lastPrice;
  }

  public Double getMarketCap()
  {
    return marketCap;
  }

  public void setMarketCap(Double marketCap)
  {
    this.marketCap = marketCap;
  }

  public String getAdrTSO()
  {
    return adrTSO;
  }

  public void setAdrTSO(String adrTSO)
  {
    this.adrTSO = adrTSO;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }
  
  
}
