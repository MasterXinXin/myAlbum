package cn.com.zhang.album;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        test t = new test();
        int[] a = new int[]{2,1,1,2};
        System.out.println(t.rob(a));
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        /**
         * 折叠起来算
         * 12345                        123456
         *       3                    3        4
         *    2     4                 2         5
         *    1     5                 1         6
         */
        int length = nums.length;
        boolean evenFlag = length%2 == 0;
        int roop = evenFlag ? length/2 : length/2 + 1;
        int leftCount = 0;
        int rightCount = 0;
        if(evenFlag){
            for(int i = 0;i < roop;i++){
                if(i%2 == 0){
                    leftCount += nums[i];
                    rightCount += nums[length-1-i];
                }else{
                    rightCount += nums[i];
                    leftCount += nums[length-1-i];
                }
            }
        }else{
            for(int i = 0;i < roop;i++){
                boolean top = false;
                if(i == roop - 1){//到頂
                    top = true;
                }
                if(i%2 == 0){
                    if(top){
                        leftCount += nums[roop-1];
                        continue;
                    }
                    leftCount += nums[i];
                    leftCount += nums[length-1-i];
                }else{
                    if(top){
                        rightCount += nums[roop-1];
                        continue;
                    }
                    rightCount += nums[i];
                    rightCount += nums[length-1-i];
                }
            }
        }
        return leftCount > rightCount ? leftCount : rightCount;
    }
}
