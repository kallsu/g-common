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
package net.sf.gee.test.common.string;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.string.StringUtil;

/**
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class StringUtilTest {

  @Test
  public void testConcat() {
    String base = "Hello %s %s";
    Object[] args = {"World", "!"};

    String res = StringUtil.concat(base, args);

    Assert.assertEquals("Hello World !", res);
  }

  @Test
  public void testEscape() {
    String input = "example string";

    String res = StringUtil.descape("'" + input + "'");
    Assert.assertEquals(input, res);

    res = StringUtil.descape("'" + input);
    Assert.assertEquals(input, res);

    res = StringUtil.descape(input + "'");
    Assert.assertEquals(input, res);

    res = StringUtil.descape("\"" + input + "\"");
    Assert.assertEquals(input, res);

    res = StringUtil.descape(input + "\"");
    Assert.assertEquals(input, res);

    res = StringUtil.descape("\"" + input);
    Assert.assertEquals(input, res);

    Assert.assertNull(StringUtil.descape(null));
    Assert.assertNull(StringUtil.descape(""));
  }

  @Test
  public void testEscapeSQL() {
    Assert.assertEquals("DELL''AVALLE", StringUtil.escapeSQL("DELL'AVALLE"));
  }

  @Test
  public void testIsEmpty() {
    Assert.assertTrue(StringUtil.isEmpty(""));

    Assert.assertTrue(StringUtil.isEmpty(null));

    Assert.assertTrue(StringUtil.isEmpty("   "));

    Assert.assertFalse(StringUtil.isEmpty(" Not Empty String "));
  }

  @Test
  public void testToString() {
    String input = "Hello World !";

    Assert.assertNull(StringUtil.toString(null));
    Assert.assertNull(StringUtil.toString(new byte[] {}));

    String res = StringUtil.toString(input.getBytes());
    Assert.assertEquals(input, res);

    res = StringUtil.toString(input.getBytes(), Charset.defaultCharset());
    Assert.assertEquals(input, res);

    try {
      res = StringUtil.toUTF16BE(input.getBytes("UTF-16BE"));
      Assert.assertEquals(input, res);

      res = StringUtil.toUTF16LE(input.getBytes("UTF-16LE"));
      Assert.assertEquals(input, res);

      res = StringUtil.toUTF8(input.getBytes("utf-8"));
      Assert.assertEquals(input, res);
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();

      Assert.fail();
    }
  }

  @Test
  public void testToStringGeneric() {
    String output = "10";

    String res = StringUtil.toString(new BigDecimal(output));
    Assert.assertEquals(output, res);

    res = StringUtil.toString(new BigInteger(output));
    Assert.assertEquals(output, res);

    res = StringUtil.toString(Integer.parseInt(output));
    Assert.assertEquals(output, res);

    res = StringUtil.toString(Long.parseLong(output));
    Assert.assertEquals(output, res);

    res = StringUtil.toString(Double.parseDouble(output));
    Assert.assertEquals(output + ".0", res);

    res = StringUtil.toString(Float.parseFloat(output));
    Assert.assertEquals(output + ".0", res);

    res = StringUtil.toString(output);
    Assert.assertEquals(output, res);

    Object obj = new Object();
    res = StringUtil.toString(obj);
    Assert.assertEquals(obj.toString(), res);
  }

}
