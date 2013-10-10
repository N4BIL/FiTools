package com.laadadra.fitools.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.List;
import javax.naming.spi.DirectoryManager;
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
   */
  @Test
  public void testLoadFromCSV() throws FileNotFoundException, IOException
  {
    FileInputStream fis = new FileInputStream("data/AF");
    YahooLoader yl = new YahooLoader();
    List<SecurityQuoteHistory> sqhList = yl.loadFromCSV(fis);
    assertEquals(3540, sqhList.size());
   
    
    

    Calendar cal = Calendar.getInstance();
    cal.set(2013, Calendar.AUGUST, 9, 0, 0, 0);
    cal.set(Calendar.MILLISECOND, 0);
    
    SecurityQuoteHistory sqh = sqhList.get(0);
    assertEquals(6.61, sqh.getClose(), 0.001);
    assertEquals(6.61, sqh.getAdjClose(), 0.001);
    assertEquals(6.62, sqh.getHigh(), 0.001);
    assertEquals(6.42, sqh.getLow(), 0.001);
    assertEquals(6.43, sqh.getOpen(), 0.001);
    assertEquals(4648100., sqh.getVolume(), 0.001);
    assertEquals(cal.getTime(), sqh.getQuoteDate());
  }
}