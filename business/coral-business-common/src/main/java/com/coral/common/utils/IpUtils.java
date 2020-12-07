package com.coral.common.utils;

import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 获取IP工具类
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:28 2019-08-30
 **/
@Log4j2
public class IpUtils {
        /**
         * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
         * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
         *
         * @return ip
         */
        public static String getRealIP(HttpServletRequest request) {
            String ip = request.getHeader("x-forwarded-for");
            if (Objects.nonNull(ip) && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                // 多次反向代理后会有多个ip值，第一个ip才是真实ip
                if( ip.indexOf(",")!=-1 ){
                    ip = ip.split(",")[0];
                }
            }
            if (Objects.isNull(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (Objects.isNull(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (Objects.isNull(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (Objects.isNull(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (Objects.isNull(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Real-IP");
            }
            if (Objects.isNull(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            log.info("访问的IP ip: {}", ip);
            return ip;
        }
}
