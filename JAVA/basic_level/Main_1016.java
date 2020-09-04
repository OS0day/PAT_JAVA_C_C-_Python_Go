import java.util.Scanner;

/**
 * by:os0day
 * title:PAT,乙等,1016 部分A+B (15分)
 * date:2020-09-04
 */
public class Main_1016 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (sc.hasNext()){
            int numberA = sc.nextInt();
            int DA = sc.nextInt();
            int numberB = sc.nextInt();
            int DB = sc.nextInt();
            if (0<numberA&&numberA<Math.pow(10,10)&&0<numberB&&numberB<Math.pow(10,10))
                System.out.println(outPut(numberA+"", DA,numberB+"", DB));
            else
                break;
        }
    }

    static int outPut(String getString_a,int number_a, String getString_b,int number_b){
        int result = 0;
        String tempString_a  = "";
        for(int i = 0; i < getString_a.length(); i++){
            if(Integer.parseInt(getString_a.substring(i,i+1))==number_a){
                tempString_a+=getString_a.substring(i,i+1);
            }
        }
        String tempString_b  = "";
        for(int i = 0; i < getString_b.length(); i++){
            if((Integer.parseInt(getString_b.substring(i,i+1))==number_b)){
                tempString_b+=getString_b.substring(i,i+1);
            }
        }
        if (tempString_a.equals("")&&tempString_b.equals(""))
            result = 0;
        else
            result = Integer.parseInt(tempString_a)+Integer.parseInt(tempString_b);

        return result;
    }
}
/*
1016 部分A+B (15分)
正整数 A 的“D
​A
​​ （为 1 位整数）部分”定义为由 A 中所有 D
​A
​​  组成的新整数 P
​A
​​ 。例如：给定 A=3862767，D
​A
​​ =6，则 A 的“6 部分”P
​A
​​  是 66，因为 A 中有 2 个 6。

现给定 A、D
​A
​​ 、B、D
​B
​​ ，请编写程序计算 P
​A
​​ +P
​B
​​ 。

输入格式：
输入在一行中依次给出 A、D
​A
​​ 、B、D
​B
​​ ，中间以空格分隔，其中 0<A,B<10
​10
​​ 。

输出格式：
在一行中输出 P
​A
​​ +P
​B
​​  的值。

输入样例 1：
3862767 6 13530293 3
输出样例 1：
399
输入样例 2：
3862767 1 13530293 8
输出样例 2：
0
 */