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
package net.sf.gee.common.util.numeric;

import java.math.BigDecimal;
import java.security.SecureRandom;

import net.sf.gee.common.util.string.StringUtil;

/**
 * 
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class NumericUtil {

  /**
   * To big decimal.
   *
   * @param genericValue the generic value
   * @return the big decimal
   */
  public static BigDecimal toBigDecimal(Object genericValue) {

    BigDecimal value = null;

    if (genericValue == null) {
      return value;
    }
    else if (BigDecimal.class.equals(genericValue.getClass())) {
      value = (BigDecimal) genericValue;

    }
    else if (String.class.equals(genericValue.getClass())) {

      if (!StringUtil.isEmpty((String) genericValue)) {

        value = new BigDecimal((String) genericValue);
      }
    }

    return value;
  }

  /**
   * Generate random int number
   * 
   * @return random integer [-2<sup>31</sup> , 2<sup>31</sup>]
   */
  public static int generateRandomInt() {
    return generateRandom(0, 0);
  }

  /**
   * Generate random long number
   * 
   * @return random long [-2<sup>63</sup>, 2<sup>63</sup>]
   */
  public static long generateRandomLong() {
    return generateRandom(0L, 0L);
  }


  /**
   * Generate random number as int inside a range, borders includes.
   * 
   * @param start, minimum value or start value of range
   * @param end, maximmum value or end value of range
   * 
   * @return int inside range [start, end]
   */
  public static int generateRandom(int start, int end) {

    SecureRandom sr = new SecureRandom();

    // generate withour range
    if (start == 0 && end == 0) {
      return sr.nextInt();

    } // generate with ranges
    else {
      int range = end - start + 1;

      return (sr.nextInt(range) + start);
    }
  }

  /**
   * Generate random number as long inside a range, borders includes.
   * 
   * @param start
   * @param end
   * 
   * @return long
   */
  public static long generateRandom(long start, long end) {

    SecureRandom sr = new SecureRandom();

    // generate withour range
    if (start == 0 && end == 0) {
      return sr.nextLong();

    } // generate with ranges
    else {
      long range = end - start + 1;

      return ((sr.nextLong() % range) + start);
    }
  }
}
