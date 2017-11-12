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
package net.sf.gee.common.util.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang3.ClassUtils;

/**
 * 
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class ReflectionUtil {

  /**
   * Gets the field.
   *
   * @param class class to inspect {@linkplain java.lang.Class}
   * @param fieldName field name {@linkplain java.lang.String}
   * 
   * @return {@linkplain java.lang.reflect.Field} is method found, <code>null</code> otherwise.
   */
  public static Field getField(Class<?> clazz, String fieldName) {

    Field f = null;

    try {
      f = clazz.getDeclaredField(fieldName);
    }
    catch (NoSuchFieldException | SecurityException e) {
      // silent exception
    }

    // test in superclass
    if (f == null) {

      // get in hierarchy
      Class<?> superClass = clazz.getSuperclass();

      // check class
      if (superClass.isInterface() || ClassUtils.isPrimitiveOrWrapper(superClass)
          || superClass.getName().equals(Object.class.getName())) {
        return null;
      }

      // recursive
      return getField(superClass, fieldName);
    }
    else {
      f.setAccessible(true);

      return f;
    }
  }

  /**
   * Gets the value of field, specified by <code>fieldName</code>, inside <code>source</code>
   * object. Need to specify return value <code>returnType</code> to allow reflection mechanisms.
   *
   * Return <code>null</code> if method didn't find field, or field value is null, or exception is
   * raised.
   * 
   * @param <K> type
   * 
   * @param returnType {@linkplain java.lang.Class<K>}
   * @param source source object {@linkplain java.lang.Object}
   * @param fieldName the field name {@linkplain java.lang.String}
   * 
   * @return <K>
   */
  public static <K> K getValue(Class<K> returnType, Object source, String fieldName) {

    try {

      // get filed by name
      final Field field = getField(source.getClass(), fieldName);

      if (field == null) {
        return null;
      }

      // get value
      Object value = field.get(source);

      // check
      if (value == null) {
        return null;
      }

      // cast and return
      return returnType.cast(value);

    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Set the value of field, if field is found.
   * 
   * @param source {@linkplain java.lang.Object} source object
   * @param fieldName field name as {@linkplain java.lang.String}
   * @param value <K>
   */
  public static <K> void setValue(Object source, String fieldName, K value) {

    try {
      // get filed by name
      final Field field = getField(source.getClass(), fieldName);

      // check
      if (field != null) {

        // set value
        field.set(source, value);
      }

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Check if class is a primitive, wrapper, String or array of primitive or String.
   * 
   * Possible return values are:
   * 
   * <pre>
   * 0 - None of below
   * 1 - {@code objectClass} is a primitive
   * 2 - {@code objectClass} is a Java Wrapper, including {@linkplain java.lang.String}, {@linkplain java.math.BigInteger} and {@linkplain java.math.BigDecimal}
   * 3 - {@code objectClass} is a primitive array
   * 4 - {@code objectClass} ia an array
   * 5 - {@code objectClass} is an annotation type
   * 6 - {@code objectClass} is an enumeration type
   * 7 - {@code objectClass} is an interface type
   * </pre>
   * 
   * @param objectClass class to inspect
   * 
   * @return
   */
  public static int getClassType(Class<?> objectClass) {

    // classic primitive
    if (objectClass.isPrimitive()) {
      return 1;

    } // is a wrapper
    else if (Boolean.class.isAssignableFrom(objectClass)
        || Character.class.getName().equals(objectClass.getName())
        || String.class.getName().equals(objectClass.getName())
        || Byte.class.getName().equals(objectClass.getName())
        || Float.class.getName().equals(objectClass.getName())
        || Double.class.getName().equals(objectClass.getName())
        || Long.class.getName().equals(objectClass.getName())
        || Integer.class.getName().equals(objectClass.getName())
        || Short.class.getName().equals(objectClass.getName())
        || BigInteger.class.getName().equals(objectClass.getName())
        || BigDecimal.class.getName().equals(objectClass.getName())
        || Number.class.isAssignableFrom(objectClass)) {
      return 2;

    } // array of primitive
    else if (boolean[].class == objectClass || byte[].class == objectClass
        || char[].class == objectClass || short[].class == objectClass || int[].class == objectClass
        || long[].class == objectClass || float[].class == objectClass
        || double[].class == objectClass) {

      return 3;

    } // is array
    else if (objectClass.isArray()) {
      return 4;

    } // is annotation
    else if (objectClass.isAnnotation()) {
      return 5;

    } // is enumeration
    else if (objectClass.isEnum()) {
      return 6;

    } // is interface
    else if (objectClass.isInterface()) {
      return 7;
    }

    return 0;
  }

  /**
   * Return if class is primitive or Java wrapper. String is included as Java Wrapper.
   * 
   * @param objectClass class to inspect
   * 
   * @return
   */
  public static boolean isPrimitiveOrWrapper(Class<?> objectClass) {

    int type = getClassType(objectClass);

    return (type == 1 || type == 2) ? true : false;
  }

}
