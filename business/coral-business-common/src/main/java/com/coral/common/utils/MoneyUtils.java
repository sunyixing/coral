package com.coral.common.utils;

import java.math.BigDecimal;

/**
 * @ClassName MoneyUtils
 * @Author sunyixing
 * @Date 2019-09-19 21:41
 * @Version 1.0
 */
public class MoneyUtils {

    /**
     * 通过分获取元
     * @param amount
     * @return
     */
    public static BigDecimal getYuanByFen(BigDecimal amount) {

        return amount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 元到分
     * @param fen
     * @return
     */

    public static BigDecimal getYuanByFen(Integer fen) {

        return getYuanByFen(new BigDecimal(fen));
    }

    /**
     * 分到元返回int
     * @param yuan
     * @return
     */
    public static Integer getFenByYuan(BigDecimal yuan) {
        BigDecimal f = yuan.multiply(new BigDecimal(100));

        return f.intValue();
    }
}