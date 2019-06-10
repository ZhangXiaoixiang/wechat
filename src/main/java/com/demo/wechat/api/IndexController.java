package com.demo.wechat.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * IndexController
 *
 * @author 10905 2019/5/12
 * @version 1.0
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index(String code){//注意这个code是接收微信返回来的code,不要乱命名
        System.out.println("首页");
        return "微信首页";
    }
    //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb7fcef76336bd0ae&redirect_uri=http%3A%2F%2F5af2h5.natappfree.cc/wechatback/getcode&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
    public static void main(String[] args) {
        String url="http://5af2h5.natappfree.cc";
        try {
            String encode = URLEncoder.encode(url, "ISO-8859-1");
            System.out.println(encode);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
