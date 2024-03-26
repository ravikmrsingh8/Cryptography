package org.crypto.hmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class HMACUtilTest {

    @Test
    public void shouldVerifyDataIntegrity() throws NoSuchAlgorithmException, InvalidKeyException {
        String data = "It came to me. My own. My love. My precious. - Gollum";
        String secretKey = "12ka4";
        String actual = HMACUtil.hmac(Algorithm.HMACSHA256,data, secretKey);
        String expected = "b008feac94b61ec504259e245025690a385da8bccbb20f2c8cc29354ccb775c4";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void byteToHexTest() {
        String hexActual = HMACUtil.byteToHex((byte)32);
        String expected = "20";
        Assertions.assertEquals(expected, hexActual);
    }

    @Test
    public void bytesToHexTest() {
        byte[] bytes = new byte[] {0, 1, 2, 3, 4, 18, 20 };
        String actual = HMACUtil.bytesToHex(bytes);
    }
}