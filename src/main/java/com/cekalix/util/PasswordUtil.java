package com.cekalix.util;
import java.security.*;import java.util.*;import javax.crypto.SecretKeyFactory;import javax.crypto.spec.PBEKeySpec;
public final class PasswordUtil {
 private PasswordUtil(){} private static final int ITER=210000;
 public static String hash(String password){try{byte[] salt=new byte[16];new SecureRandom().nextBytes(salt);return "pbkdf2$"+ITER+"$"+Base64.getEncoder().encodeToString(salt)+"$"+Base64.getEncoder().encodeToString(derive(password.toCharArray(),salt,ITER));}catch(Exception e){throw new IllegalStateException(e);}}
 public static boolean verify(String password,String stored){if(stored==null)return false;try{if(!stored.startsWith("pbkdf2$"))return MessageDigest.isEqual(password.getBytes(java.nio.charset.StandardCharsets.UTF_8),stored.getBytes(java.nio.charset.StandardCharsets.UTF_8));String[] p=stored.split("\\$");return MessageDigest.isEqual(derive(password.toCharArray(),Base64.getDecoder().decode(p[2]),Integer.parseInt(p[1])),Base64.getDecoder().decode(p[3]));}catch(Exception e){return false;}}
 private static byte[] derive(char[] p,byte[] s,int i)throws Exception{PBEKeySpec spec=new PBEKeySpec(p,s,i,256);try{return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();}finally{spec.clearPassword();}}
}