package com.laadadra.fitools.security.indicator;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author nabil.laadadra
 */
public class DateRange
{
  private Date startDate;
  private Date endDate;
  
  private enum TimeUnit {DAY, WEEK, MONTH, QUARTER, SEMESTER, YEAR}; //TODO: check translation of "semestre"
  
  public DateRange(Date startDate, Date endDate)
  {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }
  
}
