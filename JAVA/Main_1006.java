import java.util.Scanner;


/**
 * by:os0day
 * title:PAT,乙等, 1006 换个格式输出整数 (15分)
 * date:2020-07-17
 */

/**
 * 1006 换个格式输出整数 (15分)
 * 让我们用字母 B 来表示“百”、字母 S 表示“十”，用 12...n 来表示不为零的个位数字 n（<10），换个格式来输出任一个不超过 3 位的正整数。例如 234 应该被输出为 BBSSS1234，因为它有 2 个“百”、3 个“十”、以及个位的 4。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，给出正整数 n（<1000）。
 *
 * 输出格式：
 * 每个测试用例的输出占一行，用规定的格式输出 n。
 *
 * 输入样例 1：
 * 234
 * 输出样例 1：
 * BBSSS1234
 * 输入样例 2：
 * 23
 * 输出样例 2：
 * SS123
 */
public class Main_1006 {
    static Scanner sc = new Scanner(System.in);
    static int inputNumbers;
    static String result = "";
    public static void main(String[] args) {
       while (sc.hasNext()){
           inputNumbers = sc.nextInt();
           if(inputNumbers<0||inputNumbers>999)break;
           String getNumberString = String.valueOf(inputNumbers);
           System.out.println(Change(getNumberString));
       }
    }
    static String Change(String getString){
        result = "";
       if(Integer.valueOf(getString)<10){
           for(int j = 0; j < Integer.valueOf(getString); j++){
               result+=""+(j+1);
           }
       }
       if(Integer.valueOf(getString)<100&&Integer.valueOf(getString)>=10){
           for(int i = 0; i < getString.length(); i++){
               if(i == 0){
                   for(int j = 0; j < Integer.valueOf(getString.substring(i,i+1)); j++){
                       result+="S";
                   }
               }
               if(i == 1){
                   for(int j = 0; j < Integer.valueOf(getString.substring(i,i+1)); j++){
                       result+=""+(j+1);
                   }
               }
           }
       }
       if(Integer.valueOf(getString)>=100){
           for(int i = 0; i < getString.length(); i++){
               if(i == 0){
                   for(int j = 0; j < Integer.valueOf(getString.substring(i,i+1)); j++){
                       result+="B";
                   }
               }
               if(i == 1){
                   for(int j = 0; j < Integer.valueOf(getString.substring(i,i+1)); j++){
                       result+="S";
                   }
               }
               if(i == 2){
                   for(int j = 0; j < Integer.valueOf(getString.substring(i,i+1)); j++){
                       result+=""+(j+1);
                   }
               }
           }
       }
        return result;
    }
}
