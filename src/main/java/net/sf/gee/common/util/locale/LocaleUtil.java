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
package net.sf.gee.common.util.locale;

import java.util.Locale;

import net.sf.gee.common.util.string.StringUtil;

/**
 * The Class LocaleUtil.
 */
public class LocaleUtil {

  /**
   * Gets the locale.
   *
   * @param input the input
   * @return the locale
   */
  public static Locale getLocale(String input) {

    Locale locale = null;

    if (StringUtil.isEmpty(input)) {
      return Locale.ENGLISH;
    }

    switch (input) {

      case "ITALIAN":
        locale = Locale.ITALIAN;
        break;

      case "ENGLISH":
        locale = Locale.ENGLISH;
        break;

      case "SPANISH":
        locale = new Locale("es_ES");
        break;

      case "PORTOGUESE":
        locale = new Locale("pt_PT");
        break;

      case "DEUTSCH":
        locale = Locale.GERMAN;
        break;

      case "FRENCH":
        locale = Locale.FRENCH;
        break;

      case "RUSSIAN":
        locale = new Locale("ru_RU");
        break;

      case "CHINESE":
        locale = Locale.CHINESE;
        break;

      case "JAPANESE":
        locale = new Locale("ja_JP");
        break;

      default:
        locale = Locale.ENGLISH;
        break;
    }


    return locale;
  }
}
