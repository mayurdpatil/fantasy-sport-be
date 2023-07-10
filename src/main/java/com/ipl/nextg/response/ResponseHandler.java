package com.ipl.nextg.response;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,status);
    }


    public static void main(String args[])
    {
        String str = "aabcdcdvdc";
        List<Integer> input = new ArrayList<Integer>();
        List<Integer> output = new ArrayList<Integer>();
        char[] arrstr = str.toCharArray();
        Map<Character, Integer> op = new HashMap<Character, Integer>();

        input.add(1);
        input.add(54);
        input.add(33);
        input.add(32);
        input.add(6);
        for(int i =0; i<str.length(); i++)
        {
            if(op.get(str.charAt(i)) != 0)
            {
                System.out.println(str.charAt(i) + "====>" + op.toString());
            }
        }
        output = input.stream().filter(i -> i%2 == 0).collect(Collectors.toList());


//        System.out.printf(input.toString());
 //       System.out.printf(output.toString());
    }
}