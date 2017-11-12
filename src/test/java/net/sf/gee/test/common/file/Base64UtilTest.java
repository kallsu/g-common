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
package net.sf.gee.test.common.file;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.file.Base64Util;

/**
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class Base64UtilTest {

  @Test
  public void testEncode() {

    String original = "Hello World !";

    Assert.assertNotNull(Base64Util.encode(original.getBytes()));
    Assert.assertNotNull(Base64Util.encode(original));
    Assert.assertNotNull(Base64Util.encode(original, Charset.defaultCharset()));
  }

  @Test
  public void testDecode() {

    String sample = "Hello World !";

    Assert.assertNotNull(Base64Util.decode(sample.getBytes()));
    Assert.assertNotNull(Base64Util.decode(sample));
    Assert.assertNotNull(Base64Util.decode(sample, Charset.defaultCharset()));

  }

}
