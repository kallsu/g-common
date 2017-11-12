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
package net.sf.gee.common.util.system;

import java.text.NumberFormat;

/**
 * The Class SystemUtils.
 *
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 */
public final class SystemUtils {

  /**
   * Gets the system stats.
   *
   * @return the system stats
   */
  public static String getSystemStats() {
    Runtime runtime = Runtime.getRuntime();

    NumberFormat format = NumberFormat.getInstance();

    StringBuilder sb = new StringBuilder();
    long maxMemory = runtime.maxMemory();
    long allocatedMemory = runtime.totalMemory();
    long freeMemory = runtime.freeMemory();

    sb.append("\nFree memory (in bytes): ").append(format.format(freeMemory));
    sb.append("\nAllocated memory (in bytes): ").append(format.format(allocatedMemory));
    sb.append("\nMax memory (in bytes): ").append(format.format(maxMemory));
    sb.append("\nTotal Free memory (in bytes): ")
        .append(format.format((freeMemory + (maxMemory - allocatedMemory))));

    return sb.toString();
  }

}
