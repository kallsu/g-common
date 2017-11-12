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
package net.sf.gee.test.common.security;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.security.SecurityUtil;

/**
 * The Class SecurityUtilTest.
 */
public class SecurityUtilTest {

  @Test
  public void testSalt() {
    String word = "Giorgio Desideri, I'm here to encrypt myself";

    byte[] salt1 = SecurityUtil.createSalt("".getBytes());
    byte[] salt2 = SecurityUtil.createSalt(null);

    Assert.assertNotEquals(salt1, salt2);
    System.out.println(salt1);
    System.out.println(salt2);

    salt1 = SecurityUtil.createSalt(word.getBytes());

    Assert.assertNotNull(salt1);
    System.out.println(salt1);
  }

  @Test
  public void testAES256() {
    try {
      byte[] secketKey = "12345".getBytes("UTF-8");

      // empty password
      String msg = "";
      byte[] salt = SecurityUtil.createSalt(msg.getBytes("UTF-8"));

      byte[] enc = SecurityUtil.digestAES256(msg.getBytes("UTF-8"), secketKey, salt);

      Assert.assertNotNull(enc);
      Assert.assertTrue(enc.length > 1);

      // test password
      msg = "test password";
      salt = SecurityUtil.createSalt(msg.getBytes("UTF-8"));

      byte[] enc2 = SecurityUtil.digestAES256(msg.getBytes("UTF-8"), secketKey, salt);

      Assert.assertNotNull(enc2);
      Assert.assertNotEquals(enc, enc2);

      System.out.println(enc);
      System.out.println(enc2);

    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();

      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void testRandom() {

    int r1 = SecurityUtil.random();
    int r2 = SecurityUtil.random();

    Assert.assertNotEquals(r1, r2);

    int n = SecurityUtil.random(1, 10);

    Assert.assertTrue(n < 11);
    Assert.assertTrue(n > 1);
  }

  @Test
  public void testRandomString() {

    String str = SecurityUtil.generateRandomString(32);

    Assert.assertNotNull(str);
    Assert.assertTrue(str.length() == 32);

    String alphabet = "ABCDEFGHIJKL";

    str = SecurityUtil.generateRandomString(alphabet.toCharArray(), 12);

    Assert.assertNotNull(str);
    Assert.assertTrue(str.length() == 12);
    Assert.assertTrue(str.contains("D"));
    Assert.assertFalse(str.contains("Z"));
  }

}
