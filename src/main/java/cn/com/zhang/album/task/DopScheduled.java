package cn.com.zhang.album.task;

import com.asiainfo.appserver.Request;
import com.asiainfo.appserver.Response;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class DopScheduled {
    private int count=0;

//    @Scheduled(cron = "0 0/1 * * * ? ")
    @Scheduled(cron = "*/1 * * * * ?")
    public void analysisRedisData() {
        try{
            System.out.println("1");
            //获得前一分钟
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE,-1);
            String date = sdf.format(c.getTime());

            Request request = new Request("AnalysisRedisAction");
            request.setParameter("date", date);
            Response response = MinaClientProvider.getClient(MinaServerMsg.DRIVEN_ENGINE).send(request);
            if(response.isSuccess()){
                //将Redis数据入库
            }
        }catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
