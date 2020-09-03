import java.util.Scanner;


/**
 * by:os0day
 * title:PAT,乙等,1091 N-自守数 (15分)
 * date:2020-09-03
 */
public class Main_1091 {


    static Scanner sc = new Scanner(System.in);
    static int M;

    public static void main(String[] args) {
        while (sc.hasNext()) {
            M = sc.nextInt();
            while (M>0){
                System.out.println(OutPut(sc.nextInt()));
            }
        }
    }
    static String OutPut(int number){
        String result = "";
        int flag = 0;
        for(int i = 1; i <= 10; i++){
           String tempString = String.valueOf(i*number*number);
           if(tempString.substring(tempString.length()-String.valueOf(number).length(),tempString.length()).equals(""+number)){
                result = i+" "+tempString;
                flag = 1;
                break;
           }
        }
        if (flag==0){
            result = "No";
        }
        return result;
    }

}
/*

1091 N-自守数 (15分)
如果某个数 K 的平方乘以 N 以后，结果的末尾几位数等于 K，那么就称这个数为“N-自守数”。例如 3×92
​2
​​ =25392，而 25392 的末尾两位正好是 92，所以 92 是一个 3-自守数。

本题就请你编写程序判断一个给定的数字是否关于某个 N 是 N-自守数。

输入格式：
输入在第一行中给出正整数 M（≤20），随后一行给出 M 个待检测的、不超过 1000 的正整数。

输出格式：
对每个需要检测的数字，如果它是 N-自守数就在一行中输出最小的 N 和 NK
​2
​​  的值，以一个空格隔开；否则输出 No。注意题目保证 N<10。

输入样例：
3
92 5 233
输出样例：
3 25392
1 25
No
 */