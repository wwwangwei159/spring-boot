package com.train.springmvc.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

    public static String convertJson(Object object){

        ObjectMapper mapper = new ObjectMapper();
        String returnVlue="";
        try {
            returnVlue = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }finally {
            return returnVlue;
        }

    }

}
