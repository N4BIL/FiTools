package com.laadadra.fitools.example;

import com.laadadra.fitools.option.Gaussian;
import com.laadadra.fitools.security.data.yahoo.YahooQuoteHistory;
import com.laadadra.fitools.security.data.yahoo.YahooLoader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * @author nabil.laadadra
 */
public class MainYahoo
{
  // Load historical price from Yahoo
  public static void main(String args[])
  {
    Date startDate;
    Date endDate;
    Calendar cal = Calendar.getInstance();
    cal.set(2004, Calendar.APRIL, 1);
    startDate = cal.getTime();
    cal.set(2012, Calendar.DECEMBER, 19);
    endDate = cal.getTime();
    
    YahooLoader yl = new YahooLoader();
    List<YahooQuoteHistory> quoteList = yl.loadFromYahoo("AF.PA", null, startDate, endDate);
    
    for (YahooQuoteHistory sqh : quoteList)
      System.err.println(sqh);
  }
}
