package com.laadadra.fitools.security;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class YahooLoader
{
  
  /**
   * Load a CSV file with the Yahoo's format
   * @param is CSV file to load
   * @return List of security quote history ordered by date DESC
   */
  public List<SecurityQuoteHistory> loadFromCSV(InputStream is)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    List<SecurityQuoteHistory> res = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
    {
      br.readLine();
      String line;
      while ((line = br.readLine()) != null)
      {
        String tab[] = line.split(",");
        SecurityQuoteHistory sqd = new SecurityQuoteHistory();
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
}
