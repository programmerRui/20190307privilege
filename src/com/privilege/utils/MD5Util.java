package com.privilege.utils;

import com.mchange.util.Base64Encoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
    private static String utils="!";
    public static String MD5Encoding(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //初始化MD5
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //创建base64位的编码格式
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密
        pass=utils+pass;
       String encode= base64Encoder.encode(md5.digest(pass.getBytes("utf-8")));
        return encode;
    }
}
