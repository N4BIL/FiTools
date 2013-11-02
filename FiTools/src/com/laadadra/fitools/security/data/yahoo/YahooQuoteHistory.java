package com.laadadra.fitools.yahoo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nabil.laadadra
 */
public class YahooQuoteHistory implements Comparable<YahooQuoteHistory>
{
  private Date quoteDate;
  private Double open;
  private Double close;
  private Double adjClose;
  private Double low;
  private Double high;
  private Double volume;

  public Date getQuoteDate()
  {
    return quoteDate;
  }

  public void setQuoteDate(Date quoteDate)
  {
    this.quoteDate = quoteDate;
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

  public Double getVolume()
  {
    return volume;
  }

  public void setVolume(Double volume)
  {
    this.volume = volume;
  }

  public Double getAdjClose()
  {
    return adjClose;
  }

  public void setAdjClose(Double adjClose)
  {
    this.adjClose = adjClose;
  }

  @Override
  public int compareTo(YahooQuoteHistory o)
  {
    return -quoteDate.compareTo(o.getQuoteDate());
  }

  @Override
  public String toString()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return String.format("[%s][%f|%f] o:%f h:%f l:%f v:%f", sdf.format(quoteDate), close, adjClose, open, high, low, volume);
  }
  
  
  
}
