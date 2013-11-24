package com.laadadra.fitools.security.data.nasdaq;

import com.laadadra.fitools.security.data.euronext.*;
import com.laadadra.fitools.security.data.euronext.EuronextQuote;
import com.laadadra.fitools.security.data.euronext.EuronextLoader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil
 */
public class NasdaqLoaderTest
{
  
  public NasdaqLoaderTest()
  {
  }
  
  @BeforeClass
  public static void setUpClass()
  {
  }
  
  @AfterClass
  public static void tearDownClass()
  {
  }
  
  @Before
  public void setUp()
  {
  }
  
  @After
  public void tearDown()
  {
  }

  /**
   * Test of loadFromCSV method, of class NasdaqLoader.
   */
  @Test
  public void testLoadFromCSV() throws FileNotFoundException
  {
    FileInputStream fis = new FileInputStream("data/Nasdaq.csv");
    NasdaqLoader nl = new NasdaqLoader();
    List<NasdaqQuote> nasList = nl.loadFromCSV(fis);
    assertEquals(2747, nasList.size());
   
    NasdaqQuote sqh = nasList.get(0);
    assertEquals("FLWS", sqh.getSymbol());
    assertEquals("1-800 FLOWERS.COM, Inc.", sqh.getName());
    assertEquals(5.1, sqh.getLastPrice(), 0.01);
    assertEquals(136052817.3, sqh.getMarketCap(), 0.01);
  }
  
  @Test
  public void testLoadFromNasdaq()
  {
    NasdaqLoader nl = new NasdaqLoader();
    List<NasdaqQuote> nasList = nl.loadFromNasdaq(NasdaqLoader.NasdaqExchange.AMEX, new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.ossiam.local", 3128)));
    assertEquals(true, nasList.size() > 100);
  }

  
  
}
