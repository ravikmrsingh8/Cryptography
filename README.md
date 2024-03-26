# Cryptography

The Java Cryptography API enables us to encrypt and decrypt data in Java, as well as manage keys, sign and authenticate messages, calculate cryptographic hashes and much more.

## Java Cryptography Architecture
The Java Cryptography Architecture (JCA) is the name for the internal design of the Java cryptography API.

JCA is structured around some central general purpose classes and interfaces. The real functionality behind these interfaces are provided by providers. 
Thus, you may use a Cipher class to encrypt and decrypt some data, but the concrete cipher implementation (encryption algorithm) depends on the concrete provider used.

You can implement and plugin your own providers too, but you should be careful with that. Implementing encryption correctly without security holes is hard! Unless you know what you are doing, you are probably better off using the builtin Java provider, or use a well established provider like Bouncy Castle.

## Code Examples
1. Java Ciphers
2. Java Message Digest
3. [Java MAC](/hmac)
4. Java Signature

## Misc
1. [Base 64 Encoding](/base64-encoding.md)

