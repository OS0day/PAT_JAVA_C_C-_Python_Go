import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等,1001 害死人不偿命的(3n+1)猜想 (15分)
 * date:2020-07-14
 */

/**
 * 1001 害死人不偿命的(3n+1)猜想 (15分)
 * 卡拉兹(Callatz)猜想：
 *
 * 对任何一个正整数 n，如果它是偶数，那么把它砍掉一半；如果它是奇数，那么把 (3n+1) 砍掉一半。这样一直反复砍下去，最后一定在某一步得到 n=1。卡拉兹在 1950 年的世界数学家大会上公布了这个猜想，传说当时耶鲁大学师生齐动员，拼命想证明这个貌似很傻很天真的命题，结果闹得学生们无心学业，一心只证 (3n+1)，以至于有人说这是一个阴谋，卡拉兹是在蓄意延缓美国数学界教学与科研的进展……
 *
 * 我们今天的题目不是证明卡拉兹猜想，而是对给定的任一不超过 1000 的正整数 n，简单地数一下，需要多少步（砍几下）才能得到 n=1？
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出正整数 n 的值。
 *
 * 输出格式：
 * 输出从 n 计算到 1 需要的步数。
 *
 * 输入样例：
 * 3
 * 输出样例：
 * 5
 */
public class Main_1001 {

    static int count = 0;
    static int num ;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (sc.hasNext()){
            Halve(sc.nextInt());
            System.out.println(count-1);
        }
    }

    /**
     * @title halve递归奇数偶数分类减半方法
     * @param number
     * @return int
     *
     */
    static int Halve(int number) {
        count++;
        if (number==1) {
            return 0;
        }
        else if(number%2==0){
            return Halve(number/2)+1;
        }else{
            return Halve((number*3+1)/2)+1;
        }
    }
}
