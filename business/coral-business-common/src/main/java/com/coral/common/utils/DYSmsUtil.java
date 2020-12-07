package com.coral.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 阿里云短信工具类
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:26 2019-08-30
 **/
public class DYSmsUtil {

    // 产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "";
    // 产品域名,开发者无需替换
    private static final String domain = "";
    //
    private static final String accessKeyId = "";
    //
    private static final String accessKeySecret = "";


    private static SendSmsResponse sendSms(String phone, String tempCode, String tempParam) throws Exception {

        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(phone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("890新商学");
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(tempCode);
        // 可选:模板中的变量替换JSON串,如{"code":"1111"}
        request.setTemplateParam(tempParam);

        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        return acsClient.getAcsResponse(request);
    }

    /**
     * 好医生发送短信
     * @param phone
     * @param name
     * @param tempCode
     * @return
     * @throws Exception
     */
    public static SendSmsResponse sendDoctorSms(String phone, String name, String tempCode) throws Exception {

        JSONObject jo = new JSONObject();
        jo.put("name", name);
        String tempParam = jo.toJSONString();

        return sendSms(phone, tempCode, tempParam);
    }

    /**
     * 陕西移动发送短信
     * @param phone
     * @param name
     * @param tempCode
     * @return
     * @throws Exception
     */
    public static SendSmsResponse sendShanxiMobileSms(String phone, String name, String date,String tempCode) throws Exception {

        JSONObject jo = new JSONObject();
        jo.put("date",date);
        jo.put("name", "\""+name+"\"");
        String tempParam = jo.toJSONString();
        return sendSms(phone, tempCode, tempParam);
    }

    /**
     * 发送不带参数的短信
     * @param phone
     * @param tempCode
     * @return
     * @throws Exception
     */
    public static SendSmsResponse sendSms(String phone, String tempCode) throws Exception {
        return sendSms(phone, tempCode, "");
    }

}
