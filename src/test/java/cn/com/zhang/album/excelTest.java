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

public class excelTest {
    public static void main(String[] args) throws Exception {
        String fileName = "test2.xls";
        String path = "C:/Users/zhouxin/Desktop/test/"+fileName;
        File name = new File(path);
        // 创建写工作簿对象
        WritableWorkbook workbook = Workbook.createWorkbook(name);
        // 工作表
        WritableSheet sheet = workbook.createSheet("功能点拆分表", 0);
        WritableCellFormat cellFormat = initEnv(sheet);
        String[] params = getParam();
        for(int i = 0,line = 0;i < params.length;i++){
            line = createOne(sheet,cellFormat,getOneData(params[i]),line);
        }
        //开始执行写入操作
        workbook.write();
        //关闭流
        workbook.close();
    }

    public static WritableCellFormat initEnv(WritableSheet sheet) throws Exception {
        // 设置字体;
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 11, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
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
        cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
        // 设置文字居中对齐方式;
        cellFormat.setAlignment(Alignment.CENTRE);
        // 设置垂直居中;
        cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        // 设置自动换行;
        cellFormat.setWrap(true);

        return cellFormat;
    }

    public static String[][] getOneData(String param){
        String[] row0 = new String[]{param+"消息接入",param+"消息接入到消息中心","输入"+param+"消息报文","E",param+"消息报文日志信息",param+"工单id,消息id，消息内容，消息报文，消息状态，消息创建时间"};
        String[] row1 = new String[]{param+"消息接入",param+"消息接入到消息中心","规整"+param+"消息数据","R",param+"信息",param+"信息id,用户id,用户编码,用户开户json内容"};
        String[] row2 = new String[]{param+"消息接入",param+"消息接入到消息中心","消息中心记录"+param+"消息日志","W",param+"返回信息","消息报文编码，"+param+"id,"+param+"编码，"+param+"内容，消息id,消息类型，消息内容，创建时间"};
        String[] row3 = new String[]{param+"消息接入",param+"消息接入到消息中心","校验"+param+"消息内容","R",param+"规则内容",param+"id,"+param+"编码,"+param+"内容，规则编码，规则ID，规则内容"};
        String[] row4 = new String[]{param+"消息接入",param+"消息接入到消息中心",param+"事件判断","R",param+"事件信息","规则编码，"+param+"编码，"+param+"报文，消息报文，消息编码，事件id,事件规则"};
        String[] row5 = new String[]{param+"消息接入",param+"消息接入到消息中心","推送"+param+"报文给订阅者","W","订阅者关联"+param+"报文信息","订阅者编码，订阅者id,消息报文，"+param+"id"};
        String[] row6 = new String[]{param+"消息接入",param+"消息接入到消息中心","消息中心记录"+param+"消息日志","W","消息报文"+param+"反馈信息","消息报文编码，"+param+"id,"+param+"编码，"+param+"内容，消息id,消息类型，消息内容，创建时间"};
        String[] row7 = new String[]{param+"消息接入",param+"消息接入到消息中心","返回"+param+"消息中心报文","X","消息报文"+param+"结果信息","消息编码，消息id,"+param+"编码，消息"+param+"成功标识"};
        String[][] data = new String[][]{row0,row1,row2,row3,row4,row5,row6,row7};
        return data;
    }

    public static int createOne(WritableSheet sheet,WritableCellFormat cellFormat,String[][] data,int lineNum) throws Exception {
        int dataRow = data.length;
        for(int row = 0;row < dataRow;row++){
            for(int cel = 0;cel < data[row].length;cel++){
                Label label = new Label(cel,lineNum+row, data[row][cel], cellFormat);
                sheet.addCell(label);
            }
        }
        sheet.mergeCells(0,lineNum,0,lineNum+dataRow-1);//第一列全部合并
        sheet.mergeCells(1,lineNum,1,lineNum+dataRow-1);
        return lineNum+data.length;//行数下标
    }

