package com.coral.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 返回json
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:29 2019-08-30
 **/
public class ResponseJsonUtils {

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
}
