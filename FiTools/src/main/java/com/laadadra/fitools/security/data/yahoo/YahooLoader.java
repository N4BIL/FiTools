package com.laadadra.fitools.security.data.yahoo;

import com.laadadra.fitools.security.data.yahoo.YahooQuoteHistory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nabil.laadadra
 */
public class YahooLoader
{

  /**
   * Load a CSV file with the Yahoo's format
   *
   * @param is CSV file to load
   * @return List of security quote history ordered by date DESC
   */
  public List<YahooQuoteHistory> loadFromCSV(InputStream is)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    List<YahooQuoteHistory> res = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
    {
      br.readLine();
      String line;
      while ((line = br.readLine()) != null)
      {
        String tab[] = line.split(",");
        YahooQuoteHistory sqd = new YahooQuoteHistory();
        sqd.setQuoteDate(sdf.parse(tab[0]));
        sqd.setOpen(Double.parseDouble(tab[1]));
        sqd.setHigh(Double.parseDouble(tab[2]));
        sqd.setLow(Double.parseDouble(tab[3]));
        sqd.setClose(Double.parseDouble(tab[4]));
        sqd.setVolume(Double.parseDouble(tab[5]));
        sqd.setAdjClose(Double.parseDouble(tab[6]));
        res.add(sqd);
      }
    } catch (FileNotFoundException ex)
    {
      Logger.getLogger(YahooLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ParseException ex)
    {
      Logger.getLogger(YahooLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return res;
  }

  /**
   * Load a Yahoo historical price from a file
   * @param filepath
   * @return
   */
  public List<YahooQuoteHistory> loadFromCSV(String filepath)
  {
    try (InputStream fis = new FileInputStream(filepath))
    {
      return loadFromCSV(fis);
    } catch (IOException ex)
    {
      Logger.getLogger(YahooLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  /**
   * Load hstorical price from Yahoo website
   * @param symbol Symbol of the security ex: GOOG from Google
   * @param proxy Set the proxy for the connexion, it can be null
   * @param startDate Start date of the serie
   * @param endDate End date of the serie
   * @return
   */
  public List<YahooQuoteHistory> loadFromYahoo(String symbol, Proxy proxy, Date startDate, Date endDate)
  {
    if (symbol == null || startDate == null || endDate == null)
      return null;
    Calendar calStart = Calendar.getInstance();
    calStart.setTime(startDate);
    Calendar calEnd = Calendar.getInstance();
    calEnd.setTime(endDate);
    String urlAddress = String.format("http://ichart.yahoo.com/table.csv?s=%s&a=%d&b=%d&c=%d&d=%d&e=%d&f=%d&g=d&ignore=.csv",
                                      symbol,
                                      calStart.get(Calendar.MONTH),
                                      calStart.get(Calendar.DAY_OF_MONTH),
                                      calStart.get(Calendar.YEAR),
                                      calEnd.get(Calendar.MONTH),
                                      calEnd.get(Calendar.DAY_OF_MONTH),
                                      calEnd.get(Calendar.YEAR));
    try
    {
      URL url = new URL(urlAddress);
      URLConnection urlConnection = proxy == null ? url.openConnection() : url.openConnection(proxy);
      List<YahooQuoteHistory> res;
      try (InputStream is = urlConnection.getInputStream())
      {
        res = loadFromCSV(is);
      }
      return res;
    } catch (MalformedURLException ex)
    {
      Logger.getLogger(YahooLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex)
    {
      Logger.getLogger(YahooLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
