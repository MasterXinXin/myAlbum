package cn.com.zhang.album;

import com.alibaba.fastjson.JSON;
import com.asiainfo.appserver.Request;
import com.asiainfo.appserver.Response;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
//        Map m1 = new HashMap();
//        m1.put("ZHOU","ZHOU");
//
//        ReflectTest test = new ReflectTest();
//        test.test2(m1,new Object[]{"1",m1});
//
//        int i = 1;
//        test.change(i);
//        System.out.println(i);

        try{
            Request request = new Request("AnalysisRedisAction");
            request.setParameter("date", "202002241346");
            Response response = MinaClientProvider.getClient(MinaServerMsg.DRIVEN_ENGINE).send(request);
            String respStr = response.getMessage();
            Map resp = JSON.parseObject(respStr,Map.class);
            String receiveStr = (String) resp.getOrDefault("analysisReceive_","");
            String succStr = (String) resp.getOrDefault("analysisSendSuccess_","");
            String failStr = (String) resp.getOrDefault("analysisSendFail_","");
            if(!StringUtils.isBlank(receiveStr)){
                System.out.println(Integer.parseInt(receiveStr));
            }
            if(!StringUtils.isBlank(failStr)){
                System.out.println(Integer.parseInt(failStr));
            }


        }catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("continue");

//        List<List> lists = new ArrayList<>();
//        List dataLists = new ArrayList<Map>();
//        Map data = new HashMap();
//        data.put("a",1);
//        dataLists.add(data);
//        lists.add(dataLists);
//        System.out.println(JSON.toJSONString(lists));
//        String jsonStr = JSON.toJSONString(lists);
//        List<List> newLists = JSON.parseArray(jsonStr,List.class);
//        System.out.println(((Map)newLists.get(0).get(0)).get("a"));
    }



    public void change(int i){
        i = 2;
    }

    public static void test1(Object... o1){
        Map m = (Map)o1[0];
        System.out.println(m.get("ZHOU"));
        System.out.println(((Object[])o1[1])[0]);
        System.out.println(((Map)((Object[])o1[1])[1]).get("ZHOU"));
        System.out.println(getDateKey("zx-","yyyyMMddHHmm"));
    }

    public static void test2(Object... param) throws Exception {
        Class clz= Class.forName("cn.com.zhang.album.ReflectTest");
        Method m = clz.getDeclaredMethod("test1",Object[].class);
        m.invoke(null,new Object[]{param});
    }

    public static String getDateKey(String prefix,String datePattern){
        //key product
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        StringBuffer staticKey = new StringBuffer();
        staticKey.append(prefix)
                .append(sdf.format(Calendar.getInstance().getTime()));
        return staticKey.toString();
    }
}
