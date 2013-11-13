package com.laadadra.fitools.security.data.nasdaq;

import com.laadadra.fitools.security.data.euronext.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nabil.laadadra
 */
public class NasdaqLoader
{
  public enum NasdaqExchange {AMEX, NASDAQ, NYSE, ALL};
  
  /**
   * Load a CSV file with the Nasdaq format
   *
   * @param is CSV file to load
   * @return List of security quote ordered by date DESC
   */
  public List<NasdaqQuote> loadFromCSV(InputStream is)
  {
    List<NasdaqQuote> res = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
    {
      br.readLine();
      String line;
      while ((line = br.readLine()) != null)
      {
        line = line.replace("&#39;", "");
        line = line.replace("\",\"", ";");
        line = line.replace("\",", "");
        line = line.replace("\"", "");
        String tab[] = line.split(";");
        NasdaqQuote nq = new NasdaqQuote();
        nq.setSymbol(tab[0]);
        nq.setName(tab[1]);
        nq.setLastPrice(Double.parseDouble(tab[2]));
        nq.setMarketCap(Double.parseDouble(tab[3]));
        nq.setAdrTSO(tab[4]);
        nq.setUrl(tab[8]);
        res.add(nq);
      }
    } catch (NumberFormatException ex)
    {
      Logger.getLogger(NasdaqLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex)
    {
      Logger.getLogger(NasdaqLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex)
    {
      Logger.getLogger(NasdaqLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return res;
  }

  /**
   * Load a Nasdaq historical price from a file
   * @param filepath
   * @return
   */
  public List<NasdaqQuote> loadFromCSV(String filepath)
  {
    try (InputStream fis = new FileInputStream(filepath))
    {
      return loadFromCSV(fis);
    } catch (IOException ex)
    {
      Logger.getLogger(NasdaqLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  public List<NasdaqQuote> loadFromNasdaq(NasdaqExchange nasdaqExchange, Proxy proxy)
  {
    List<NasdaqQuote> res;
    if (nasdaqExchange == NasdaqExchange.ALL)
    {
      res = loadFromNasdaq(NasdaqExchange.NASDAQ, proxy);
      res.addAll(loadFromNasdaq(NasdaqExchange.NYSE, proxy));
      res.addAll(loadFromNasdaq(NasdaqExchange.AMEX, proxy));
      return res;
    }
    String urlAddress = "http://www.nasdaq.com/screening/companies-by-name.aspx?letter=0&exchange=" + nasdaqExchange.toString().toLowerCase() + "&render=download";
    try
    {
      URL url = new URL(urlAddress);
      HttpURLConnection urlConnection = (HttpURLConnection)(proxy == null ? url.openConnection() : url.openConnection(proxy));

      try (InputStream is = urlConnection.getInputStream())
      {
        res = loadFromCSV(is);
      }
      return res;
    } catch (MalformedURLException ex)
    {
      Logger.getLogger(NasdaqLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex)
    {
      Logger.getLogger(NasdaqLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
