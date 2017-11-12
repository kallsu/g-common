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
package net.sf.gee.common.util.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Giorgio Desideri - giorgio.desideri@gmail.com
 *
 */
public class ListUtil {

  /**
   * Private constructor
   */
  private ListUtil() {
    super();
  }

  /**
   * Remove <code>null</code> elements from inputList.
   * 
   * @param <T>
   * @param inputList {@linkplain java.util.List<T>}
   */
  public static <T> void removeNulls(final List<T> inputList) {

    inputList.removeAll(Collections.singleton(null));
  }

  /**
   * Remove duplicates from the inputList.
   * 
   * @param <T>
   * @param inputList {@linkplain java.util.List<T>}
   * 
   * @return {@linkplain java.util.List<T>}
   */
  public static <T> List<T> removeDuplicates(List<T> inputList) {
    return inputList.parallelStream().distinct().collect(Collectors.toList());
  }

  /**
   * Convert a list or array of values into a list.
   * 
   * @param values array values of <T>
   * 
   * @return {@linkplain java.util.List<T>}
   */
  public static <T> List<T> toList(T[] values) {

    if (values == null || values.length == 0) {
      return new ArrayList<>(0);
    }

    return Arrays.asList(values);
  }

  /**
   * Convert from list to array
   * 
   * @param list {@linkplain java.util.List<T>}
   * 
   * @return T[]
   */
  @SuppressWarnings("unchecked")
  public static <T> T[] toArray(List<T> list) {

    if (list == null) {
      return null;
    }

    T[] array = (T[]) new Object[list.size()];
    return list.toArray(array);
  }
}
