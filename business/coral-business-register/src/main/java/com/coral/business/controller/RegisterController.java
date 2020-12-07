package com.coral.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.coral.business.entity.MerchantUser;
import com.coral.business.entity.WechatInfo;
import com.coral.business.service.RegisterRepository;
import com.coral.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 测试controller
 *
 * @Author sunyixing
 * @Description //TODO
 * @Date 15:08 2019-08-30
 **/
@RestController
@RequestMapping("/business")
public class RegisterController {
    private Logger log = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping("/register.do")
    public R doRegister(@RequestBody MerchantUser merchantUser) throws Exception{
        return R.ok(registerRepository.saveMerchantUser(merchantUser));
    }

    @PostMapping("/saveWechatInfo.do")
    public R saveWechatInfo(@RequestBody WechatInfo wechatInfo) throws Exception{
        return R.ok(registerRepository.saveWechatInfo(wechatInfo));
    }

}
