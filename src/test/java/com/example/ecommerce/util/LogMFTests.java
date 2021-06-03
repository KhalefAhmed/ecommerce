package com.example.ecommerce.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogMFTests {

    @Test
    public void test_format(){
        String message = LogMF.format("myMethod", "My Message", "MyObject", "My Value");
        //String expectedJson = "{ \"method\" : \"myMethod\", \"message\": \"My Message\", { \"java.lang.String\" : {\"MyObject\" : \"My Value\" } }";
        String expected = "method=[myMethod] message=[My Message] object=[java.lang.String] MyObject=[My Value]";

        assertEquals(expected, message);
    }
}
