package cn.com.zhang.album;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        String date = "2020-03-25 14:24:44";
//        String date = "20200325142444";
        System.out.println(change(date,"yyyyMMddHHmmss"));
    }

    public static String change(String date,String pattern){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            Date parseDate = sdf.parse(date);
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parseDate);
        }catch (Exception e){
            if("yyyy-MM-dd HH:mm:ss".equals(pattern)){
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            }
            return change(date,"yyyy-MM-dd HH:mm:ss");
        }
    }

}
