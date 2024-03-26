# Overview
Let’s consider a scenario in which two parties want to communicate, and they need an approach to verify that the messages they receive haven’t been tampered with. 
Hash-based Message Authentication Code (HMAC) is a good solution.

HMAC is a cryptographic method that guarantees <b>the integrity of the message between two parties.</b>

HMAC algorithm consists of a <b>secret key</b> and a <b>hash function</b>. The secret key is a unique piece of information or a string of characters. It is known both by the sender and the receiver of the message.

The hash function is a mapping algorithm that converts one sequence to another sequence.

![image info](/images/hmac-in-java.webp)

## HMAC in Java

Example can be found [/src/main/java/org/crypto/hmac/HMACUtil.java](/src/main/java/org/crypto/hmac/HMACUtil.java)
and tests at [/test/java/main/java/org/crypto/hmac/HMACUtil.java](/test/java/main/java/org/crypto/hmac/HMACUtil.java)  
```java
public static String hmac(String algorithm, String data, String key)
  throws NoSuchAlgorithmException, InvalidKeyException {
    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
    Mac mac = Mac.getInstance(algorithm);
    mac.init(secretKeySpec);
    return bytesToHex(mac.doFinal(data.getBytes()));
}
```