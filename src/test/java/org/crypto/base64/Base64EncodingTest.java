package org.crypto.base64;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodingTest {

    @Test
    void shouldReturnEncodedString() {
        String actual1 = Base64.getEncoder().encodeToString("ab@yz".getBytes(StandardCharsets.UTF_8));
        String expected = "YWJAeXo=";
        Assertions.assertEquals(expected, actual1);

        String actual2 = Base64.getEncoder().encodeToString("ab@y".getBytes(StandardCharsets.UTF_8));
        expected = "YWJAeQ==";
        Assertions.assertEquals(expected, actual2);
    }

    @Test
    void shouldReturnEncodedUrl() {
        String input = "https://www.imdb.com/title/tt0167260/?ref_=ttls_li_tt";
        String actual = Base64.getUrlEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
        String expected = "aHR0cHM6Ly93d3cuaW1kYi5jb20vdGl0bGUvdHQwMTY3MjYwLz9yZWZfPXR0bHNfbGlfdHQ=";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnDecodedString() {
        String source = "YWJAeXo=";
        byte[] decodedBytes = Base64.getDecoder().decode(source);
        String actual = new String(decodedBytes);
        String expected = "ab@yz";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnDecodedUrlString() {
        String source = "aHR0cHM6Ly93d3cuaW1kYi5jb20vdGl0bGUvdHQwMTY3MjYwLz9yZWZfPXR0bHNfbGlfdHQ=";
        byte[] decodedBytes = Base64.getUrlDecoder().decode(source);
        String actual = new String(decodedBytes);
        String expected = "https://www.imdb.com/title/tt0167260/?ref_=ttls_li_tt";
        Assertions.assertEquals(expected, actual);
    }
}
