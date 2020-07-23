import java.util.Scanner;
/**
 * by:os0day
 * title:PAT,乙等,1021 个位数统计 (15分)
 * date:2020-07-23
 */
public class Main_1021 {
    static Scanner sc = new Scanner(System.in);
    static int[] num;
    public static void main(String[] args) {
        while (sc.hasNext()){

            String inputString = sc.nextLine();
            if (inputString.length()>1000||inputString.isEmpty())break;
            num =new int[10];
            Add(inputString);
            outPut(10);
        }
    }
    static void Add(String getString){
        for (int i = 0; i < getString.length(); i++){
            //System.out.println(getString.substring(i,i+1));
            num[Integer.parseInt(getString.substring(i,i+1))]++;

        }
    }
    static void outPut(int length){
        for (int i = 0; i < length; i++){
            if(num[i]!=0)
            System.out.println(i+":"+num[i]);
        }
    }
}
/*
1021 个位数统计 (15分)
给定一个 k 位整数 N=d
​k−1
​​ 10
​k−1
​​ +⋯+d
​1
​​ 10
​1
​​ +d
​0
​​  (0≤d
​i
​​ ≤9, i=0,⋯,k−1, d
​k−1
​​ >0)，请编写程序统计每种不同的个位数字出现的次数。例如：给定 N=100311，则有 2 个 0，3 个 1，和 1 个 3。

输入格式：
每个输入包含 1 个测试用例，即一个不超过 1000 位的正整数 N。

输出格式：
对 N 中每一种不同的个位数字，以 D:M 的格式在一行中输出该位数字 D 及其在 N 中出现的次数 M。要求按 D 的升序输出。

输入样例：
100311
输出样例：
0:2
1:3
3:1
 */