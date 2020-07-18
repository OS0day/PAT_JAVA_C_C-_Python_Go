import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * by:os0day
 * title:PAT,乙等,1005 继续(3n+1)猜想 (25分)
 * date:2020-07-16
 */

/**
 * 1005 继续(3n+1)猜想 (25分)
 * 卡拉兹(Callatz)猜想已经在1001中给出了描述。在这个题目里，情况稍微有些复杂。
 *
 * 当我们验证卡拉兹猜想的时候，为了避免重复计算，可以记录下递推过程中遇到的每一个数。例如对 n=3 进行验证的时候，我们需要计算 3、5、8、4、2、1，则当我们对 n=5、8、4、2 进行验证的时候，就可以直接判定卡拉兹猜想的真伪，而不需要重复计算，因为这 4 个数已经在验证3的时候遇到过了，我们称 5、8、4、2 是被 3“覆盖”的数。我们称一个数列中的某个数 n 为“关键数”，如果 n 不能被数列中的其他数字所覆盖。
 *
 * 现在给定一系列待验证的数字，我们只需要验证其中的几个关键数，就可以不必再重复验证余下的数字。你的任务就是找出这些关键数字，并按从大到小的顺序输出它们。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，第 1 行给出一个正整数 K (<100)，第 2 行给出 K 个互不相同的待验证的正整数 n (1<n≤100)的值，数字间用空格隔开。
 *
 * 输出格式：
 * 每个测试用例的输出占一行，按从大到小的顺序输出关键数字。数字间用 1 个空格隔开，但一行中最后一个数字后没有空格。
 *
 * 输入样例：
 * 6
 * 3 5 6 7 8 11
 * 输出样例：
 * 7 6
 */
public class Main_1005gai {
    static Scanner sc = new Scanner(System.in);
    static int inputNumber;
    static int[] numbers;

    public static void main(String[] args) {
        while (sc.hasNext()){
            inputNumber = sc.nextInt();
            if (inputNumber>100)break;
            numbers = new int[101];
            for(int i = 0; i < inputNumber; i++){
                int id = sc.nextInt();
                if(id>1&&id<=100){
                    numbers[id] = 1;
                }
            }
            for(int i = 2; i < 101; i++){
                if(numbers[i]>0){
                    int flag = i;
                    while (flag>1){
                        if (flag%2==0){
                            flag=flag/2;
                        }else{
                            flag = (flag*3+1)/2;
                        }
                        if(flag<=100&&numbers[flag]>0){
                            numbers[flag] = 0;
                            inputNumber--;
                            if (flag<i){
                                break;
                            }
                        }
                    }
                }
            }
            for(int i = 100; i>=2;i--){
                if(numbers[i]>0){
                    System.out.print(i);
                    if (inputNumber>1){
                        System.out.print(" ");
                        inputNumber--;
                    }
                }
            }
        }
    }
}
//C语言的方式
/**
 * #include <stdio.h>
 *
 *
 * int main() {
 *     int K, n, table[101] = {0};
 * 	int i;
 *     scanf("%d", &K);
 *     for (i = 0; i < K; i++) {
 *         scanf("%d", &n);
 *         table[n] = 1;
 *     }
 * //    寻找需要测试的数字，1<n≤100
 *     for (i = 2; i <= 100; i++) {
 *         if (table[i]) {
 *             int j = i;
 *             while (j > 1)
 *                        {
 * //               卡拉兹猜想计算过程，参考题目1001
 *                 if (j % 2) {
 *                     j = (3 * j + 1) / 2;
 *                 } else {
 *                     j = j / 2;
 *                 }
 *
 *                 //判断中间产生的j是否在要测试数组中
 *                 if (j <= 100 && table[j]) {
 * //                    免除j的测试
 *                     table[j] = 0;
 *                     K--;
 *                     if (j < i) {
 *                         //验证一个较大数字时，某一步计算得到一个较小数字（并且在初始给出的数字中），即可无须继续验证，因为与之前较小数重复
 * //                        不加此判断，当K值大时将大幅降低算法效率
 *                         break;
 *                     }
 *                 }
 *             }
 *         }
 *     }
 *
 * //    从大到小打印结果
 *     for (i = 100; i >= 2; i--) {
 *         if (table[i]) {
 *             printf("%d", i);
 *             if (K > 1) {
 *                 printf(" ");
 *                 K--;
 *             }
 *         }
 *     }
 *
 *     return 0;
 * }
 *
 *
 */
