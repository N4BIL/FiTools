package com.laadadra.fitools.security.indicator.simple;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author nabil.laadadra
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
  com.laadadra.fitools.security.indicator.simple.AveragePerformanceTest.class,
  com.laadadra.fitools.security.indicator.simple.MinTest.class,
  com.laadadra.fitools.security.indicator.simple.MaxDrowDownTest.class,
  com.laadadra.fitools.security.indicator.simple.BollingerTest.class,
  com.laadadra.fitools.security.indicator.simple.AverageTest.class,
  com.laadadra.fitools.security.indicator.simple.VolatilityTest.class,
  com.laadadra.fitools.security.indicator.simple.RSITest.class,
  com.laadadra.fitools.security.indicator.simple.MaxTest.class
})
public class SimpleSuite
{

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }
  
}
