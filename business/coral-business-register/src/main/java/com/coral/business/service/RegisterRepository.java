package com.coral.business.service;

import com.coral.business.entity.MerchantUser;
import com.coral.business.entity.WechatInfo;


/**
 *
 * @Author kaifeng
 * @Description //TODO
 * @Date 15:36 2019-08-30
 **/
public interface RegisterRepository {
     boolean saveMerchantUser(MerchantUser merchantUser)throws Exception;
     boolean saveWechatInfo(WechatInfo wechatInfo)throws Exception;
}
