package cn.com.zhang.album;

public class TestPub {
    class person{
        protected int age = 1;
    }
    class zhouxin extends person{
        protected void change(){
            this.age = 3;
        }
    }
    public static void main(String[] args) throws Exception {
        TestPub test = new TestPub();
        zhouxin zx = test.new zhouxin();
        zx.change();
        System.out.println(zx.age);
    }
}
