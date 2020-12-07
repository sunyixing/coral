package com.coral.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 返回状态码
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:30 2019-08-30
 **/
@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {
    /**
     * 系统繁忙，此时请开发者稍候再试
     */
    CODE_ERROR(-1, "系统错误"),

    CODE_IP_NOT_ALLOWED(10001, "ip无法访问"),

    CODE_PARAM(10002, "参数错误"),

    CODE_ORDER(10003, "订单已存在"),

    CODE_ORDER_CLOSE(10004, "订单已关闭"),

    CODE_ORDER_NON(10005, "订单不存在"),

    CODE_NOT_LOGIN(20001, "未登入，请登录后重试"),

    CODE_ERROR_PASSWORD(20002, "用户名密码错误"),

    CODE_TOKEN( 21000, "TOKEN获取失败"),

    CODE_COURSE_RECEIVED(30001, "课程已发放"),


    /**
     * 请求成功
     */
    CODE_SUCCESS(0, "success");

    private int code;
    private String msg;

    /**
     * 通过错误代码查找其中文含义.
     */
    public static String findMsgByCode(int code) {
        ErrorMsgEnum[] values = ErrorMsgEnum.values();
        for (ErrorMsgEnum value : values) {
            if (value.code == code) {
                return value.msg;
            }
        }
        return null;
    }
}
