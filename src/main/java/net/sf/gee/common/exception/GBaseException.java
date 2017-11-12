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
package net.sf.gee.common.exception;

/**
 * The Class GBaseException.
 *
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 */
public abstract class GBaseException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Coding error message as UNIX code signals.
   * 
   * This improve the meaning of exception
   */
  private GBaseCode signal;

  /**
   * Constructor with message and signal code.
   * 
   * @param signal {@link net.sf.gee.common.exception.GBaseCode}
   * @param message error message
   */
  public GBaseException(GBaseCode signal, String message) {
    super(message);

    this.signal = signal;
  }

  /**
   * Constructor with cause of error and signal code.
   * 
   * @param signal {@link net.sf.gee.common.exception.GBaseCode}
   * @param cause {@linkplain java.lang.Throwable}
   */
  public GBaseException(GBaseCode signal, Throwable cause) {
    super(cause);

    this.signal = signal;
  }

  /**
   * Constructor with cause of error, error message and signal code.
   * 
   * @param signal {@link net.sf.gee.common.exception.GBaseCode}
   * @param message error message
   * @param cause {@linkplain java.lang.Throwable}
   */
  public GBaseException(GBaseCode signal, String message, Throwable cause) {
    super(message, cause);

    this.signal = signal;
  }

  /**
   * Gets the signal.
   *
   * @return the signal
   */
  public final GBaseCode getSignal() {
    return signal;
  }

}
