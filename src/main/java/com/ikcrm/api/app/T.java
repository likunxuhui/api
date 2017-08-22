package com.ikcrm.api.app;


import com.ikcrm.lib.common.utils.DESUtils;
import com.ikcrm.lib.common.utils.YamlUtils;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/5.
 */
public class T {
    public static void main(String args[]){
        String ss = "token=\"14d1e0acc507932cd7b0a42aa7d6a4a1\",device=\"dingtalk\",version_code=\"3.13.2\"";
        //System.out.print(ss.replace("=","\"=").replace(",",",\""));

//        String authorization = "Token token=\"e7a2b6d43e57b092965b0679e6def57a\",device=\"dingtalk\",version_code=\"3.13.2\"";
//        String arr[] = authorization.split(" ");
//        for(int i = 0;i<arr.length;i++){
//            System.out.println("length:"+arr[i].length()+" data:"+arr[i]+"-->");
//        }

//        String a = "   sdf  adsf   ";
//        a.trim();
//        System.out.println(a.length());
//        System.out.println("截取前："+a.length() +"截取后："+a.trim().length());
//        System.out.print("**"+a.trim()+"**");

//        String path = StringUtils.substringBeforeLast("0/6/836/52", "/");
//        System.out.print(path);
//
//        System.out.println(new Date(System.currentTimeMillis()));
//        String s = new String("");
//        String s1 = "";
//        System.out.println(""==s);
//        System.out.println(""==s1);

//        BigDecimal b1 = new BigDecimal("123.456777753413321231");
//        String result = b1.toString();
//        System.out.println("result = "+result);

        System.out.println(UUID.randomUUID().toString());
        //System.out.println(YamlUtils.parseString(b1));
//        String key = "0002000200020002";
//        String name = "ikcrm123";
//        String result = DESUtils.Encrypt(name,DESUtils.hex2byte(key));
//        System.out.println("加密："+result);
//        result = DESUtils.Decrypt(result, DESUtils.hex2byte(key));
//        System.out.println("解密："+result);
//        List list = new ArrayList();
//        list.add(1);
//        Map map = new HashMap();

//        int h=3;
//        System.out.print(h >>> 16);
//        int i = 0;
//        while (i<10){
//            i++;
//            System.out.println("i:"+i);
//        }
        Map map = new HashMap();

        for(int i = 1;i<100;i++){
            map.put(i,i);
        }

    }
}
