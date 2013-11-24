package com.laadadra.fitools.security.data.euronext;

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
public class EuronextLoaderTest
{
  
  public EuronextLoaderTest()
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
   * Test of loadFromCSV method, of class EuronextLoader.
   */
  @Test
  public void testLoadFromCSV() throws FileNotFoundException
  {
    FileInputStream fis = new FileInputStream("data/Euronext.csv");
    EuronextLoader el = new EuronextLoader();
    List<EuronextQuote> eurList = el.loadFromCSV(fis);
    assertEquals(2443, eurList.size());
   
    Calendar cal = Calendar.getInstance();
    cal.set(2013, Calendar.NOVEMBER, 1, 17, 35, 0);
    cal.set(Calendar.MILLISECOND, 0);
    
    EuronextQuote sqh = eurList.get(0);
    assertEquals("1000MERCIS", sqh.getName());
    assertEquals("FR0010285965", sqh.getIsin());
    assertEquals("ALMIL", sqh.getSymbol());
    assertEquals("NYSE Alternext Paris", sqh.getMarket());
    assertEquals("EUR", sqh.getCurrency());
    assertEquals(46.56, sqh.getOpen(), 0.001);
    assertEquals(46.99, sqh.getClose(), 0.001);
    assertEquals(46.99, sqh.getHigh(), 0.001);
    assertEquals(46.56, sqh.getLow(), 0.001);
    assertEquals(46276.61, sqh.getVolumeInCurrency(), 0.001);
    assertEquals(989, sqh.getVolumeInQuantity(), 0.001);
    assertEquals(cal.getTime(), sqh.getLastTradeDate());
    
  }
  
  @Test
  public void testLoadFromEuronext()
  {
    EuronextLoader el = new EuronextLoader();
    List<EuronextQuote> eurList = el.loadFromEuronext(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.ossiam.local", 3128)));
    assertTrue(eurList.size() > 100);
    System.err.println(eurList.get(0));
  }

  
  
}
