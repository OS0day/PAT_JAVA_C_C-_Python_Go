import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等，1002 写出这个数 (20分)
 * date:2020-07-14
 */

/**
 * 1002 写出这个数 (20分)
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10
 * ​100
 * ​​ 。
 *
 * 输出格式：
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 *
 * 输入样例：
 * 1234567890987654321123456789
 * 输出样例：
 * yi san wu
 */

public class Main_1002 {
    static String[] spell = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
    static Scanner sc = new Scanner(System.in);
    static String result = "";
    public static void main(String[] args) {
        while (sc.hasNext()){
            //Output(BigNumberSum(sc.nextLine()));
            OptimizationOutput(BigNumberSum(sc.nextLine()));
            System.out.println(result.substring(0,result.length()-1));
        }
    }

    /**
     * @title 各个位数的和
     * @param number
     * @return
     */
    static  int BigNumberSum(String number){
        int sum = 0;
        for(int i = 0;i<number.length();i++){
            sum+=Integer.valueOf(number.substring(i,i+1));
        }
        return sum;
    }

    /**
     * title:优化输出的方法
     * @param number
     * @return
     */
    static String OptimizationOutput(int number){
        String numberString = String.valueOf(number);
        for (int i = 0;i<numberString.length();i++){
            int id = Integer.valueOf(numberString.substring(i,i+1));
            result +=spell[id]+" ";
        }
        return result;
    }


    /**
     * @Title 输出控制
     * @param number
     */
    static void Output(int number){
        String numberString = String.valueOf(number);
        for(int i = 0;i<numberString.length()-1;i++){
            for(int j = 0;j<spell.length;j++){
                if(Integer.parseInt(numberString.substring(i,i+1))==(j+1)){
                    System.out.print(spell[j+1]+" ");
                }
            }
        }
        for(int j = 0;j<spell.length;j++){
            if(Integer.parseInt(numberString.substring(numberString.length()-1,numberString.length()))==(j+1)){
                System.out.println(spell[j+1]);
            }
        }
    }
}
