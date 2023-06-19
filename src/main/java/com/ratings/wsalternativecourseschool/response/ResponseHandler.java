package com.ratings.wsalternativecourseschool.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> ok(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", "OK");
        map.put("msg", message);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
