package com.laadadra.fitools.example;

import com.laadadra.fitools.security.data.euronext.EuronextLoader;
import com.laadadra.fitools.security.data.euronext.EuronextQuote;
import java.util.List;


/**
 *
 * @author nabil.laadadra
 */
public class MainEuronext
{
  // Load historical price from Yahoo
  public static void main(String args[])
  {
    EuronextLoader el = new EuronextLoader();
    List<EuronextQuote> quotes = el.loadFromEuronext(null);
    
    for (EuronextQuote q : quotes)
      System.err.println(q);
  }
}
