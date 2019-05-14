package com.demo.wechat.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 微信接口配置需要的一个接口
 */
@RequestMapping("/wechatback")
@RestController
public class WechatController {
    private static String WECHAT_TOKEN = "wx_oms";
    @RequestMapping(value = "/test")
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("========微信访问我们本地的WechatController了========= ");
        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            String log = "name =" + name + "     value =" + value;
        }
        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串
        PrintWriter out = response.getWriter();
        out.print(echostr);
        out.close();

    }

    /**
     * 通过get请求,按照微信公众号开发文档来就行
     * 比如:
     * 获取code可以进行获取其他重要参数的操作,这是基本参数的获取
      * @param code
     * @return
     */
    @RequestMapping("/getcode")
    public String getCode(String code){//注意这个code是接收微信返回来的code,不要乱命名
        System.out.println("微信返回来的code\n"+code);
        return "微信返回来的code:  "+code;
    }




}