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
package net.sf.gee.common.util.file;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class Base64Util {

  /**
   * Encode.
   *
   * @param input the byte array to convert
   * 
   * @return the byte[]
   */
  public static byte[] encode(byte[] input) {

    // encode
    return Base64.encodeBase64(input);
  }

  /**
   * Encode.
   * 
   * @param input {@linkplain java.lang.String} input to encode
   * @param inputCharset {@linkplain java.nio.charset.Charset} charset of input string
   * 
   * @return byte[]
   */
  public static byte[] encode(String input, Charset inputCharset) {
    return encode(input.getBytes(inputCharset));
  }

  /**
   * Encode. Charset used is UTF-8
   * 
   * @param input {@linkplain java.lang.String} input to encode
   * 
   * @return byte[]
   */
  public static byte[] encode(String input) {
    return encode(input, StandardCharsets.UTF_8);
  }

  /**
   * Encode.
   * 
   * @param input byte[]
   * @param outputCharset {@linkplain java.nio.charset.Charset} string output charset
   * 
   * @return {@linkplain java.lang.String}
   */
  public static String encodeString(byte[] input, Charset outputCharset) {

    // encode in base64
    byte[] base64 = encode(input);

    // encode as string
    return new String(base64, outputCharset);
  }

  /**
   * Encode.
   * 
   * @param input {@linkplain java.lang.String} input to convert
   * @param inputCharset {@linkplain java.nio.charset.Charset} input charset for getBytes() method
   * @param outputCharset {@linkplain java.nio.charset.Charset} output charset
   * 
   * @return {@linkplain java.lang.String} according <code>outputCharset</code>
   */
  public static String encodeString(String input, Charset inputCharset, Charset outputCharset) {

    // encode in base64
    byte[] base64 = encode(input.getBytes(inputCharset));

    // encode as string
    return new String(base64, outputCharset);
  }

  /**
   * Encode as string, input and output charset is UTF-8.
   * 
   * @param input UTF-8 {@linkplain java.lang.String}
   * 
   * @return {@linkplain java.lang.String}
   */
  public static String encodeString(String input) {
    return encodeString(input, StandardCharsets.UTF_8, StandardCharsets.UTF_8);
  }

  /**
   * Decode.
   *
   * @param input to decode.
   * 
   * @return the byte[]
   */
  public static byte[] decode(byte[] base64) {
    return Base64.decodeBase64(base64);
  }

  /**
   * Decode.
   * 
   * @param base64 {@linkplain java.lang.String} input to decode with UTF-8 charset
   * 
   * @return byte[]
   */
  public static byte[] decode(String base64) {
    return decode(base64.getBytes(StandardCharsets.UTF_8));
  }

  /**
   * Decode.
   * 
   * @param base64 {@linkplain java.lang.String} input to decode with <code>charset</code>.
   * @param charset {@linkplain java.nio.charset.Charset} input charset for getBytes() method
   * 
   * @return byte[]
   */
  public static byte[] decode(String base64, Charset charset) {
    return decode(base64.getBytes(charset));
  }

  /**
   * Decode.
   * 
   * @param base64 input to decode
   * @param input {@linkplain java.nio.charset.Charset} input charset for getBytes() method
   * @param output {@linkplain java.nio.charset.Charset} output charset
   * 
   * @return {@linkplain java.lang.String}
   */
  public static String decodeString(String base64, Charset input, Charset output) {
    // decode
    return new String(decode(base64.getBytes(input)), output);
  }

  /**
   * Decode.
   * 
   * @param base64 {@linkplain java.lang.String} input to decode
   * 
   * @return {@linkplain java.lang.String} encoded as UTF-8
   */
  public static String decodeString(String base64) {
    return decodeString(base64, StandardCharsets.UTF_8);
  }

  /**
   * Decode.
   * 
   * @param base64 byte array
   * @param outputCharset {@linkplain java.nio.charset.Charset} output charset
   * 
   * @return {@linkplain java.lang.String} decoded string according output charset
   */
  public static String decodeString(byte[] base64, Charset outputCharset) {
    return new String(decode(base64), outputCharset);
  }

  /**
   * Decode.
   * 
   * @param base64 byte array
   * 
   * @return {@linkplain java.lang.String} decoded UTF-8 string
   */
  public static String decodeString(byte[] base64) {
    return decodeString(base64, StandardCharsets.UTF_8);
  }

  /**
   * Decode.
   * 
   * @param base64 {@linkplain java.lang.String} input to decode
   * @param charset {@linkplain java.nio.charset.Charset} charset for input and output string.
   * 
   * @return {@linkplain java.lang.String} encoded as <code>charset</code>
   */
  public static String decodeString(String base64, Charset charset) {
    return decodeString(base64, charset, charset);
  }

}
