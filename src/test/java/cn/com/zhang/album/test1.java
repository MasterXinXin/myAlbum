package cn.com.zhang.album;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class test1 {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap<>();
        map.put("1","你好");
        String s = new JSONObject(map).toString();
        int length = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int ascii = Character.codePointAt(s, i);
            if(ascii >= 0 && ascii <=255)
                length++;
            else
                length += 2;

        }
//        byte[] a = s.getBytes();
//        int length = 0;
//        for(byte b : a){
//            if((int)b > 0 && (int)b <= 255){
//                length++;
//            }else{
//                length += 2;
//            }
//        }
        System.out.println(length);
        System.out.println(getWordCountCode(s,"UTF-8"));
    }

    /*按特定的编码格式获取长度*/
    public static int getWordCountCode(String str, String code) throws UnsupportedEncodingException {
        return str.getBytes(code).length;
    }
}
