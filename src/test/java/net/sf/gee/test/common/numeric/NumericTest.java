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
package net.sf.gee.test.common.numeric;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.numeric.NumericUtil;

/**
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class NumericTest {

  @Test
  public void test() {

    int res = NumericUtil.generateRandomInt();
    Assert.assertTrue(Integer.MIN_VALUE < res && res < Integer.MAX_VALUE);

    long resLong = NumericUtil.generateRandomLong();
    Assert.assertTrue(Long.MIN_VALUE < resLong && resLong < Long.MAX_VALUE);

    res = NumericUtil.generateRandom(-100, 100);
    Assert.assertTrue(-100 <= res && res <= 100);

    resLong = NumericUtil.generateRandom(-1000L, 1000L);
    // Assert.assertTrue((-1000L) <= resLong && resLong <= 1000L);

    Assert.assertNull(NumericUtil.toBigDecimal(null));
    Assert.assertNull(NumericUtil.toBigDecimal(""));

    Assert.assertEquals(new BigDecimal("1000"), NumericUtil.toBigDecimal("1000"));
    Assert.assertEquals(new BigDecimal("1000"), NumericUtil.toBigDecimal(new BigDecimal("1000")));
  }
}
