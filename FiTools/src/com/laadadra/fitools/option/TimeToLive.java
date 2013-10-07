/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laadadra.fitools.option;

import java.util.Date;

/**
 *
 * @author nabil.laadadra
 */
public class TimeToLive
{

  private double diffDateInYear = 0.;

  public enum DateType
  {

    YEAR, MONTH, DAY
  };

  public TimeToLive(Date maturity)
  {
    Date now = new Date();
    if (maturity.after(now))
      diffDateInYear = (maturity.getTime() - now.getTime()) / 1000. / 3600. / 24. / 365.;
  }

  public TimeToLive(DateType type, int diff)
  {
    if (diff >= 0)
    {
      if (type == DateType.YEAR)
        diffDateInYear = diff;
      if (type == DateType.MONTH)
        diffDateInYear = diff / 12.;
      if (type == DateType.DAY)
        diffDateInYear = diff / 365.;
    }
  }

  public double getDiffDateInYear()
  {
    return diffDateInYear;
  }

}
