package cn.com.zhang.album;

import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import java.io.File;

public class excelTest2 {
    public static void main(String[] args) throws Exception {
        String copyName = "中国移动海南公司消息中心COSMIC拆分表（第二版）.xls";
        String fileName = "test2.xls";
        String path = "C:/Users/zhouxin/Desktop/test/";
        Workbook copyBook =Workbook.getWorkbook(new File(path+copyName));
        // 创建写工作簿对象
        WritableWorkbook workbook = Workbook.createWorkbook(new File(path+fileName));
        // 工作表
        WritableSheet sheet = workbook.createSheet("功能点拆分表", 0);
        // 设置字体;
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 11, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat cellFormat = new WritableCellFormat(font);
        sheet.setColumnView(0, 37);
        sheet.setColumnView(1, 27);
        sheet.setColumnView(2, 31);
        sheet.setColumnView(3, 17);
        sheet.setColumnView(4, 22);
        sheet.setColumnView(5, 47);
        // 设置背景颜色;
//        cellFormat.setBackground(Colour.WHITE);
        // 设置边框;
        cellFormat.setBorder(Border.ALL, BorderLineStyle.DASH_DOT);
        // 设置文字居中对齐方式;
        cellFormat.setAlignment(Alignment.CENTRE);
        // 设置垂直居中;
        cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        // 设置自动换行;
        cellFormat.setWrap(true);
        WritableSheet sheet1 = (WritableSheet) copyBook.getSheet(0);
        for(int row = 830;row < 838;row++){
            for(int cel = 0;cel < 6;cel++){
                WritableCell cell1 = sheet1.getWritableCell(row,cel);
                sheet.addCell(cell1);
            }
        }

        //开始执行写入操作
        workbook.write();
        //关闭流
        copyBook.close();
        workbook.close();
    }
}
