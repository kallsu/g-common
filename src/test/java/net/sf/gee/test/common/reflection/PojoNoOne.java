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
package net.sf.gee.test.common.reflection;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Giorgio Desideri - giorgio.desideri@gmail.com
 *
 */
public class PojoNoOne implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private Long id = 1L;

  private String name = "tesT_name";

  private Double amount = 1.123D;

  private BigInteger amount2 = BigInteger.TEN;

  /**
   * 
   */
  public PojoNoOne() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public BigInteger getAmount2() {
    return amount2;
  }

  public void setAmount2(BigInteger amount2) {
    this.amount2 = amount2;
  }

}
