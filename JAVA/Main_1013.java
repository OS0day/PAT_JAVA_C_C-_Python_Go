import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * by:os0day
 * title:PAT,乙等,1009 说反话 (20分)
 * date:2020-07-18
 */

/**
 * 1013 数素数 (20分)
 * 令 P
 * ​i
 * ​​  表示第 i 个素数。现任给两个正整数 M≤N≤10
 * ​4
 * ​​ ，请输出 P
 * ​M
 * ​​  到 P
 * ​N
 * ​​  的所有素数。
 *
 * 输入格式：
 * 输入在一行中给出 M 和 N，其间以空格分隔。
 *
 * 输出格式：
 * 输出从 P
 * ​M
 * ​​  到 P
 * ​N
 * ​​  的所有素数，每 10 个数字占 1 行，其间以空格分隔，但行末不得有多余空格。
 *
 * 输入样例：
 * 5 27
 * 输出样例：
 * 11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 */
public class Main_1013 {
    static Scanner sc = new Scanner(System.in);

    static List<Integer> numberList;
    static int inputNumberM,inputNumberN;
    public static void main(String[] args) {
        while (sc.hasNext()){
            inputNumberM = sc.nextInt();
            inputNumberN = sc.nextInt();
            if(inputNumberN<0||inputNumberN>10000||inputNumberM<0||inputNumberM>10000||(inputNumberM>inputNumberN)||inputNumberN==0||inputNumberM==0){break;}
            numberList = new ArrayList<Integer>();
            suShuList(inputNumberM,inputNumberN);
            System.out.println(numberList.size());
            for (int i = 0; i < numberList.size()-1; i++){
                if((i+1)%10==0){
                    System.out.println(numberList.get(i));
                }else {
                    System.out.print(numberList.get(i)+" ");
                }
            }
            System.out.println(numberList.get(numberList.size()-1));
        }
    }

    static void suShuList(int M,int N){
        int count = 0;
        for(int i = 2; i <= 10000; i++){
            int flag = 0;
            for(int j = 2; j < i; j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
           // System.out.println(i);
            if(flag==0){
                count++;
                if(count>=M&&count<=N)
                    numberList.add(i);
            }
            //System.out.println(1);
        }
    }

}
