package com.coral.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * json传化工具类
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:26 2019-08-30
 **/
@Log4j2
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * response返回json格式参数
     * @param response
     * @param responseObject
     */
    public static void responseOutWithJson(HttpServletResponse response,
                                           Object responseObject) {
        //将实体对象转换为JSON Object转换
        JSONObject responseJSONObject = (JSONObject) JSON.toJSON(responseObject);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(responseJSONObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    /**
     * 返回json中的String值
     * @param object
     * @param key
     * @return
     */
    public static String getString(Object object, String key){

        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
        return jsonObject.getString(key);
    }

    /**
     * 返回json中的boolean值
     * @param object
     * @param key
     * @return
     */
    public static boolean getBoolean(Object object, String key){

        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
        return jsonObject.getBoolean(key);
    }

    /**
     * 将对象转换成json字符串。
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

}
