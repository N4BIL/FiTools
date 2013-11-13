package com.laadadra.fitools;

import com.laadadra.fitools.option.OptionTestSuite;
import com.laadadra.fitools.rate.RateTestSuite;
import com.laadadra.fitools.security.SecurityTestSuite;
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
  OptionTestSuite.class,
  SecurityTestSuite.class,
  RateTestSuite.class
})
public class TestSuite
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