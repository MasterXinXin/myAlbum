package cn.com.zhang.album.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *每个 Lambda 表达式都能隐式地赋值给函数式接口
 * 函数式接口指的是只有一个抽象方法的接口
 * (x,y)->{x+y}  返回x+y的和
 * ()里面是抽象方法的参数，{}是抽象方法实现
 * */
public class TestLambda {
    public static void main(String[] args) {
        //1.Runnable接口的lambda
        Runnable runnable = ()->{System.out.println(1);System.out.println(2);};
        runnable.run();
        //2.Thread
        Thread thread = new Thread(()->{System.out.println(1);System.out.println(2);});

        //3.列表List
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //3.1断言
        System.out.println("偶数:");
        evaluate(list, (n)-> n%2 == 0 );
        //3.2遍历打印
        System.out.println("遍历打印:");
        list.forEach(System.out::println);
        //3.3遍历乘方并打印
        System.out.println("遍历乘方打印:");
        list.stream().map((x) -> x*x).forEach((num)->System.out.println(num));

        //4.数组比较
        String[]atp = {"Rafael Nadal","Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        System.out.println("数组比较:");
        Arrays.sort(atp, (String s1, String s2) -> (s1.compareTo(s2)));
        Arrays.stream(atp).forEach(System.out::println);
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list)  {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
