package com.laadadra.fitools.security.data.euronext;

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
public class EuronextLoader
{

  /**
   * Load a CSV file with the Euronext format
   *
   * @param is CSV file to load
   * @return List of security quote ordered by date DESC
   */
  public List<EuronextQuote> loadFromCSV(InputStream is)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    List<EuronextQuote> res = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
    {
      br.readLine();
      br.readLine();
      br.readLine();
      br.readLine();
      String line;
      while ((line = br.readLine()) != null)
      {
        line = line.replace("\"", "");
        String tab[] = line.split(";");
        EuronextQuote eq = new EuronextQuote();
        eq.setName(tab[0]);
        eq.setIsin(tab[1]);
        eq.setSymbol(tab[2]);
        eq.setMarket(tab[3]);
        eq.setCurrency(tab[4]);
        eq.setOpen(tab[5].equals("-") ? null : Double.parseDouble(tab[5].replace(",", ".")));
        eq.setHigh(tab[6].equals("-") ? null : Double.parseDouble(tab[6].replace(",", ".")));
        eq.setLow(tab[7].equals("-") ? null : Double.parseDouble(tab[7].replace(",", ".")));
        eq.setClose(tab[8].equals("-") ? null : Double.parseDouble(tab[8].replace(",", ".")));
        eq.setLastTradeDate(tab[9].equals("-") ? null : sdf.parse(tab[9].replace(",", ".")));
        eq.setVolumeInQuantity(tab[11].equals("-") ? null : Double.parseDouble(tab[11].replace(",", ".")));
        eq.setVolumeInCurrency(tab[12].equals("-") ? null : Double.parseDouble(tab[12].replace(",", ".")));
        res.add(eq);
      }
    } catch (FileNotFoundException ex)
    {
      Logger.getLogger(EuronextLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ParseException ex)
    {
      Logger.getLogger(EuronextLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return res;
  }

  /**
   * Load a Yahoo historical price from a file
   * @param filepath
   * @return
   */
  public List<EuronextQuote> loadFromCSV(String filepath)
  {
    try (InputStream fis = new FileInputStream(filepath))
    {
      return loadFromCSV(fis);
    } catch (IOException ex)
    {
      Logger.getLogger(EuronextLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  public List<EuronextQuote> loadFromEuronext(Proxy proxy)
  {
    String urlAddress = "https://europeanequities.nyx.com/fr/popup/data/download?ml=nyx_pd_stocks&cmd=default&formKey=nyx_pd_filter_values%3Aa4eb918a59a5b507707ea20eb38f530f";
    try
    {
      URL url = new URL(urlAddress);
      HttpURLConnection urlConnection = (HttpURLConnection)(proxy == null ? url.openConnection() : url.openConnection(proxy));
      
      String data = "format=2&layout=2&decimal_separator=2&date_format=1&op=Go&form_build_id=form-9d6008bda607fc90d43afcef704b89e8&form_id=nyx_download_form";
      
      urlConnection.setDoInput(true);
      urlConnection.setDoOutput(true);
      urlConnection.setRequestMethod("POST");
      urlConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      
      DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream ());
      wr.writeBytes(data);
      wr.flush();
      wr.close();
      
      List<EuronextQuote> res;
      try (InputStream is = urlConnection.getInputStream())
      {
        res = loadFromCSV(is);
      }
      return res;
    } catch (MalformedURLException ex)
    {
      Logger.getLogger(EuronextLoader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex)
    {
      Logger.getLogger(EuronextLoader.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
