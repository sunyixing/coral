package com.coral.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 开发环境枚举类
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:29 2019-08-30
 **/
@AllArgsConstructor
@Getter
public enum EnvironmentEnum {

    DEVELOP("dev", "开发"), TEST("test", "测试"), PRODUCT("prod", "正式");

    private String value;
    private String name;

    /**
     * 判断一个value是否在该enum中
     *
     * @param v
     * @return
     */
    public static boolean contain(String v) {
        boolean flag = false;
        for (EnvironmentEnum environmentEnum : EnvironmentEnum.values()) {
            if (environmentEnum.getValue() == v) {
                flag = true;
                break;
            }
        }

        return flag;
    }


}
