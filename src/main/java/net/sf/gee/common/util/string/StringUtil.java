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
package net.sf.gee.common.util.string;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * 
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class StringUtil {

  /**
   * Checks if it is: null, empty, single blank space, multiple blank spaces
   *
   * @param input the input
   * 
   * @return true, if is empty
   */
  public static boolean isEmpty(String input) {

    // check null
    if (input == null) {
      return true;
    }

    // check empty string
    if ("".equals(input)) {
      return true;
    }

    // check space string
    if (" ".equals(input)) {
      return true;
    }

    if (input.matches("[\\s]+")) {
      return true;
    }

    return false;
  }


  /**
   * Concatenate base string with all arguments passed
   *
   * @param base the base string where arguments will be tailed.
   * @param args the argument to attach in tail to base string
   * 
   * @return full string concatenation
   */
  public static String concat(String base, Object... args) {

    final String res = String.format(base, args);

    return res;
  }

  /**
   * De-escape a string for single quote or double quotes.
   * 
   * @param value string to de-escape
   * 
   * @return string without single quotes or double quotes. If input value is null or empty string,
   *         method return NULL.
   */
  public static String descape(String value) {

    if (isEmpty(value)) {
      return null;
    }

    String workCopy = value.trim();

    if (workCopy.charAt(0) == '\'') {
      workCopy = workCopy.substring(1);

    }
    else if (workCopy.charAt(0) == '"') {
      workCopy = workCopy.substring(1);
    }

    int lenght = workCopy.length();

    if (workCopy.endsWith("\'")) {
      workCopy = workCopy.substring(0, lenght - 1);
    }
    else if (workCopy.endsWith("\"")) {
      workCopy = workCopy.substring(0, lenght - 1);
    }

    return workCopy;
  }

  /**
   * Escape a string following SQL syntax.
   *
   * @param value SQL parameter or value
   * 
   * @return SQL syntax string escaped. If input value is null or empty string, method returns NULL.
   */
  public static String escapeSQL(String value) {

    if (isEmpty(value)) {
      return null;
    }

    String workingCopy = value;

    workingCopy = workingCopy.replaceAll("\'", "\'\'");

    return workingCopy;
  }

  /**
   * Convert in {@linkplain java.lang.String} the byte array using the charset.
   *
   * @param content the byte array
   * @param charset the charset {@linkplain java.nio.Charset}
   * 
   * @return if content is not null or empty than it returns {@linkplain java.lang.String},
   *         otherwise it returns NULL.
   */
  public static String toString(byte[] content, Charset charset) {

    if (content == null || content.length == 0) {
      return null;
    }

    return new String(content, charset);
  }

  /**
   * Convert byte array in {@linkplain java.lang.String} using
   * {@linkplain java.nio.Charset#defaultCharset()} as charset
   *
   * @see StringUtil#toString(byte[], Charset)
   * 
   * @param content
   * 
   * @return the string
   */
  public static String toString(byte[] content) {
    return toString(content, Charset.defaultCharset());
  }

  /**
   * Convert byte array in {@linkplain java.lang.String} using UTF-8 as charset.
   *
   * @see StringUtil#toString(byte[], Charset)
   * 
   * @param content
   * 
   * @return the string
   */
  public static String toUTF8(byte[] content) {
    return toString(content, Charset.forName("UTF-8"));
  }

  /**
   * Convert byte array in {@linkplain java.lang.String} using UTF-16 big endian as charset
   *
   * @see StringUtil#toString(byte[], Charset)
   * 
   * @param content
   * 
   * @return the string
   */
  public static String toUTF16BE(byte[] content) {
    return toString(content, Charset.forName("UTF-16BE"));
  }

  /**
   * Convert byte array in {@linkplain java.lang.String} using utf-16 little endian as charset.
   *
   * @see StringUtil#toString(byte[], Charset)
   * 
   * @param content
   * 
   * @return the string
   */
  public static String toUTF16LE(byte[] content) {
    return toString(content, Charset.forName("UTF-16LE"));
  }

  /**
   * To string method.
   *
   * @param input the input object {@linkplain java.lang.Object}
   * 
   * @return if input object is null than it returns an empty string, otherwise return the string
   *         value of object.
   */
  public static String toString(Object input) {

    String toString = null;

    if (input == null) {
      return "";
    }

    // BigDecimal
    if (BigDecimal.class.equals(input.getClass())) {
      toString = ((BigDecimal) input).toPlainString();

    } // BigInteger
    if (BigInteger.class.equals(input.getClass())) {
      toString = ((BigInteger) input).toString();

    } // Long
    if (Long.class.equals(input.getClass())) {
      toString = ((Long) input).toString();

    } // Double
    if (Double.class.equals(input.getClass())) {
      toString = ((Double) input).toString();

    } // Float
    if (Float.class.equals(input.getClass())) {
      toString = ((Float) input).toString();

    } // Integer
    if (Integer.class.equals(input.getClass())) {
      toString = ((Integer) input).toString();

    } // Stirng
    if (String.class.equals(input.getClass())) {
      toString = (String) input;

    } // generic toString()
    else {
      toString = input.toString();
    }

    return toString;
  }
}
