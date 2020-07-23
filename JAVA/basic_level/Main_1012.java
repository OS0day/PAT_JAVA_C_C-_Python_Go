import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等,1012 数字分类 (20分)
 * date:2020-07-23
 */
public class Main_1012 {
    static Scanner sc = new Scanner(System.in);
    static int count = 0,count2 = 0;
    static int A1_result = 0;
    static int A2_result = 0;
    static int A3_result = 0;
    static double A4_result = 0;
    static int A5_result = 0;
    public static void main(String[] args) {
        while (sc.hasNext()){
            int inputNumber = sc.nextInt();
            if (inputNumber>1000||inputNumber<0)break;
            init();
            inPut(inputNumber);
            outPut();
        }
    }
    static void inPut(int inputNumber){
        for(int i = 0; i < inputNumber; i++){
            add(sc.nextInt());
        }
    }
    static void init(){
        A1_result = 0;
        A2_result = 0;
        A3_result = 0;
        A4_result = 0.0;
        A5_result = 0;
        count = 0;
        count2 = 0;
    }
    static void outPut(){
        String result = "";
        DecimalFormat df = new DecimalFormat("##.0");
        System.out.println((A1_result!=0?A1_result:"N")+" "+(count!=0?A2_result:"N")+" "+(A3_result!=0?""+A3_result:"N")+" "+(A4_result!=0?""+df.format(A4_result/count2):"N")+" "+(A5_result!=0?""+A5_result:"N"));
    }
    static void add(int number){
        if(number%5==0&&number%2==0){
            A1_result+=number;
        }else if(number%5==1){
            count++;
            if(count%2!=0)
                    A2_result+=number;
                else
                    A2_result-=number;
        }else if(number%5==2){
            A3_result++;
        }else if(number%5==3){
            count2++;
            A4_result+=number;
        }else if(number%5==4){
            if(number>A5_result)
                A5_result = number;
        }
    }
}
/*

1012 数字分类 (20分)
给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：

A
​1
​​  = 能被 5 整除的数字中所有偶数的和；
A
​2
​​  = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n
​1
​​ −n
​2
​​ +n
​3
​​ −n
​4
​​ ⋯；
A
​3
​​  = 被 5 除后余 2 的数字的个数；
A
​4
​​  = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
A
​5
​​  = 被 5 除后余 4 的数字中最大数字。
输入格式：
每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。

输出格式：
对给定的 N 个正整数，按题目要求计算 A
​1
​​ ~A
​5
​​  并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。

若其中某一类数字不存在，则在相应位置输出 N。

输入样例 1：
13 1 2 3 4 5 6 7 8 9 10 20 16 18
输出样例 1：
30 11 2 9.7 9
输入样例 2：
8 1 2 4 5 6 7 9 16
输出样例 2：
N 11 2 N 9
 */