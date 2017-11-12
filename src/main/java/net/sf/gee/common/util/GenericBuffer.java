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

import java.util.concurrent.ArrayBlockingQueue;

/**
 * The Class GenericBuffer.
 *
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 * @param <E> the element type
 */
public class GenericBuffer<E> {

  private final int capacity = 10;

  private ArrayBlockingQueue<E> queue = null;

  /**
   * Constructor.
   */
  public GenericBuffer() {
    this.queue = new ArrayBlockingQueue<E>(capacity);
  }

  /**
   * Add ever, al least remove older element.
   * 
   * @param element
   */
  public void add(E element) {
    boolean isAdded = queue.offer(element);
    //
    if (!isAdded) {
      // Remove older element
      queue.poll();

      // Insert new element
      queue.offer(element);
    }
  }

  /**
   * Check if buffer is full.
   * 
   * @return {@linkplain java.lang.Boolean}
   */
  public boolean isFull() {
    // is not full
    if (queue.size() < capacity) {
      return false;

    } // is full
    else {
      return true;
    }
  }

  /**
   * Return E[] array from queue.
   */
  @SuppressWarnings("unchecked")
  public E[] toArray() {
    Object[] array = new Object[capacity];

    queue.toArray(array);

    return (E[]) array;
  }

}
