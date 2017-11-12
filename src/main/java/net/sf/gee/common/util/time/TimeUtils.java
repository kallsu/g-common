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
package net.sf.gee.common.util.time;

/**
 * 
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public final class TimeUtils {

  /**
   * Gets the elapsed time in millis.
   *
   * @param startTime the start time
   * @param endTime the end time
   * @return the elapsed time in millis
   */
  public static String getElapsedTimeInMillis(long startTime, long endTime) {

    long delta = endTime - startTime;

    return String.valueOf(delta);
  }

  /**
   * Gets the elapsed time in secs.
   *
   * @param startTime the start time
   * @param endTime the end time
   * @return the elapsed time in secs
   */
  public static String getElapsedTimeInSecs(long startTime, long endTime) {

    long delta = (endTime - startTime) / 1000;

    return String.valueOf(delta);
  }

}
