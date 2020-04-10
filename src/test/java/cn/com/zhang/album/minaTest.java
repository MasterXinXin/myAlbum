package cn.com.zhang.album;

import com.alibaba.fastjson.JSON;
import com.asiainfo.appserver.Request;
import com.asiainfo.appserver.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class minaTest {
    public static void main(String[] args) {
        try{
            Request request = new Request("TestMinaAction");
            request.setParameter("key", "analysisReceive_202002271346");
            request.setParameter("data", "1");
            Response response = MinaClientProvider.getClient(MinaServerMsg.DRIVEN_ENGINE).send(request);
            System.out.println(response.getMessage());
        }catch (Exception e) {
            System.out.println("error");
        }
    }
}
