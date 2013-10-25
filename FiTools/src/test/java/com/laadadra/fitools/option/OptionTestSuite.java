package com.laadadra.fitools.option;

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
  com.laadadra.fitools.option.OptionTest.class,
  com.laadadra.fitools.option.GaussianTest.class,
  com.laadadra.fitools.option.TimeToLiveTest.class,
})
public class OptionTestSuite
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