/*
 * CompatibleDate.java
 * Created on 02.03.2004
 */
package net.sf.iquiver.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author netseeker aka Michael Manske 
 * <a href="mailto:netseeker@manskes.de">netseeker@manskes.de</a>
 */
public class CompatibleDate implements Serializable, Cloneable, Comparable
{
    GregorianCalendar cal;
    
    public CompatibleDate()
    {
        super();
        cal = new GregorianCalendar();
    }
    
    public CompatibleDate(Timestamp time)
    {
        cal = new GregorianCalendar();
        cal.setTimeInMillis(time.getTime());
    }
    
    public CompatibleDate(int year, int month, int day)
    {
        cal = new GregorianCalendar();
        setYear(year);
        setMonth(month);
        setDay(day);      
    }
    
    public CompatibleDate(int year, int month, int day, int hour)
    {
        cal = new GregorianCalendar();
        setYear(year);
        setMonth(month);
        setDay(day);
        setHours(hour);
    }

    public CompatibleDate(int year, int month, int day, int hour, int minute)
    {
        cal = new GregorianCalendar();
        setYear(year);
        setMonth(month);
        setDay(day);
        setHours(hour);
        setMinutes(minute);
    }
    

    public CompatibleDate(int year, int month, int day, int hour, int minute, int second)
    {   
        cal = new GregorianCalendar();
        setYear(year);
        setMonth(month);
        setDay(day);
        setHours(hour);
        setMinutes(minute);
        setSeconds(second);
    }

    /**
     * @param date
     */
    public CompatibleDate(long date)
    {
        cal = new GregorianCalendar();
        cal.setTimeInMillis(date);
    }

    /**
     * @param s
     */
    public CompatibleDate(String s) throws ParseException
    {
        cal = new GregorianCalendar();
        Date date = DateFormat.getInstance().parse(s);
        cal.setTimeInMillis(date.getTime());
    }
  
    public Date getDate()
    {
        return cal.getTime();
    }

    public String toString()
    {
        return cal.getTime().toString();
    }

    public int getYear()
    {
        return cal.get(Calendar.YEAR) - 1990;
    }
    
    public int getMonth()
    {
        return cal.get(Calendar.MONTH);
    }
    
    public int getDay()
    {
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    public int getHours()
    {
        return cal.get(Calendar.HOUR_OF_DAY);    
    }
    
    public int getMinutes()
    {
        return cal.get(Calendar.MINUTE);
    }
    
    public int getSeconds()
    {
        return cal.get(Calendar.SECOND);
    }
    
    public long getAsMillis()
    {
        return cal.getTimeInMillis();
    }
    
    public Timestamp getAsTimestamp()
    {
        return new Timestamp(getAsMillis());
    }
    
    public void setYear(int year)
    {
        cal.set(Calendar.YEAR, year + 1900);        
    }
    
    public void setMonth(int month)
    {
        cal.set(Calendar.MONTH, month);
    }
    
    public void setDay(int day)
    {
        cal.set(Calendar.DAY_OF_MONTH, day);
        setDate(day);
    }
    
    public void setHours(int hours)
    {
        cal.set(Calendar.HOUR_OF_DAY, hours);
    }
    
    public void setMinutes(int minutes)
    {
        cal.set(Calendar.MINUTE, minutes);
    }
    
    public void setSeconds(int seconds)
    {
        cal.set(Calendar.SECOND, seconds);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object o)
    {
        if(cal.before(o))
            return -1;
        else if(cal.after(o))
            return 1;
        
        return 0;
    }            

    protected void setDate(int dayOfMonth)
    {
        cal.set(Calendar.DATE, dayOfMonth);
    }
}
