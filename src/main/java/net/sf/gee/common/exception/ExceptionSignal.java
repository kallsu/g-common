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
 * The Enum ExceptionSignal.
 *
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 */
public enum ExceptionSignal implements GBaseCode {

  /** The connection error. */
  CONNECTION_ERROR(1),

  /** The connection timeout error. */
  CONNECTION_TIMEOUT_ERROR(2),

  /** The connection trasmission error. */
  CONNECTION_TRASMISSION_ERROR(3),

  /** The database error. */
  DATABASE_ERROR(4),

  /** The persistence error. */
  PERSISTENCE_ERROR(5),

  /** The service error. */
  SERVICE_ERROR(6),

  /** The business service error. */
  BUSINESS_SERVICE_ERROR(7),

  /** The xml render error. */
  XML_GENERIC_ERROR(8),

  /** The xml parse error. */
  XML_PARSE_ERROR(9),

  /** The xml render error. */
  XML_RENDER_ERROR(10),

  /** The wrong data error. */
  INPUT_DATA_GENERIC_ERROR(11),

  /** The input data syntax error. */
  INPUT_DATA_SYNTAX_ERROR(12),

  /** The input data semantic error. */
  INPUT_DATA_SEMANTIC_ERROR(13),

  ;

  /** The code. */
  private int code = -1;

  /**
   * Instantiates a new exception signal.
   *
   * @param code the code
   */
  private ExceptionSignal(int code) {
    this.code = code;
  }

  /**
   * Gets the code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

  @Override
  public boolean isError() {
    return true;
  }
}
