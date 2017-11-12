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
package net.sf.gee.test.common.locale;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import net.sf.gee.common.util.locale.LocaleUtil;

/**
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class LocaleUtilTest {

  @Test
  public void test() {

    Locale _l = LocaleUtil.getLocale(null);
    Assert.assertEquals(Locale.ENGLISH, _l);

    _l = LocaleUtil.getLocale("");
    Assert.assertEquals(Locale.ENGLISH, _l);

    _l = LocaleUtil.getLocale("NOT_EXIST");
    Assert.assertEquals(Locale.ENGLISH, _l);

    _l = LocaleUtil.getLocale("ITALIAN");
    Assert.assertEquals(Locale.ITALIAN, _l);

    _l = LocaleUtil.getLocale("ENGLISH");
    Assert.assertEquals(Locale.ENGLISH, _l);

    _l = LocaleUtil.getLocale("SPANISH");
    Assert.assertEquals(new Locale("es_ES"), _l);

    _l = LocaleUtil.getLocale("PORTOGUESE");
    Assert.assertEquals(new Locale("pt_PT"), _l);

    _l = LocaleUtil.getLocale("DEUTSCH");
    Assert.assertEquals(Locale.GERMAN, _l);

    _l = LocaleUtil.getLocale("FRENCH");
    Assert.assertEquals(Locale.FRENCH, _l);

    _l = LocaleUtil.getLocale("RUSSIAN");
    Assert.assertEquals(new Locale("ru_RU"), _l);

    _l = LocaleUtil.getLocale("CHINESE");
    Assert.assertEquals(Locale.CHINESE, _l);

    _l = LocaleUtil.getLocale("JAPANESE");
    Assert.assertEquals(new Locale("ja_JP"), _l);
  }


}
