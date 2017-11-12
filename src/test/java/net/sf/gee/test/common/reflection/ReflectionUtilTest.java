/**
 * ------------------------------------------------------------------------------------------------
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
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 **/
package net.sf.gee.test.common.reflection;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.reflection.ReflectionUtil;

/**
 * @author Giorgio Desideri - giorgio.desideri@gmail.com
 *
 */
public class ReflectionUtilTest {

  @Test
  public void test1() {

    PojoNoOne pojo = new PojoNoOne();

    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "id"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "name"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "amount"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "amount2"));

    try {
      ReflectionUtil.getField(pojo.getClass(), "not_Existing_field");
    }
    catch (Exception e) {
      Assert.assertNotNull(e);
    }
  }

  @Test
  public void test2() {

    PojoNoTwo pojo = new PojoNoTwo();

    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "id"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "name"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "amount"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "amount2"));
    Assert.assertNotNull(ReflectionUtil.getField(pojo.getClass(), "code"));
  }

  @Test
  public void test3() {

    PojoNoTwo pojo = new PojoNoTwo();

    Assert.assertNotNull(ReflectionUtil
        .getValue(ReflectionUtil.getField(pojo.getClass(), "id").getType(), pojo, "id"));

    Assert.assertNotNull(ReflectionUtil
        .getValue(ReflectionUtil.getField(pojo.getClass(), "name").getType(), pojo, "name"));

    Assert.assertNotNull(ReflectionUtil
        .getValue(ReflectionUtil.getField(pojo.getClass(), "amount").getType(), pojo, "amount"));

    Assert.assertNotNull(ReflectionUtil
        .getValue(ReflectionUtil.getField(pojo.getClass(), "amount2").getType(), pojo, "amount2"));

    Assert.assertNotNull(ReflectionUtil
        .getValue(ReflectionUtil.getField(pojo.getClass(), "code").getType(), pojo, "code"));
  }

  @Test
  public void testIsPrimitiveOrWrapper() {

    Assert.assertTrue(ReflectionUtil.getClassType(int.class) == 1);
    Assert.assertTrue(ReflectionUtil.getClassType(double.class) == 1);
    Assert.assertFalse(ReflectionUtil.getClassType(String.class) == 1);

    Assert.assertTrue(ReflectionUtil.getClassType(String.class) == 2);
    Assert.assertTrue(ReflectionUtil.getClassType(Long.class) == 2);
    Assert.assertTrue(ReflectionUtil.getClassType(BigDecimal.class) == 2);
    Assert.assertTrue(ReflectionUtil.getClassType(BigInteger.class) == 2);
    Assert.assertTrue(ReflectionUtil.getClassType(Number.class) == 2);

  }
}
