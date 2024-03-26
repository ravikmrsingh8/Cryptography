package org.crypto.hmac;

public enum Algorithm {
    HMACMD5("HmacMD5"),
    HMACSHA256("HmacSHA256"),
    HMACSHA384("HmacSHA384"),
    HMACSHA512("HmacSHA512");

    private final String value;

    private Algorithm(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
