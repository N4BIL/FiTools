package com.laadadra.fitools.option;

import java.util.Date;

/**
 * Measure a difference of time.
 * @author nabil.laadadra
 */
public class TimeToLive
{

  private double diffDateInYear = 0.;

  public enum DateType
  {
    YEAR, MONTH, DAY
  };

  /**
   * Init the class with a target date
   * @param maturity
   */
  public TimeToLive(Date maturity)
  {
    Date now = new Date();
    if (maturity.after(now))
      diffDateInYear = (maturity.getTime() - now.getTime()) / 1000. / 3600. / 24. / 365.;
  }

  /**
   * Init the class with a difference of time in days, months or years
   * @param type Difference in days, month or years
   * @param diff Number of type
   */
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

  
  /**
   * Get the difference of time in years
   * @return
   */
  public double getDiffDateInYear()
  {
    return diffDateInYear;
  }

}
