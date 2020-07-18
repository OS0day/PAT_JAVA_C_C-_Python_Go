import sun.security.x509.AVA;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * by:os0day
 * title:PAT,乙等,1004 成绩排名 (20分)
 * date:2020-07-15
 */

/**
 * 1004 成绩排名 (20分)
 * 读入 n（>0）名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。
 *
 * 输入格式：
 * 每个测试输入包含 1 个测试用例，格式为
 *
 * 第 1 行：正整数 n
 * 第 2 行：第 1 个学生的姓名 学号 成绩
 * 第 3 行：第 2 个学生的姓名 学号 成绩
 *   ... ... ...
 * 第 n+1 行：第 n 个学生的姓名 学号 成绩
 * 其中姓名和学号均为不超过 10 个字符的字符串，成绩为 0 到 100 之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。
 *
 * 输出格式：
 * 对每个测试用例输出 2 行，第 1 行是成绩最高学生的姓名和学号，第 2 行是成绩最低学生的姓名和学号，字符串间有 1 空格。
 *
 * 输入样例：
 * 3
 * Joe Math990112 89
 * Mike CS991301 100
 * Mary EE990830 95
 * 输出样例：
 * Mike CS991301
 * Joe Math990112
 */
public class Main_1004 {

    static Scanner sc = new Scanner(System.in);
    static  int  inputNumbers;
    static String result;
    static List<Achievements> list = new ArrayList<Achievements>();
    public static void main(String[] args) {
        inputNumbers = sc.nextInt();
        while (sc.hasNext()){
            if (inputNumbers<0)break;
            for (int i = 0;i < inputNumbers;i++){
                String xm = sc.next();
                String xh = sc.next();
                int cj = sc.nextInt();
                if (xm.length()<=10&&xh.length()<=10&&cj>=0&&cj<=100) {
                    Achievements aas = new Achievements(xm, xh, cj);
                    list.add(aas);
                }
            }
            //quick(list);
//            System.out.println(list.get(list.size()-1).studentName+" "+list.get(list.size()-1).studentNumber);
//            System.out.println(list.get(0).studentName+" "+list.get(0).studentNumber);
            OptimizationSort(list);
        }

    }

    /////////  快速排序方法
    public static int getMiddle(List<Achievements> list, int low, int high) {
        int tmp = list.get(low).cj; // 数组的第一个值作为中轴（分界点或关键数据）
        while (low < high) {
            while (low < high && list.get(high).cj > tmp) {
                high--;
            }
            list.get(low).cj = list.get(high).cj; // 比中轴小的记录移到低端
            while (low < high && list.get(low).cj < tmp) {
                low++;
            }
            list.get(high).cj = list.get(low).cj; // 比中轴大的记录移到高端
        }
        list.get(low).cj = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }

    public static void unckSort(List<Achievements> list, int low, int high) {
        if(low < high) {
            int middle = getMiddle(list,low,high);    // 将list数组一分为二
            unckSort(list,low,middle-1);    // 对低字表进行递归排序
            unckSort(list,middle+1,high);    // 对高字表进行递归排序
        }
    }

    public static void quick(List<Achievements> str) {
        if(str.size() > 0) {
            // 查看数组是否为空
            unckSort(str,0,str.size()-1);
        }
    }
////////////////////



    static void OptimizationSort(List<Achievements> list){
        Achievements asMax = new Achievements();
        Achievements asMin = new Achievements();
        asMax = list.get(0);
        asMin = list.get(0);
        for (int i = 0;i<list.size();i++){
            if (asMax.getCj()<list.get(i).getCj()){
                asMax = list.get(i);
            }
            if (asMin.getCj()>list.get(i).getCj()){
                asMin = list.get(i);
            }
        }
        System.out.println(asMax.studentName+" "+asMax.studentNumber);
        System.out.println(asMin.studentName+" "+asMin.studentNumber);
    }

}
class Achievements{
    String studentName;
    String studentNumber;
    int cj;
    public Achievements() { }

    public Achievements(String studentName, String studentNumber, int cj) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.cj = cj;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getCj() {
        return cj;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setCj(int cj) {
        this.cj = cj;
    }

    @Override
    public String toString() {
        return "Achievements{" +
                "studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", cj='" + cj + '\'' +
                '}';
    }
}