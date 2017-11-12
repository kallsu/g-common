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
package net.sf.gee.common.util;

/**
 * The Class StatUtil.
 *
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 */
public class StatUtil {

  /**
   * Compare param2 against param1.
   * 
   * param1 is the gold master
   *
   * @param input1 the param1
   * @param input2 the param2
   * 
   * @return the ratio of comparison
   */
  public static double compare(String input1, String input2) {

    String param1 = input1.toUpperCase();
    String param2 = input2.toUpperCase();

    double lenght = input1.length();
    double matchRatio = 0D;

    // iterate
    for (int i = 0; i < param1.length(); i++) {

      // get char
      char c = param1.charAt(i);

      // match ?
      if (param2.indexOf(c) > -1) {
        matchRatio++;
      }
    }

    return (matchRatio / lenght);
  }
}
