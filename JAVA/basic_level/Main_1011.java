import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等,1011 A+B 和 C (15分)
 * date:2020-07-21
 */
public class Main_1011 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (sc.hasNext()){
        int num = sc.nextInt();
                if (num>10||num<0)break;
            for(int i = 1; i <= num; i++){
                System.out.println("Case #"+i+": "+Judgment(sc.nextLong(),sc.nextLong(),sc.nextLong()));
            }
        }
    }

    static String Judgment(long one,long two,long three){
        String result = "";
        //if(Integer.parseInt(one)+Integer.parseInt(two)>Integer.parseInt(three)){
        if(one+two>three){
            result = "true";
        }else
            result = "false";
        return result;
    }

}
/*
1011 A+B 和 C (15分)
给定区间 [−2
​31
​​ ,2
​31
​​ ] 内的 3 个整数 A、B 和 C，请判断 A+B 是否大于 C。

输入格式：
输入第 1 行给出正整数 T (≤10)，是测试用例的个数。随后给出 T 组测试用例，每组占一行，顺序给出 A、B 和 C。整数间以空格分隔。

输出格式：
对每组测试用例，在一行中输出 Case #X: true 如果 A+B>C，否则输出 Case #X: false，其中 X 是测试用例的编号（从 1 开始）。
 */