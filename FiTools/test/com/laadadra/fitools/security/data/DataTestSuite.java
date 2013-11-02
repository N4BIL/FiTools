package com.laadadra.fitools.security.data;

import com.laadadra.fitools.security.data.euronext.EuronextLoaderTest;
import com.laadadra.fitools.security.data.yahoo.YahooLoaderTest;
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
          YahooLoaderTest.class,
          EuronextLoaderTest.class
})
public class DataTestSuite
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