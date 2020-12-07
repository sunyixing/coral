package com.coral.business.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商家用户表
 * </p>
 *
 * @author kaifeng
 * @since 2019-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cr_merchant_user")
public class MerchantUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家id
     */
    private String merchantId;

    /**
     * 商家名称
     */
    private String merchantName;

    /**
     * 商家的收款信息
     */
    private String billingMessage;

    /**
     * 商家的地址
     */
    private String merchantAddr;

    /**
     * 联系方式
     */
    private Integer phone;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 二维码ID
     */
    private String qrCodeId;

    /**
     * 微信用户唯一标识
     */
    private String openid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
