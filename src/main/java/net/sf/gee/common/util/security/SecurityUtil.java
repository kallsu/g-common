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
package net.sf.gee.common.util.security;

import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Giorgio Desideri giorgio.desideri@gmail.com
 *
 */
public class SecurityUtil {


  /**
   * Random.
   *
   * @return the random int
   */
  public static int random() {
    SecureRandom sr = new SecureRandom();
    int randomNum = sr.nextInt();

    return randomNum;
  }

  /**
   * Random.
   *
   * @param seed the seed for random generation
   * 
   * @return the random int
   */
  public static int random(byte[] seed) {
    SecureRandom sr = new SecureRandom(seed);
    int randomNum = sr.nextInt();

    return randomNum;
  }


  /**
   * Random.
   *
   * @param min the min
   * @param max the max
   * @return the int
   */
  public static int random(int min, int max) {
    SecureRandom sr = new SecureRandom();
    int randomNum = sr.nextInt((max - min) + 1) + min;

    return randomNum;
  }

  /**
   * Digest AES-256-CBC.
   *
   * @param message the message
   * @param secretKey the secret key
   * @param salt the salt
   * 
   * @return byte array of AES-256-cbc message encrypted, if error occurs string is
   *         <code>null</code>
   */
  public static byte[] digestAES256(byte[] message, byte[] secretKey, byte[] salt) {

    try {
      final MessageDigest md = MessageDigest.getInstance("SHA-256");
      final byte[] key = md.digest(secretKey);
      final Key skey = new SecretKeySpec(key, "AES");

      final AlgorithmParameterSpec spec = new IvParameterSpec(salt);

      final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, skey, spec);

      return cipher.doFinal(message);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Creates the salt.
   *
   * @param message the message as byte array
   * 
   * @return the byte[]
   */
  public static byte[] createSalt(byte[] message) {

    SecureRandom sr = null;

    // empty string
    if (message == null || message.length == 0) {
      sr = new SecureRandom();

    }
    else {
      // use message as seed
      sr = new SecureRandom(message);
    }

    // generate salt
    final byte[] array = new byte[16];
    sr.nextBytes(array);

    return array;
  }

  /**
   * Generate a random string by alphabet of maximum length.
   * 
   * @param alphabet char array to use as alphabet to pick-up random chars.
   * @param maxLength maximum length of generated string
   * 
   * @return {@linkplain java.lang.String} random string generated. If alphabet is null or empty, it
   *         returns an empty string.
   */
  public static String generateRandomString(char[] alphabet, int maxLength) {

    if (alphabet == null || alphabet.length < 1) {
      return "";
    }

    final SecureRandom sr = new SecureRandom();
    final StringBuffer buffer = new StringBuffer();

    int max = alphabet.length - 1;
    int min = 1;

    // iterate
    for (int i = 0; i < maxLength; i++) {
      // get a random index
      int randomNum = sr.nextInt((max - min) + 1) + min;

      // append
      buffer.append(alphabet[randomNum]);
    }

    return buffer.toString();
  }

  /**
   * Generate a random string of specific length. The alphabet used is :
   * {@code "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789".toCharArray();}
   * 
   * @param maxLength maximum length of generated string
   * 
   * @return {@linkplain java.lang.String} random string generated. If alphabet is null or empty, it
   *         returns an empty string.
   */
  public static String generateRandomString(int maxLength) {

    final String al = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";

    return generateRandomString(al.toCharArray(), maxLength);
  }

}
