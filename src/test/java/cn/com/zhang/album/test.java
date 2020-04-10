package cn.com.zhang.album;

import javafx.util.Pair;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {
//        test t = new test();
//        String[] s = new String[]{"abab","aba",""};
//        int[] nums = new int[]{7,1,5,3,6,4};
//        int[][] erwei = new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
//        int [] i = new int[]{-1};
//        String ss = "RLRRLLRLRL";
//        ListNode t1 = new ListNode(1);
//        ListNode t2 = new ListNode(1);
//        t1.next = t2;
//        System.out.println(t.balancedStringSplit(ss));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        String time = "2020-04-07 14:27:00";
        Date times = sdf.parse(time);
        long diff = now.getTime() - times.getTime();
        System.out.println(diff);
        long second = diff/1000;
        System.out.println(second);
        int out = 10;
        if(second > out){
            System.out.println("out");
        }
//        c.add(Calendar.MINUTE,30);
//        String suffix = sdf.format(c.getTime());
//        System.out.println(suffix);
//        Date suffixDate = sdf.parse(suffix);
//        sdf.applyPattern("yyyy-MM-dd HH:mm");
//        String newStr = sdf.format(suffixDate);
//        System.out.println(newStr);
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
         * 考虑所有可能的抢劫方案过于困难。一个自然而然的想法是首先从最简单的情况开始。记：
         *
         * f(k) = 从前 k 个房屋中能抢劫到的最大数额，A_iA
         * i
         * ​
         *   = 第 i 个房屋的钱数。
         *
         * 首先看 n = 1 的情况，显然 f(1) = A_1A
         * 1
         * ​
         *  。
         *
         * 再看 n = 2，f(2) = max(A_1A
         * 1
         * ​
         *  , A_2A
         * 2
         * ​
         *  )。
         *
         * 对于 n = 3，有两个选项:
         *
         * 抢第三个房子，将数额与第一个房子相加。
         *
         * 不抢第三个房子，保持现有最大数额。
         *
         * 显然，你想选择数额更大的选项。于是，可以总结出公式：
         *
         * f(k) = max(f(k – 2) + A_kA
         * k
         * ​
         *  , f(k – 1))
         *
         * 我们选择 f(–1) = f(0) = 0 为初始情况，这将极大地简化代码。
         *
         * 答案为 f(n)。可以用一个数组来存储并计算结果。不过由于每一步你只需要前两个最大值，两个变量就足够用了。
         */
        int prevMax = 0;//上上次  初始为0
        int currMax = 0;//上次
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * 注意：整数顺序将表示为一个字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-and-say
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n < 1){//初始化1
            return "1";
        }
        String temp = countAndSay(--n);
        if(0==n){
            return temp;
        }
        //count(m)|m
        char[] chars = temp.toCharArray();
        char curr;
        char prev = chars[0];
        int currCount = 0;
        StringBuilder rusult = new StringBuilder();
        for(int i = 0;i < chars.length;i++){
            curr = chars[i];
            if(prev == chars[i]){
                currCount++;
            }else{
                rusult.append(currCount).append(chars[i-1]);
                currCount = 1;
            }
            prev = curr;
            if(i == chars.length - 1){
                rusult.append(currCount).append(chars[i]);
            }
        }
        return rusult.toString();
    }

    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int mySqrt(int x) {
        //都用double，int和float会过不了大数值测试
        //极限上下界
        double offset = 0.05f;
        //跳跃点
        double point = x;
        //跳跃上界
        double r = x;
        //跳跃下界
        double l = 0;
        while (true) {
            //判断是否达到“极限”
            if (point * point + offset > x && point * point - offset < x)
                break;
            //大了，改变跳跃上界
            if (point * point > x) {
                r = point;
                point = (r + l) / 2;
            }
            //小了，改变跳跃下界
            else if (point * point < x) {
                l = point;
                point = (r + l) / 2;
            }
        }
        return (int) point;
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int lengthOfLastWord(String s) {
        return s.trim().length()-1-s.trim().lastIndexOf(" ");
    }

    public int searchInsert(int[] nums, int target) {//二分法
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(nums[length-1] < target){
            return length;
        }
        int left = 0;
        int right = length - 1;
        while(left < right){
            int mid = left + (right - left)/2;//左中位数left + (right - left)/2 右中位数left + (right - left + 1)/2
            if(nums[mid] < target){
                left = mid + 1;//不包含mid
            }else{
                right = mid;   //包含mid 右边界包含左中位 左边界包含右中位  这样才会收缩
            }
        }
        return left;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int length = nums.length;
        if(length == 1){
            return 1;//0不用计算
        }
        //从1开始
        for(int i = 1;i < length;i++){
            //和上一个不一样
            if(nums[i] != nums[i-1]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            char now = s.charAt(i);
            if(map.containsKey(now)) {//当前字符是否反括号
                //是则与list最后一位进行比对  匹配则移除并继续 不匹配则返回false
                if(!list.isEmpty() && map.get(now) == list.get(list.size() - 1)){
                    list.remove(list.size() - 1);
                    continue;
                }else{
                    return false;
                }
            }else{
                //不是则加入list
                list.add(now);
            }
        }
        return list.isEmpty();
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0){
            return "";
        }
        String temp = strs[0];//公共部分
        for(int i = 1;i < length;i++){//从第二个字符串开始
           int tempLength = temp.length();
           for(int j = 0;j < tempLength;j++){
               if(strs[i].indexOf(temp) == 0){
                   break;
               }else{
                   temp = temp.substring(0,temp.length()-1);
               }
           }
        }
        return temp;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     *
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                rev = 0;
                break;
            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            int findNum = target - nums[i];
            for(int j = i +1;j < nums.length;j++){
                if(findNum ==  nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder bf = new StringBuilder();
        List<String> result = new ArrayList<>();
        findLeaf(root,"",result);
        return result;
    }

    private void findLeaf(TreeNode root,String path,List<String> result){
        if(root != null){
            //先记录当前路径
            path += root.val;
            if(root.left == null && root.right == null){//叶子
                //先保存
                result.add(path.toString());
            }else{
                path += "->";
                findLeaf(root.left,path,result);
                findLeaf(root.right,path,result);
            }
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        //先找最左边
        TreeNode left = invertTree(root.left);
        //再找最右边
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> num = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(num.containsKey(nums[i])){
                return true;
            }else{
                num.put(nums[i],i);
            }
        }
        return false;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> num = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(num.containsKey(nums[i])){
              if(i - num.get(nums[i]) <= k){
                  return true;
              }else{
                  num.put(nums[i],i);
              }
            }else{
                num.put(nums[i],i);
            }
        }
        return false;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Map<String,ListNode> result = new HashMap<>();
        reverseListAndGetFirst(head,result);
        return result.get("RESULT");
    }

    private ListNode reverseListAndGetFirst(ListNode head,Map<String,ListNode> result){
        if(head == null){
            return null;
        }
        ListNode temp = reverseListAndGetFirst(head.next,result);//得到顺序的下一个节点  待会要变成倒序
        head.next = null;//初始化为NULL
        if(temp != null){
            temp.next = head;//下一个节点倒序
        }else{
            result.put("RESULT",head);
        }
        return head;
    }

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 示例 1:
     *
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "foo", t = "bar"
     * 输出: false
     * 示例 3:
     *
     * 输入: s = "paper", t = "title"
     * 输出: true
     * 说明:
     * 你可以假设 s 和 t 具有相同的长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/isomorphic-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        for(int i = 0;i < s.length();i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }


    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }

    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * 示例 1:
     *
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * 示例 2:
     *
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        if(n == 0){
            return 0;
        }
        BigInteger b = Factorial(new BigInteger(String.valueOf(n)));
        int count = 0;
        BigInteger b10 = new BigInteger(String.valueOf(10));
        BigInteger b0 = new BigInteger(String.valueOf(0));
        while (b.mod(b10).equals(b0)){
            count++;
            b = b.divide(b10);
        }
        return count;
    }

    private BigInteger Factorial(BigInteger num){
        if(num.equals(new BigInteger("1"))){
            return num;
        }
        return num.multiply(Factorial(num.subtract(new BigInteger("1"))));
    }

    /**
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
     *
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     *
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     *
     * 示例 1:
     *
     * 输入: secret = "1807", guess = "7810"
     *
     * 输出: "1A3B"
     *
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * 示例 2:
     *
     * 输入: secret = "1123", guess = "0111"
     *
     * 输出: "1A1B"
     *
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bulls-and-cows
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int[] bucket = new int[10];
        int bull = 0;
        int cow = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)== guess.charAt(i)){
                bull++;
                continue;
            }
            bucket[secret.charAt(i) - '0'] += 1;
            bucket[guess.charAt(i) - '0'] -= 1;

        }
        //计算bucket中正值的个数
        for(int i=0;i<10;i++){
            if(bucket[i] > 0)
                cow+= bucket[i];
        }

        cow = secret.length() - cow - bull;
        String res = bull + "A" + cow + "B";
        return res;
    }


    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     *
     * 例如，
     *
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     * 示例 1:
     *
     * 输入: "A"
     * 输出: 1
     * 示例 2:
     *
     * 输入: "AB"
     * 输出: 28
     * 示例 3:
     *
     * 输入: "ZY"
     * 输出: 701
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0;i < s.length();i++){//倒着
            char tempChar = s.charAt(i);
            int tempInt = tempChar - 'A' + 1;
            result = result * 26 + tempInt;
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> counts = new HashMap<>();
        for(int num : nums){
            if(!counts.containsKey(num)){
                counts.put(num,length-1);//初始化为num 数组长度-1   众数一定是小于数组长度/2
            }else{
                counts.put(num,counts.get(num) - 1);//-1
            }
        }
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(entry.getValue() <=  length/2 ){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * 例如，
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * 示例 1:
     *
     * 输入: 1
     * 输出: "A"
     * 示例 2:
     *
     * 输入: 28
     * 输出: "AB"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        List<Character> chars = new ArrayList<>();
        while(n > 0){
            int mod = 65 + --n % 26;//A - Z  下次循环是AA  所以类似从1开始而不是0，要减一
            char modChar = (char)mod;
            chars.add(modChar);
            n /= 26;//往上进一位
        }
        Collections.reverse(chars);
        StringBuilder builder = new StringBuilder(chars.size());
        for(Character ch: chars)
        {
            builder.append(ch);
        }
        return builder.toString();
    }


    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> exsit =  new HashSet<ListNode>();
        while(head != null){
            if(exsit.contains(head)){
                return true;
            }
            exsit.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/single-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i+=2){
            if(i == nums.length - 1 || nums[i] != nums[i+1]){//奇数偶数对比
                //不一样的用奇数
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0){
            return triangle;
        }
        //初始化第一行为1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        //通过已知的一行求出所有的行
        for(int index = 1;index < numRows;index++){
            //前一行
            List<Integer> preRow = triangle.get(index-1);
            //新的一行
            List<Integer> row = new ArrayList<>();
            //新的一行首元素必定是1
            row.add(1);
            //开始计算每一个元素
            for(int i = 1;i < preRow.size();i++){
                row.add(preRow.get(i) + preRow.get(i-1));
            }
            //最末尾加上1
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        boolean left = false;
        boolean right = false;
        int diff = sum - root.val;//一直减下去  直到为0
        if(root.right == null && root.left == null){//叶子节点
            return diff == 0;
        }
        left = hasPathSum(root.left,diff);
        right = hasPathSum(root.right,diff);
        return left || right;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return balancedPath(root) != -1;
    }

    public int balancedPath(TreeNode root) {//计算平衡二叉树
        if(root == null){
            return 0;//从叶子节点计算起
        }
        int left = balancedPath(root.left);
        if(left == -1) return -1;
        int right = balancedPath(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) >= 2 ? -1 : left > right ? ++left : ++right;
    }

    public int maxPath(TreeNode root) {//计算二叉树最大深度
        if(root == null){
            return 0;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        return left > right ? ++left : ++ right;
    }

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int left,int right) {
        if(left == right) {//左右重叠即为叶子节点
            return null;
        }
        int mid = left + (right - left) / 2;//计算中点 左中位
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = sortedArrayToBST(nums,left,mid);
        midNode.right = sortedArrayToBST(nums,mid+1,right);
        return midNode;
    }

    public int[] fraction(int[] cont) {
        /**
         * [1,2,3,4]  ->                      1
         *                  1       +    ----------------------
         *                                            1
         *                                 2  +   -------------
         *                                                  1
         *                                          3 +  --------
         *                                                  4
         *
         *   定义分子分母数组ans,下标0分子 1分母,对应 + 号右边那一截 1/n
         *   假设初始为    1/4   ans[0]=1   ans[1]=4
         *   下次计算时   1/(3+1/4) ->  4/(4*3+1)
         *              1/ (count[i]+ans[0]/ans[1]) -> ans[1]/(ans[1]*count[i]+ans[0])
         *   ans[1] = ans[1] * cont[i] + ans[0]
         *   ans[0] = 原本ans[1]
         *
         *   简单说就是每次计算1/(count[i]+ans[0]/ans[1])
         *   但是最后答案   1 + 1/m 等价于count[i]+ans[0]/ans[1]
         *   相当于不用把分子分母互换，所以把多交换的一次再换一次，负负得正抵消掉
         */
        int[] ans = new int[]{1,1};//0分子 1分母
        int length = cont.length;
        ans[1] = cont[length - 1];//初始化分母为最后一位
        for(int i = cont.length - 2;i >= 0;i--){
            int temp = ans[1];
            ans[1] = ans[1] * cont[i] + ans[0];
            ans[0] = temp;
        }
        int temp = ans[0];
        ans[0] = ans[1];
        ans[1] = temp;
        return ans;
    }

    /**
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
     *
     *  
     *
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：guess = [1,2,3], answer = [1,2,3]
     * 输出：3
     * 解释：小A 每次都猜对了。
     *  
     *
     * 示例 2：
     *
     * 输入：guess = [2,2,3], answer = [3,2,1]
     * 输出：1
     * 解释：小A 只猜对了第二次。
     *  
     *
     * 限制：
     *
     * guess的长度 = 3
     * answer的长度 = 3
     * guess的元素取值为 {1, 2, 3} 之一。
     * answer的元素取值为 {1, 2, 3} 之一。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/guess-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for(int i = 0;i < guess.length;i++){
            if(answer[i] - guess[i] == 0){
                ans++;
                continue;
            }
        }
        return ans;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] arry = new int[grid.length * grid[0].length];//展开成一维 并移动K
//        //对一维进行移动K
//        int[] temp = new int[k];
//        for(int i = arry.length - k;i < arry.length;i++){//先将后K位保存到临时数组
//            temp[arry.length - i] = arry[i];
//        }
//        for(int j = arry.length - k - 1;j >= 0;j--){//前面位数全部往后移动K
//            arry[j+k] = arry[j];
//        }
//        for(int n = 0;n < temp.length;n++){//把临时数组填充到前K位
//            arry[n] = temp[n];
//        }
        for(int i = 0;i < grid.length;i++) {
            for(int j = 0;j < grid[0].length;j++) {
                //每次循环最后K++ K最后为二维数组长度+K-1，故取余为K-1
                k %= arry.length;
                arry[k++] = grid[i][j];
            }
        }
        //还原成二维
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row;
        for(int i = 0;i < grid.length;i++){
            row = new ArrayList<>();
            for(int j = 0;j < grid[0].length;j++){
                row.add(arry[index++]);
            }
            result.add(row);
        }
        return result;
    }

    /**
     * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
     *
     * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     *
     * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
     *
     * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
     * 输出：6
     * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
     * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
     * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells(int n, int m, int[][] indices) {
        //记录每一行一列的出现次数，最后进行单数的判断，反正每次都是加一
        int row[] = new int[n];
        int col[] = new int[m];
        //统计次数
        for(int[] rowArry : indices){
            row[rowArry[0]]++;
            col[rowArry[1]]++;
        }
        //计算单数数量
        int count = 0;
        for(int i = 0;i< row.length;i++){
            for(int j = 0;j < col.length;j++){
                if((row[i] + col[j])%2 != 0){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        float x = (coordinates[1][0] - coordinates[0][0]);
        if(x == 0)return false;
        float y = (coordinates[1][1] - coordinates[0][1]);
        float k = y/x;//斜率
        for(int i = 2;i < coordinates.length;i++){
            float tempX = (coordinates[i][0] - coordinates[i-1][0]);
            if(tempX == 0)return false;
            float tempY = (coordinates[i][1] - coordinates[i-1][1]);
            float tempK = tempY/tempX;
            if(tempK != k){
                return false;
            }
        }
        return true;
    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int stack = 0;//L -1  R +1
        for(int i = 0;i < s.length();i++){
            char current = s.charAt(i);
            if('L' == current){
                stack--;
            }
            if('R' == current){
                stack++;
            }
            if(stack == 0){
                count++;
            }
        }
        return count;
    }

    /**
     * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
     *
     * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
     *
     * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
     * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
     * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
     *
     * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：chips = [1,2,3]
     * 输出：1
     * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/play-with-chips
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param chips
     * @return
     */
    public int minCostToMoveChips(int[] chips) {
        //奇数位移动奇数位 偶数位移动偶数位均为0代价，其余为1代价
        //因此只要统计偶数和奇数个数，少的移动到多的位置，代价最少
        //实际就是统计偶数和奇数个数，选出最少的
        int odd = 0;
        int even = 0;
        for(int i = 0;i < chips.length;i++){
            if(chips[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return odd > even ? even : odd;
    }

    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     *
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * 示例 2：
     *
     * 输入：arr = [1,2]
     * 输出：false
     * 示例 3：
     *
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if (countMap.containsKey(arr[i])){
                countMap.put(arr[i],countMap.get(arr[i])+1);
            }else{
                countMap.put(arr[i],1);
            }
        }
        Set<Map.Entry<Integer,Integer>> kV = countMap.entrySet();
        Iterator<Map.Entry<Integer,Integer>> it = kV.iterator();
        List<Integer> l = new ArrayList<>();
        while(it.hasNext()){
            int now = it.next().getValue();
            if(l.contains(now)) return false;
            l.add(now);
        }
        return true;
    }

    /**
     * 给你个整数数组 arr，其中每个元素都 不相同。
     *
     * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [4,2,1,3]
     * 输出：[[1,2],[2,3],[3,4]]
     * 示例 2：
     *
     * 输入：arr = [1,3,6,10,15]
     * 输出：[[1,3]]
     * 示例 3：
     *
     * 输入：arr = [3,8,-10,23,19,-4,-14,27]
     * 输出：[[-14,-10],[19,23],[23,27]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Math.abs(arr[1] - arr[0]);//记录最小绝对差  默认下标 0 1
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        for(int i = 1;i < arr.length;i++){
            int diff = Math.abs(arr[i] - arr[i-1]);
            if(diff == min){//是最小差
                elements = new ArrayList<>();
                elements.add(arr[i-1]);
                elements.add(arr[i]);
                result.add(elements);
            }else if(diff < min){
                result.clear();
                min = diff;
                elements = new ArrayList<>();
                elements.add(arr[i-1]);
                elements.add(arr[i]);
                result.add(elements);
            }
        }
        return result;
    }

    /**
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     *
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     *
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     *
     *  
     *
     * 示例 :
     *
     * 输入:
     * [[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     * 输出: 16
     *
     * 解释: 它的周长是下面图片中的 16 个黄色的边：
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/island-perimeter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int lines = 4;
                    //判断这个岛旁边连接了多少个岛
                    if(i > 0 && grid[i - 1][j] == 1) lines--;
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) lines--;
                    if(j > 0 && grid[i][j - 1] == 1) lines--;
                    if(j < grid[0].length - 1 && grid[i][j + 1] == 1) lines--;
                    sum += lines;
                }
            }
        }
        return sum;
    }
}
