package org.crypto.hmac;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACUtil {
    public static String hmac(Algorithm algorithm, String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), algorithm.getValue());
        Mac mac = Mac.getInstance(algorithm.getValue());
        mac.init(secretKey);
        byte[] bytes = mac.doFinal(data.getBytes());
        return bytesToHex(bytes);
    }

    public static String byteToHex(byte b) {
        char[] hex = new char[2];
        hex[0] = Character.forDigit(b >> 4 & 0xF, 16);
        hex[1] = Character.forDigit(b & 0xF, 16);
        return new String(hex);
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(byteToHex(b));
        }
        return hex.toString();
    }
}
