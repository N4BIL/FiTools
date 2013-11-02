package com.laadadra.fitools.security.data.euronext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nabil.laadadra
 */
public class EuronextQuote implements Comparable<EuronextQuote>
{
  private String name;
  private String isin;
  private String symbol;
  private String market;
  private String currency;
  private Double open;
  private Double close;
  private Double low;
  private Double high;
  private Double volumeInQuantity;
  private Double volumeInCurrency;
  private Date lastTradeDate;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getIsin()
  {
    return isin;
  }

  public void setIsin(String isin)
  {
    this.isin = isin;
  }

  public String getSymbol()
  {
    return symbol;
  }

  public void setSymbol(String symbol)
  {
    this.symbol = symbol;
  }

  public String getMarket()
  {
    return market;
  }

  public void setMarket(String market)
  {
    this.market = market;
  }

  public String getCurrency()
  {
    return currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = currency;
  }

  public Double getOpen()
  {
    return open;
  }

  public void setOpen(Double open)
  {
    this.open = open;
  }

  public Double getClose()
  {
    return close;
  }

  public void setClose(Double close)
  {
    this.close = close;
  }

  public Double getLow()
  {
    return low;
  }

  public void setLow(Double low)
  {
    this.low = low;
  }

  public Double getHigh()
  {
    return high;
  }

  public void setHigh(Double high)
  {
    this.high = high;
  }

  public Double getVolumeInQuantity()
  {
    return volumeInQuantity;
  }

  public void setVolumeInQuantity(Double volumeInQuantity)
  {
    this.volumeInQuantity = volumeInQuantity;
  }

  public Double getVolumeInCurrency()
  {
    return volumeInCurrency;
  }

  public void setVolumeInCurrency(Double volumeInCurrency)
  {
    this.volumeInCurrency = volumeInCurrency;
  }

  public Date getLastTradeDate()
  {
    return lastTradeDate;
  }

  public void setLastTradeDate(Date lastTradeDate)
  {
    this.lastTradeDate = lastTradeDate;
  }

 
  
  @Override
  public String toString()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return String.format("[%s][%f] o:%f h:%f l:%f v:%f", sdf.format(lastTradeDate), close, open, high, low, volumeInQuantity);
  }

  @Override
  public int compareTo(EuronextQuote t)
  {
    return -lastTradeDate.compareTo(t.getLastTradeDate());
  }
  
  
  
}
