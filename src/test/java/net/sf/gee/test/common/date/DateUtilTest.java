/**
 * ---------------------------------------------------------------------------- Written by Giorgio
 * Desideri.
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA
 * 
 **/
package net.sf.gee.test.common.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.date.DateUtil;

/**
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class DateUtilTest {

  @Test
  public void testIsBefore() {
    long now = System.currentTimeMillis();

    long before = now - 1000;

    Assert.assertFalse(DateUtil.isBefore(new Date(now), new Date(before)));
    Assert.assertTrue(DateUtil.isBefore(new Date(before), new Date(now)));
  }

  @Test
  public void testXml() {

    java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());

    XMLGregorianCalendar xml = DateUtil.toXml(ts);

    Assert.assertNotNull(xml);

    Date dd2 = DateUtil.fromXml(xml);

    Assert.assertEquals(dd2.getTime(), ts.getTime());
  }

  @Test
  public void testToDate() {
    Date dd = new Date(System.currentTimeMillis());

    LocalDate ld = DateUtil.toLocalDate(dd);

    Assert.assertNotNull(ld);

    Date dd2 = DateUtil.toDate(ld);

    Assert.assertNotNull(dd2);
    Assert.assertNotEquals(dd2.getTime(), dd.getTime());
  }

  @Test
  public void testFormatDate() {
    try {
      String date = DateUtil.formatDate(new Date(System.currentTimeMillis()), "dd/MM/yyyy");

      Assert.assertTrue(date.contains("/"));
    }
    catch (Exception e) {
      e.printStackTrace();

      Assert.fail();
    }
  }

  @Test
  public void testFormatDate2() {
    try {
      Date date = DateUtil.formatDate("19/06/1982", "dd/MM/yyyy");

      Assert.assertTrue(date != null);
    }
    catch (Exception e) {
      e.printStackTrace();

      Assert.fail();
    }
  }

  @Test
  public void testFormatDate3() {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      String date = DateUtil.formatDate(sdf.parse("19/06/1982"), "EEE dd-MM-yyyy", Locale.ENGLISH);

      Assert.assertTrue(date.startsWith("Sat"));
    }
    catch (Exception e) {
      e.printStackTrace();

      Assert.fail();
    }
  }


}
