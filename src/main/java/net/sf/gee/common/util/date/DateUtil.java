/**
 * -------------------------------------------------------------------------------------------------
 * 
 * Copyright 2015 - Giorgio Desideri
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the
 * License.
 * 
 */
package net.sf.gee.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * 
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class DateUtil {

  /**
   * Checks if is before.
   *
   * @param date1 the date1 {@linkplain java.util.Date}
   * @param date2 the date2 {@linkplain java.util.Date}
   * 
   * @return <code>true</code>, if date1 is before than date2, <code>false</code> otherwise (equals
   *         and after date2).
   */
  public static boolean isBefore(Date date1, Date date2) {

    if (date1.getTime() < date2.getTime()) {
      return true;

    }
    else {
      return false;
    }
  }

  /**
   * Transform from {@linkplain java.sql.Timestamp} to
   * {@linkplain javax.xml.datatype.XMLGregorianCalendar}.
   *
   * @param timestamp the timestamp {@linkplain java.sql.Timestamp}
   * 
   * @return {@linkplain javax.xml.datatype.XMLGregorianCalendar}. If there are some errors /
   *         exceptions it returns <code>null</code>
   */
  public static XMLGregorianCalendar toXml(java.sql.Timestamp timestamp) {
    return toXml(new java.util.Date(timestamp.getTime()));
  }

  /**
   * Transform from {@linkplain java.util.Date} to
   * {@linkplain javax.xml.datatype.XMLGregorianCalendar}.
   *
   * @param dateTime the date {@linkplain java.util.Date}
   * 
   * @return {@linkplain javax.xml.datatype.XMLGregorianCalendar}. If there are some errors /
   *         exceptions it returns <code>null</code>
   */
  public static XMLGregorianCalendar toXml(java.util.Date dateTime) {

    // gregorian calendar
    GregorianCalendar gc = new GregorianCalendar();

    // set date
    gc.setTime(dateTime);

    XMLGregorianCalendar xmlDate = null;

    try {
      // get xml gregorian calendar
      xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

    }
    catch (DatatypeConfigurationException e) {
      e.printStackTrace();
    }

    return xmlDate;
  }

  /**
   * Transform from {@linkplain javax.xml.datatype.XMLGregorianCalendar} to
   * {@linkplain java.util.Date}.
   *
   * @param xmlDate the not-null xml date {@linkplain javax.xml.datatype.XMLGregorianCalendar}
   * 
   * @return the date {@linkplain java.util.Date}
   */
  public static Date fromXml(XMLGregorianCalendar xmlDate) {
    return xmlDate.toGregorianCalendar().getTime();
  }


  /**
   * Transform from {@linkplain java.util.Date} to {@linkplain java.time.LocalDate}.
   *
   * @param date the not-null date
   * 
   * @return the local date with system default {@linkplain java.time.ZoneId}.
   */
  public static LocalDate toLocalDate(Date date) {
    return toLocalDate(date, ZoneId.systemDefault());
  }

  /**
   * Transform from {@linkplain java.util.Date} to {@linkplain java.time.LocalDate}.
   *
   * @param date the date {@linkplain java.util.Date}
   * @param zone the zone {@linkplain java.time.ZoneId}
   * 
   * @return the local date with custom zone id.
   */
  public static LocalDate toLocalDate(Date date, ZoneId zone) {
    Instant instant = Instant.ofEpochMilli(date.getTime());

    return LocalDateTime.ofInstant(instant, zone).toLocalDate();
  }

  /**
   * Transform from {@linkplain java.time.LocalDate} to {@linkplain java.util.Date}.
   *
   * @param localDate the not-null local date {@linkplain java.time.LocalDate}
   * 
   * @return the date {@linkplain java.util.Date} with system default {@linkplain java.time.ZoneId}.
   */
  public static Date toDate(LocalDate localDate) {
    return toDate(localDate, ZoneId.systemDefault());
  }

  /**
   * Transform from {@linkplain java.time.LocalDate} to {@linkplain java.util.Date}.
   *
   * @param localDate the not-null local date {@linkplain java.time.LocalDate}
   * @param zone the zone {@linkplain java.time.ZoneId}
   * 
   * @return the date {@linkplain java.util.Date}
   */
  public static Date toDate(LocalDate localDate, ZoneId zone) {
    Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();

    return Date.from(instant);
  }

  /**
   * Format date.
   *
   * @param date the date {@linkplain java.util.Date}
   * @param pattern the pattern
   * 
   * @return date as string with English Locale
   */
  public static String formatDate(Date date, String pattern) {
    return formatDate(date, pattern, Locale.ENGLISH);
  }

  /**
   * Format date.
   *
   * @param date the date {@linkplain java.util.Date}
   * @param pattern the pattern
   * @param locale the locale {@linkplain java.util.Locale}
   * 
   * @return date as string
   */
  public static String formatDate(Date date, String pattern, Locale locale) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);

    return sdf.format(date);
  }

  /**
   * Format date.
   *
   * @param date the date as string
   * @param pattern the pattern
   * 
   * @return the date {@linkplain java.util.Date}
   */
  public static Date formatDate(String date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    Date dateObj = null;

    try {
      dateObj = sdf.parse(date);
    }
    catch (ParseException e) {
      e.printStackTrace();
    }

    return dateObj;
  }
}
