# Overview
Let’s consider a scenario in which two parties want to communicate, and they need an approach to verify that the messages they receive haven’t been tampered with. 
Hash-based Message Authentication Code (HMAC) is a good solution.

HMAC is a cryptographic method that guarantees <b>the integrity of the message between two parties.</b>

## MAC properties
In essence, a MAC is a cryptographic checksum sent along with a message to assure the receiver of data origin authentication. The basic model of a MAC is shown in the illustration below. 

![image info](/images/HMAC.jpeg)

In this model, the sender and the receiver share a symmetric key K. The MAC takes the message and the key K as input. 
The sender transmits the message accompanied by the MAC. 

<i>Note that we will assume this message is sent clearly since we’re only trying to provide data origin authentication, not confidentiality. If confidentiality is also required, the message will need to be encrypted.
</i>

Upon receiving the message and the MAC, the receiver inputs the received message and the key K into the MAC algorithm and recomputes the MAC. 
The receiver then checks whether this freshly recomputed MAC matches the MAC sent by the sender. If they do match, the receiver accepts the message and regards data origin authentication as being provided.

we will always assume that an attacker knows the MAC algorithm but is unaware of the MAC key.


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