package com.coral.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 通过id获取bean
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:26 2019-08-30
 **/
@Component
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        BeanUtils.applicationContext = applicationContext;
    }

    /**
     * 得到Spring 上下文环境
     * 
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 通过Spring Bean name 得到Bean
     * 
     * @param name bean 上下文定义名称
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T)applicationContext.getBean(name);
    }

    /**
     * 通过类型得到Bean
     * 
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return (T)applicationContext.getBean(clazz);
    }

    private static void checkApplicationContext() {
        if (Objects.isNull(applicationContext)) {
            throw new IllegalStateException("applicaitonContext未注入,请在application-context.xml中定义SpringContextHolder");
        }
    }

}