    public static String[] getParam(){
        String[] params = new String[]{
                "用户开户",
                "过户",
                "宽带开户",
                "宽带完工确认",
                "用户宽带移机",
                "宽带资费变更",
                "宽带账号变更",
                "宽带暂停恢复",
                "宽带密码变更",
                "用户宽带拆机",
                "宽带开户回单",
                "产品变更",
                "宽带拆机",
                "宽带过户",
                "宽带产品变更",
                "宽带续签订单拆分",
                "产品变更工单",
                "宽带付费关系变更",
                "宽带帐号变更",
                "智能设备受理--换光猫",
                "上门服务",
                "服务变更",
                "PCC变更",
                "宽带营销活动",
                "宽带开户",
                "宽带续签原资费",
                "宽带续签订单拆分",
                "营销活动工单",
                "局方开机",
                "宽带营销活动特殊终止",
                "代理商开机",
                "新互联网电视暂停恢复",
                "新互联网电视订购",
                "新互联网电视退订",
                "新互联网电视换机",
                "特殊开机",
                "垃圾彩信开机",
                "IMS暂停恢复",
                "报停",
                "挂失",
                "报开",
                "局方停机",
                "特殊停机",
                "垃圾彩信停机",
                "解约副号码",
                "补卡",
                "换卡",
                "携入方申请取消",
                "携出方申请取消",
                "行车卫士服务订购与退订",
                "行车卫士服务变更",
                "资费参数变更",
                "修改优惠生效时间",
                "小额积分兑奖",
                "小额支付积分扣减",
                "4G整合业务",
                "小额支付",
                "省内异地再入网受理",
                "普通付费关系变更",
                "家庭统付服务",
                "集团承载个人业务订购",
                "集团承载个人业务退定",
                "集团承载个人业务变更",
                "集团承载个人业务暂停",
                "集团承载个人业务恢复",
                "机卡分离特殊停机",
                "省内异地再入网预受理",
                "高级付费关系变更",
                "高级付费关系取消",
                "营销活动积分电子码兑换",
                "终端预约登记",
                "云南省项目投资评审中心实名查询",
                "封顶退费恢复计费",
                "跨区补卡",
                "跨区补卡收费",
                "改号预受理关联号码审核",
                "营销活动转赠",
                "改号预受理审核",
                "改号新号码激活",
                "改号原号码激活资费归零",
                "改号新号码取消关联关系",
                "改号原号码取消关联关系",
                "五星客户生日回馈",
                "优惠业务",
                "优惠取消业务",
                "家庭短号服务",
                "优惠有效期增长业务",
                "号码归属地告知完工流程",
                "预约销户",
                "世博会门票预定付款",
                "手机支付账户预存款",
                "正式销户",
                "生日免单",
                "全球通生日免单",
                "立即销户",
                "老BOSS中开户的专线用户销户",
                "测试卡到期自动销户",
                "离网关怀",
                "批量销户（手工）",
                "铁通197开户",
                "铁通197产品变更",
                "铁通197注销",
                "197报停",
                "197报开",
                "卡类录入",
                "跨区销户",
                "客户开户",
                "神州行转轻松卡",
                "无线宽带开户",
                "无线宽带暂停恢复",
                "无线宽带密码变更",
                "神州行转轻松卡取消",
                "主动账期变更",
                "被动账期变更",
                "手机置换录入",
                "同客户信息处理",
                "点餐式合约计划",
                "客户资料查询",
                "客户信息查询",
                "一键检查修复",
                "集团用户使用人登记",
                "无线宽带销户",
                "无线宽带产品变更",
                "无线宽带付费关系变更",
                "取消托收",
                "支付宝签约预警",
                "刮刮卡员工激励电子券兑奖",
                "代收房屋租金",
                "预存话费",
                "营业外收入—违约金",
                "集客大厅订购商品",
                "集客大厅商品暂停",
                "集客大厅商品恢复",
                "集客大厅修改商品资费",
                "集客大厅修改订购商品组成关系",
                "集客大厅产品订购",
                "集客大厅产品暂停",
                "集客大厅产品恢复",
                "集客大厅修改产品资费",
                "集客大厅成员删除",
                "集客大厅成员增加",
                "集客大厅成员类型变更",
                "集客大厅成员暂停",
                "集客大厅成员恢复",
                "集客大厅成员激活",
                "集客大厅成员扩展属性变更",
                "集客大厅成员修改订购产品属性",
                "预约购机资料处理",
                "用户购机资料处理",
                "网龄优惠自动调整",
                "营销活动",
                "营销活动(会员日)",
                "购机取消业务",
                "刮刮卡免填单打印",
                "异地营销活动",
                "神州行大众卡购机",
                "集团营销活动",
                "集团营销活动转帐成员",
                "营销活动违约金业务",
                "停机保号挂失停机活动延期",
                "社会渠道换机",
                "亲情业务",
                "家庭畅想",
                "IP直通车业务",
                "营销活动延期",
                "营销活动合约活动时间变更",
                "客户密码变更",
                "高额半停机",
                "垃圾短信半停机",
                "高额停机",
                "垃圾短信停机",
                "企业和目停机",
                "企业和目复机",
                "特殊资料修改",
                "骚扰电话半停机",
                "欠费催费",
                "欠费半停机",
                "欠费停机",
                "欠费预销号",
                "欠费销号",
                "集团欠费销号",
                "预约销号-用户资料",
                "预约销号-用户状态",
                "预约销号-撤销",
                "预约销号-挂起工单",
                "非实名半停机",
                "非实名停机",
                "非实名预销号",
                "非实名销号",
                "缴费开机",
                "缴费复机",
                "高额开机",
                "信用特殊开机",
                "信用特殊停机",
                "关联开机",
                "关联半停机",
                "关联停机",
                "高额停机",
                "高额半停机",
                "批量开机"
        };
        return params;
    }

}
