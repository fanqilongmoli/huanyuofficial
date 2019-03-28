package com.huanyu.huanyuofficial.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.vo.ErrorResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    public static void writeResponse(Object value) throws IOException {
        writeResponse(value, HttpServletResponse.SC_OK);
    }

    public static void writeResponse(Object value, int status) throws IOException {
        if ( ! (value instanceof String) ) {
            value = serialize(value);
        }
        HttpServletResponse response = ServletUtil.currentResponse();
        response.setStatus(status);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setResponseCode(status);
        baseResponse.setResponseMsg(((String) value));
        response.getWriter().print(serialize(baseResponse));
    }

    public static void writeErrorResponse(String code, List<String> errors, int status) throws IOException {
        ErrorResult result = new ErrorResult();
        result.setErrors(errors);
        result.setCode(code);
        writeResponse(result, status);
    }

    public static String serialize(Object value) {
        ObjectMapper objectMapper = SpringContextHolder.getBean(ObjectMapper.class);
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T deserialize(String json, Class<T> clazz) {
        ObjectMapper objectMapper = SpringContextHolder.getBean(ObjectMapper.class);
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
