package com.coral.business.service.impl;

import com.coral.business.entity.MerchantUser;
import com.coral.business.entity.WechatInfo;
import com.coral.business.service.IMerchantUserService;
import com.coral.business.service.IWechatInfoService;
import com.coral.business.service.RegisterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:36 2019-08-30
 **/
@Service
@Log4j2
public class RegisterRepositoryImpl implements RegisterRepository {

    @Autowired
    private IMerchantUserService iMerchantUserService;

    @Autowired
    private IWechatInfoService iWechatInfoService;


    public boolean saveMerchantUser(MerchantUser merchantUser) throws Exception{
        return iMerchantUserService.save(merchantUser);
    }

    @Override
    public boolean saveWechatInfo(WechatInfo wechatInfo) throws Exception {
        return iWechatInfoService.save(wechatInfo);
    }


}
