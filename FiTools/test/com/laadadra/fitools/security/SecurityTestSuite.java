/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laadadra.fitools.security;

import com.laadadra.fitools.security.indicator.IndicatorSuite;
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
  IndicatorSuite.class
})
public class SecurityTestSuite
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