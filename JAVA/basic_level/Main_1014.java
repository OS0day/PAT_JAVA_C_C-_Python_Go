import java.io.FileFilter;
import java.util.Scanner;



/**
 * by:os0day
 * title:PAT,乙等,1001 害死人不偿命的(3n+1)猜想 (15分)
 * date:2020-07-19
 */
public class Main_1014 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (sc.hasNext()){
            String getStringFirst = sc.nextLine();
            String getStringScend = sc.nextLine();
            String getStringThird = sc.nextLine();
            String getStringFord = sc.nextLine();
            if((!getStringFirst.equals(" ")&&!getStringScend.equals(" ")&&!getStringThird.equals(" ")&&!getStringFord.equals(" ")&&!getStringFirst.isEmpty()&&!getStringScend.isEmpty()&&!getStringThird.isEmpty()&&!getStringFord.isEmpty())&&getStringFirst.length()<=60&&getStringScend.length()<=60&&getStringThird.length()<=60&&getStringFord.length()<=60)
                System.out.println(timeDH(getStringFirst,getStringScend)+MM(getStringThird,getStringFord));
            else
                break;
        }
    }
    static String timeDH(String First,String Scend){
        int count = 0;
        int length;
        String DH = "";
        if(First.length()>Scend.length()){
            length = Scend.length();
        }else {
            length = First.length();
        }
        int flag = 0;
        for(int i = 0; i < length; i++){
            if(flag!=1&&First.substring(i,i+1).equals(Scend.substring(i,i+1))&&(First.substring(i,i+1).charAt(0)>='A'&&First.substring(i,i+1).charAt(0)<='G')){
                count++;
                  if (count==1){
                      flag = 1;
                      DH+=Day(First.substring(i,i+1))+" ";
                     // System.out.println("天"+DH);
                  }
            }else if(First.substring(i,i+1).equals(Scend.substring(i,i+1))&&flag==1&&((First.substring(i,i+1).charAt(0)>='A'&&First.substring(i,i+1).charAt(0)<='N')||(First.substring(i,i+1).charAt(0)>=48&&First.substring(i,i+1).charAt(0)<=57))) {
                count++;
               if(count==2){
                  // System.out.println(First.substring(i,i+1));
                   DH+=HH(First.substring(i,i+1));
                   flag = 0;
                 //  System.out.println("加上天"+DH);
                   break;
               }
            }
        }
       // System.out.println("天和小时"+DH);
        return DH;
    }

    static String Day(String d){
        String day = "";
        switch (d){
            case "A":day = "MON";break;
            case "B":day = "TUE";break;
            case "C":day = "WED";break;
            case "D":day = "THU";break;
            case "E":day = "FRI";break;
            case "F":day = "SAT";break;
            case "G":day = "SUN";break;
            default:break;
        }
        //System.out.println("天"+day);
        return day;
    }
    static String HH(String h){
       // Integer.
        //System.out.println(Integer.valueOf(h.charAt(0)));
        //注意，
       // Integer.parseInt()
       // Integer.valueOf()  的区别
        if(Integer.valueOf(h.charAt(0))>=48&&Integer.valueOf(h.charAt(0))<=57){
             h = "0"+h+":";
        }else if (Integer.valueOf(h.charAt(0))>=Integer.valueOf('A')&&Integer.valueOf(h.charAt(0))<=Integer.valueOf('N'))
        {
           for(int i = 65; i < Integer.valueOf('N')+1; i++){
               if(Integer.valueOf(h.charAt(0))==i){
                   if((i-55)==24){
                       h = "00:";
                   }else {
                       h = ""+(i-55)+":";
                   }
                   break;
               }
           }
        }
        //System.out.println("小时"+h);
        return h;
    }
    static String MM(String third,String fore){

        String m = "";
        int length;
        if(third.length()>fore.length()){
            length = fore.length();
        }else {
            length = third.length();
        }
        for(int i = 0; i < length; i++){
            if(third.substring(i,i+1).equals(fore.substring(i,i+1))&&((third.substring(i,i+1).charAt(0)>='A'&&third.substring(i,i+1).charAt(0)<='Z')
            ||(third.substring(i,i+1).charAt(0)>='a'&&third.substring(i,i+1).charAt(0)<='z'))){
               if(i>=0&&i<10){
                   m+="0"+i;
               }else if(i<60&&i>=10){
                   m+=""+i;
               }
                //System.out.println("分钟"+m);
               break;
            }
        }
        return m;
    }
}
/*
1014 福尔摩斯的约会 (20分)
大侦探福尔摩斯接到一张奇怪的字条：我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm。大侦探很快就明白了，字条上奇怪的乱码实际上就是约会的时间星期四 14:04，因为前面两字符串中第 1 对相同的大写英文字母（大小写有区分）是第 4 个字母 D，代表星期四；第 2 对相同的字符是 E ，那是第 5 个英文字母，代表一天里的第 14 个钟头（于是一天的 0 点到 23 点由数字 0 到 9、以及大写字母 A 到 N 表示）；后面两字符串第 1 对相同的英文字母 s 出现在第 4 个位置（从 0 开始计数）上，代表第 4 分钟。现给定两对字符串，请帮助福尔摩斯解码得到约会的时间。

输入格式：
输入在 4 行中分别给出 4 个非空、不包含空格、且长度不超过 60 的字符串。

输出格式：
在一行中输出约会的时间，格式为 DAY HH:MM，其中 DAY 是某星期的 3 字符缩写，即 MON 表示星期一，TUE 表示星期二，WED 表示星期三，THU 表示星期四，FRI 表示星期五，SAT 表示星期六，SUN 表示星期日。题目输入保证每个测试存在唯一解。

输入样例：
3485djDkxh4hhGE
2984akDfkkkkggEdsb
s&hgsfdk
d&Hyscvnm
输出样例：
THU 14:04

 */