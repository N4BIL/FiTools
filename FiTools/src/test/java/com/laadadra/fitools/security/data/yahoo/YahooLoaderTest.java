package com.laadadra.fitools.security.data.yahoo;

import com.laadadra.fitools.security.data.yahoo.YahooLoader;
import com.laadadra.fitools.security.data.yahoo.YahooQuoteHistory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nabil.laadadra
 */
public class YahooLoaderTest
{
  
  public YahooLoaderTest()
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
   * Test of loadFromCSV method, of class YahooLoader.
   * @throws java.io.FileNotFoundException
   */
  @Test
  public void testLoadFromCSV() throws FileNotFoundException
  {
    FileInputStream fis = new FileInputStream("data/AF");
    YahooLoader yl = new YahooLoader();
    List<YahooQuoteHistory> sqhList = yl.loadFromCSV(fis);
    assertEquals(3540, sqhList.size());
   
    Calendar cal = Calendar.getInstance();
    cal.set(2013, Calendar.AUGUST, 9, 0, 0, 0);
    cal.set(Calendar.MILLISECOND, 0);
    
    YahooQuoteHistory sqh = sqhList.get(0);
    assertEquals(6.61, sqh.getClose(), 0.001);
    assertEquals(6.61, sqh.getAdjClose(), 0.001);
    assertEquals(6.62, sqh.getHigh(), 0.001);
    assertEquals(6.42, sqh.getLow(), 0.001);
    assertEquals(6.43, sqh.getOpen(), 0.001);
    assertEquals(4648100., sqh.getVolume(), 0.001);
    assertEquals(cal.getTime(), sqh.getQuoteDate());
  }
  
  @Test
  public void testLoadFromYahoo()
  {
    Date startDate;
    Date endDate;
    Calendar cal = Calendar.getInstance();
    cal.set(2004, Calendar.APRIL, 1);
    startDate = cal.getTime();
    cal.set(2012, Calendar.DECEMBER, 19);
    endDate = cal.getTime();
    
    YahooLoader yl = new YahooLoader();
    List<YahooQuoteHistory> quoteList = yl.loadFromYahoo("AF.PA", new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.ossiam.local", 3128)), startDate, endDate);
    YahooQuoteHistory sqh = quoteList.get(0);
    assertEquals(7.211, sqh.getClose(), 0.01);
  }
}