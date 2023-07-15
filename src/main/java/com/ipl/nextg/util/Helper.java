package com.ipl.nextg.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Helper {

  public static String convertStringToMD5(String md5) {
    try {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
      byte[] array = md.digest(md5.getBytes());
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
      }
      return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
  }

  public static Long getPendingSeconds(LocalDateTime startLocaDateTime)
  {
    return (startLocaDateTime.toEpochSecond(ZoneOffset.of("Z")) - LocalDateTime.now().toEpochSecond(ZoneOffset.of("Z")) );
  }
}
