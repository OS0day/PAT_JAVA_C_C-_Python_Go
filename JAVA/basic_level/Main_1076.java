import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等,1076 Wifi密码 (15分)
 * date:2020-09-07
 */
public class Main_1076 {


    static String[] getStrings;
    static Scanner sc = new Scanner(System.in);
    static String result = "";
    public static void main(String[] args) {
        while (sc.hasNext()){
            int numbers = sc.nextInt();
            for(int i = 0; i < numbers; i++){
                getStrings = new String[4];
                for(int j = 0 ; j < 4 ; j++){
                    getStrings[j] = sc.next();
                }
                OutPut(getStrings);
            }
            System.out.println(result);
        }
    }
    static void OutPut(String[] getString){
        for(int i = 0; i <getString.length; i++){
            if(getString[i].substring(2,3).equals("T")){
                String temp = getString[i].substring(0,1);
                switch (temp){
                    case "A":result+=1+"";break;
                    case "B":result+=2+"";break;
                    case "C":result+=3+"";break;
                    case "D":result+=4+"";break;
                }
            }
        }
    }
}
/*

1076 Wifi密码 (15分)
下面是微博上流传的一张照片：“各位亲爱的同学们，鉴于大家有时需要使用 wifi，又怕耽误亲们的学习，现将 wifi 密码设置为下列数学题答案：A-1；B-2；C-3；D-4；请同学们自己作答，每两日一换。谢谢合作！！~”—— 老师们为了促进学生学习也是拼了…… 本题就要求你写程序把一系列题目的答案按照卷子上给出的对应关系翻译成 wifi 的密码。这里简单假设每道选择题都有 4 个选项，有且只有 1 个正确答案。

wifi.jpg

输入格式：
输入第一行给出一个正整数 N（≤ 100），随后 N 行，每行按照 编号-答案 的格式给出一道题的 4 个选项，T 表示正确选项，F 表示错误选项。选项间用空格分隔。

输出格式：
在一行中输出 wifi 密码。

输入样例：
8
A-T B-F C-F D-F
C-T B-F A-F D-F
A-F D-F C-F B-T
B-T A-F C-F D-F
B-F D-T A-F C-F
A-T C-F B-F D-F
D-T B-F C-F A-F
C-T A-F B-F D-F
输出样例：
13224143
 */