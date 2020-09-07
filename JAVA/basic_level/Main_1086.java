import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


/**
 * by:os0day
 * title:PAT,乙等,1086 就不告诉你 (15分)
 * date:2020-09-04
 */
public class Main_1086 {

    static Scanner sc = new Scanner(System.in);
    static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        while (sc.hasNext()){
            int num = sc.nextInt();
            int mum = sc.nextInt();
            if (0<num&&num<=1000&&0<mum&&mum<=1000)
                outPut(""+num*mum);
            else
                break;

        }
    }
    static void outPut(String getStrings){
        for (int i = 0; i < getStrings.length(); i++){
            stack.push(Integer.parseInt(getStrings.substring(i,i+1)));
        }
        while (stack.size()>0){
                System.out.print(stack.pop()+"");
        }
        System.out.println();
    }
}
/*
1086 就不告诉你 (15分)
做作业的时候，邻座的小盆友问你：“五乘以七等于多少？”你应该不失礼貌地围笑着告诉他：“五十三。”本题就要求你，对任何一对给定的正整数，倒着输出它们的乘积。

53.jpg

输入格式：
输入在第一行给出两个不超过 1000 的正整数 A 和 B，其间以空格分隔。

输出格式：
在一行中倒着输出 A 和 B 的乘积。

输入样例：
5 7
输出样例：
53
 */