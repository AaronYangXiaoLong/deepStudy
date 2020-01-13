package com.hty.wechat.controller;

import com.hty.wechat.utils.WechatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Controller
public class WeChatController {
    @RequestMapping(value = "/wecha", method = RequestMethod.GET)
    @ResponseBody
    public String validate(String signature, String timestamp, String nonce, String echostr) {
        System.out.println("接入失败");
        String[] arr = {WechatUtil.token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String temp : arr) {
            sb.append(temp);
        }
        String mySignature = WechatUtil.getSha1(sb.toString());
        if (mySignature.equals(signature)) {
            System.out.println("接入成功");
            return echostr;
        }
        System.out.println("接入失败");
        return null;
    }
}


