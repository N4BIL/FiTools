package com.laadadra.fitools.option;

import java.util.Calendar;
import java.util.Date;
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
public class TimeToLiveTest
{
  
  public TimeToLiveTest()
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
   * Test of getDiffDateInYear method, of class TimeToLive.
   */
  @Test
  public void testGetDiffDateInYear()
  {
    TimeToLive ttl0 = new TimeToLive(TimeToLive.DateType.YEAR, 1);
    assertEquals(1., ttl0.getDiffDateInYear(), 0.0001);
    
    TimeToLive ttl1 = new TimeToLive(TimeToLive.DateType.MONTH, 3);
    assertEquals(0.25, ttl1.getDiffDateInYear(), 0.0001);
    
    TimeToLive ttl2 = new TimeToLive(TimeToLive.DateType.DAY, 1);
    assertEquals(1. / 365., ttl2.getDiffDateInYear(), 0.0001);
    
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, 90);
    Date maturity = cal.getTime();
    TimeToLive ttl4 = new TimeToLive(maturity);
    assertEquals(90. / 365., ttl4.getDiffDateInYear(), 0.001);
  }
}