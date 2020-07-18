import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等，1003 我要通过！ (20分)
 * date:2020-07-15
 */

/**
 * 1003 我要通过！ (20分)
 * “答案正确”是自动判题系统给出的最令人欢喜的回复。本题属于 PAT 的“答案正确”大派送 —— 只要读入的字符串满足下列条件，系统就输出“答案正确”，否则输出“答案错误”。
 *
 * 得到“答案正确”的条件是：
 *
 * 字符串中必须仅有 P、 A、 T这三种字符，不可以包含其它字符；
 * 任意形如 xPATx 的字符串都可以获得“答案正确”，其中 x 或者是空字符串，或者是仅由字母 A 组成的字符串；
 * 如果 aPbTc 是正确的，那么 aPbATca 也是正确的，其中 a、 b、 c 均或者是空字符串，或者是仅由字母 A 组成的字符串。
 * 现在就请你为 PAT 写一个自动裁判程序，判定哪些字符串是可以获得“答案正确”的。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例。第 1 行给出一个正整数 n (<10)，是需要检测的字符串个数。接下来每个字符串占一行，字符串长度不超过 100，且不包含空格。
 *
 * 输出格式：
 * 每个字符串的检测结果占一行，如果该字符串可以获得“答案正确”，则输出 YES，否则输出 NO。
 *
 * 输入样例：
 * 8
 * PAT
 * PAAT
 * AAPATAA
 * AAPAATAAAA
 * xPATx
 * PT
 * Whatever
 * APAAATAA
 * 输出样例：
 * YES
 * YES
 * YES
 * YES
 * NO
 * NO
 * NO
 * NO
 */
public class Main_1003 {

    static Scanner sc = new Scanner(System.in);
    static String result = "";
    static String[] word = {"P","A","T"};
    static int inputNumbers;
    static String inputStrings = "";
    public static void main(String[] args ){
        while (sc.hasNext()){
            inputNumbers = sc.nextInt();
            if(inputNumbers>10||inputStrings.length()>100)
                break;
            for(int i = 0;i<inputNumbers;i++) {
                inputStrings = sc.next();
                System.out.println(OptimizationJugement(inputStrings));
            }
        }
    }

    /**
     *
     * 完善判断机制
     * @param getString
     * @return String
     */
    static String OptimizationJugement(String getString){
        int ANumbers_Q = 0,ANumbers_Z = 0,ANumbers_H = 0;//前中后A的数量
        int P,A,T; P = A = T = 0;  //输入的字符串中，P、A、T的数量
        int sw = 1;
        int flag = 1;
        for(int i = 0;i < getString.length();i++){
            String tempString = getString.substring(i,i+1);
            if(tempString.equals("P")){
                P++;
                sw = 2;
            }else if(tempString.equals("A")) {
                A++;
            }else if (tempString.equals("T")){
                T++;
                sw = 3;
            }else {
                flag = 0;
            }
            switch (sw){
                case 1:if(tempString.equals("A"))ANumbers_Q++;break;
                case 2:if(tempString.equals("A"))ANumbers_Z++;break;
                case 3:if(tempString.equals("A"))ANumbers_H++;break;
            }
        }
        //System.out.println(P+" "+A+" "+T+" "+ANumbers_Q+" "+ANumbers_Z+" "+ANumbers_H);
        if(P == 1 && T == 1 && A>=1 && (ANumbers_Q*ANumbers_Z == ANumbers_H) && flag==1){
            result = "YES";
        }else {
            result = "NO";
        }
        return result;
    }

    /**
     *
     * title:判断字符构成的方法
     * @param getString
     * @return String
     */
    static String Jugement(String getString){
        JugeClass jc = new JugeClass();
        int i = 0;
        for(i = 0;i < getString.length();i++){
            if(!(getString.substring(i,i+1).equals("P")||getString.substring(i,i+1).equals("T")||getString.substring(i,i+1).equals("A"))){
                result = jc.getNo();
                break;
            }
        }
        if(i==getString.length()){
            result = jc.getYes();
        }
        return result;
    }
}
class JugeClass{
    String yes;
    String no;

    public JugeClass() {
        this.yes = "YES";
        this.no = "NO";
    }

    public String getYes() {
        return yes;
    }

    public String getNo() {
        return no;
    }
}
